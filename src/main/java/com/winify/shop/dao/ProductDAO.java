package com.winify.shop.dao;

import java.util.List;
import com.winify.shop.entity.Product;

public interface ProductDAO {
	 List<Product> findAllByUserName(String userName);
	 void updateProduct(Product product);
	 Product getProductById(int productId);
}
