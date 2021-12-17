package com.pms.in.service;

import com.pms.in.entities.Admin;

public interface IAdminService {

	public Admin login(String username, String password);

	public String logout(String adminName);
}
