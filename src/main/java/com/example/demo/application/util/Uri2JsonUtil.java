package com.example.demo.application.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class Uri2JsonUtil {
	public JsonNode callApi(String uri) {
		return new RestTemplate().getForEntity(uri, JsonNode.class).getBody();
	}
}
