package com.winify.shop.service;

import java.util.List;
import com.winify.shop.entity.Product;

public interface ProductService {
	List<Product> getAllProductsByUserName(String userName);
	void buyProduct(int productId);
}
