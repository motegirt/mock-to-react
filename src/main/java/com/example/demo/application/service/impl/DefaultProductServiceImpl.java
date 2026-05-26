package com.example.demo.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.service.ProductService;
import com.example.demo.application.util.Uri2JsonUtil;
import com.example.demo.domain.model.ProductData;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class DefaultProductServiceImpl implements ProductService {
	@Autowired
	private Uri2JsonUtil jsonUtil;
	private final String PRODUCT_API_URL = "https://script.google.com/macros/s/AKfycbwQ3hcl0p4rcXKpkMseE1LFM-7uNfx3iogIV4pZkBbXW8CfDc2fPvuAun1ckJ4mXmKUQw/exec?productId=%s";
	
	@Override
	public ProductData getProductInfo(String productId) {
		if(isEmpty(productId)) {
			return null;
		}
		JsonNode json = jsonUtil.callApi(String.format(PRODUCT_API_URL, productId));
		ProductData productData = new ProductData();
		return convertJson2ProductData(json, productData);
	}
	
	private ProductData convertJson2ProductData(JsonNode json, ProductData data) {
		if(json == null) {
			return null;
		}
		JsonNode idNode = json.get("id");
		if(!isEmpty(idNode) && !isEmpty(idNode.asText())) {
			data.setId(idNode.asText());
		} 
		JsonNode nameNode = json.get("name");
		if(!isEmpty(nameNode) && !isEmpty(nameNode.asText())) {
			data.setProductName(nameNode.asText());
		}
		JsonNode descriptionNode = json.get("description");
		if(!isEmpty(descriptionNode) && !isEmpty(descriptionNode.asText())) {
			data.setProductDescription(descriptionNode.asText());
		}
		JsonNode priceNode = json.get("price");
		if(!isEmpty(priceNode) && !isZero(priceNode)) {
			data.setProductPrice(priceNode.asLong());
		}
		JsonNode imageUrlNode = json.get("imageUrl");
		if(!isEmpty(imageUrlNode) && !isEmpty(imageUrlNode.asText())) {
			data.setProductImageUrl(imageUrlNode.asText());
		}
		data.setIsAvailable(isAvailableProduct(data.getProductName(), data.getProductDescription(), data.getProductPrice()));;
		return data;
	}
	
	private boolean isAvailableProduct(String productName, String productDescription, Long price) {
		return !(isEmpty(productName) || isEmpty(productDescription) || isZero(price));
	}
	
	private boolean isEmpty(JsonNode json) {
		return json == null;
	}
	
	private boolean isEmpty(String str) {
		return str == null || str.equals("");
	}
	
	private boolean isZero(JsonNode l) {
		return l == null || !l.canConvertToLong() || l.asLong() == 0L;
	}
	
	private boolean isZero(Long l) {
		return l == null || l == 0L;
	}
}
