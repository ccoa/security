package com.occoa.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.occoa.security.dao.UserDao;
import com.occoa.security.model.User;
import com.occoa.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public void update(User user) throws Exception {
		userDao.update(
				user.getPhoneNumber(),
				user.getType(),
				user.getStatus(),
				user.getModificationDateTime(),
				user.getUsername());
	}

	@Override
	public User register(User user) throws Exception {
		return userDao.save(user);
	}

	@Override
	public void deleteByUsername(String username) throws Exception {
		userDao.deleteByUsername(username);
	}

	@Override
	public User findByUsername(String username) throws Exception {
		User user = userDao.findByUsername(username);
		
		return user;
	}
	
	@Override
	public void updatePasswordByUsername(String password, String username) throws Exception {
		userDao.updatePasswordByUsername(password, username);
	}

	@Override
	public void activate(String username, boolean activate) throws Exception {
		if (activate) {
			userDao.updateStatusByUsername(User.STATUS_ACTIVE, username);
		} else {
			userDao.updateStatusByUsername(User.STATUS_INACTIVE, username);
		}		
	}

}
