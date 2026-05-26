package com.example.demo.presentation;

import com.example.demo.application.service.ProductService;
import com.example.demo.application.service.UserService;
import com.example.demo.domain.model.ProductData;
import com.example.demo.domain.model.UserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/product")
public class ProductPageController {
	
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showPageNotFound(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		response.setStatus(404);
		mv.setViewName("errors/pageNotFound");
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, params="productId")
	public ModelAndView showProductPage(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) {
		String requestProductId = request.getParameter("productId");
		ProductData product = productService.getProductInfo(requestProductId);
		if(product == null) {
			mv.setViewName("errors/productNotFound");
			return mv;
		}
		if(!product.getIsAvailable()) {
			mv.setViewName("errors/productNotAvailable");
			return mv;
		}
		mv.addObject("product", product);
		
		UserData user = userService.getUserInfo();
		Boolean isGuest = user.getIsGuest();
		mv.addObject("isGuest", isGuest);
		if (!isGuest) {
			mv.addObject("userName", user.getUserName());
			mv.addObject("availablePoint", user.getAvailablePoint());
		}
		
		mv.setViewName("product/productDetail");
		return mv;
	}
}
