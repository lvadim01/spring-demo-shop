package com.winify.shop.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.winify.shop.entity.Product;
import com.winify.shop.dao.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public ProductDAOImpl (EntityManager theentityManager) {
		entityManager = theentityManager;
	}
	
	@Override
	@Transactional
	public List<Product> findAllByUserName(String userName) {
		Session currentSession = entityManager.unwrap(Session.class);	
		Query<Product> theQuery = 
				currentSession.createQuery("from Product product where product.user.username = :userName", Product.class);
		theQuery.setParameter("userName", userName);
		List<Product> products = theQuery.getResultList();
		return products;
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		Session currentSession = entityManager.unwrap(Session.class);	
		currentSession.merge(product);
	}
	
	@Override
	@Transactional
	public Product getProductById(int productId) {
		Session currentSession = entityManager.unwrap(Session.class);	
		Query<Product> theQuery = 
				currentSession.createQuery("from Product product where product.id = :productId", Product.class);
		theQuery.setParameter("productId", productId);
		
		Product product = theQuery.uniqueResult();
		return product;
	}	
}
