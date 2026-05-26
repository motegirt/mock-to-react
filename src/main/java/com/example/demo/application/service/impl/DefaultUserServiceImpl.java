package com.example.demo.application.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.application.service.UserService;
import com.example.demo.domain.model.UserData;

@Service
public class DefaultUserServiceImpl implements UserService {
	// Haven't Fixed Yet.
	@Override
	public UserData getUserInfo() {
		//TODO: All user is guest.
		UserData currentUser = new UserData();
		currentUser.setIsGuest(true);
		return currentUser;
	}
}
