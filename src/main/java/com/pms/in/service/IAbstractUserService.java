package com.pms.in.service;

import com.pms.in.entities.AbstractUser;

public interface IAbstractUserService {

	public abstract AbstractUser login(String userName, String password);
	public abstract String logout(String userName);
}