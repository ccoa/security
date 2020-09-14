package com.occoa.security.service.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.occoa.security.dao.UserDao;
import com.occoa.security.model.User;
import com.occoa.security.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public void update(User user) {
		userDao.update(
				user.getPhoneNumber(),
				user.getType(),
				user.getStatus(),
				user.getModificationDateTime(),
				user.getUsername());
	}

	@Override
	public User register(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteByUsername(String username) {
		userDao.deleteByUsername(username);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	@Override
	public void updatePasswordByUsername(String password, String username) {
		userDao.updatePasswordByUsername(password, username);
	}

	@Override
	public void activate(String username, boolean activate) {
		if (activate) {
			userDao.updateStatusByUsername(User.STATUS_ACTIVE, username);
		} else {
			userDao.updateStatusByUsername(User.STATUS_INACTIVE, username);
		}		
	}

}
