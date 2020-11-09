package com.winify.shop.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.winify.shop.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl (EntityManager theentityManager) {
		entityManager = theentityManager;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = 
				currentSession.createQuery("from User ", User.class);
		List<User> users = theQuery.getResultList();
		return users;
	}
}
