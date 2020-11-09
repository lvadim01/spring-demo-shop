package com.winify.shop.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.winify.shop.dao.ProductDAO;
import com.winify.shop.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDao) {
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public List<Product> getAllProductsByUserName(String userName) {
		return productDao.findAllByUserName(userName);
	}

	@Override
	@Transactional
	public void buyProduct(int productId) {
		// @TODO
		// Add products to basket
		// Get user payment data
		// Process payment
		Product productToBuy = productDao.getProductById(productId);
		int currentStock = productToBuy.getStock();
		BigDecimal price = productToBuy.getPrice();
		BigDecimal currentMoney = productToBuy.getUser().getWallet();
		
		BigDecimal money = currentMoney.add(price);
		
		productToBuy.getUser().setWallet(money);
		productToBuy.setStock(currentStock - 1);
		
		productDao.updateProduct(productToBuy);
	}
}
