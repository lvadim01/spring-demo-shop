package com.winify.shop.dao;

import java.util.List;
import com.winify.shop.entity.User;

public interface UserDAO {
		List<User> findAll();
}
