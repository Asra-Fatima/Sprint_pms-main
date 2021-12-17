package com.pms.in.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class AbstractUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	@Column(unique = true)
	private String userName;

	@Column
	private String password;

	public AbstractUser() {
		super();
	}

	public AbstractUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;

	}

	public AbstractUser(int uid, String userName, String password) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.password = password;

	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AppUser [uid=" + uid + ", userName=" + userName + ", password=" + password + "]";
	}

}
