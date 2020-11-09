package com.winify.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.winify.shop.entity.Product;
import com.winify.shop.service.ProductService;

@Controller
@RequestMapping("/")
public class AppController {

	private ProductService productService;
	
	@Autowired
	public AppController(ProductService productService) {
			this.productService = productService;
	}
		
	@GetMapping("/listProducts")
	public String listProducts(Model theModel) {
		String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Product> products = productService.getAllProductsByUserName(loggedInUser);
	    theModel.addAttribute("productRecords", products);
	    theModel.addAttribute("user", products.get(0).getUser());
		return "home";
	}
	
	@GetMapping("/confirmPurchase")
	public String confirmPurchase(@RequestParam("productId") int productId, Model theModel) {
		theModel.addAttribute("productId", productId);
		return "confirm";
	}
	
	@GetMapping("/buyProduct")
	public String buytProduct(@RequestParam("productId") int productId, Model theModel) {
		productService.buyProduct(productId);
		return "redirect:/listProducts";
	}
}
