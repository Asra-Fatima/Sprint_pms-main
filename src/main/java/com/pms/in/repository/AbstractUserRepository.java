package com.pms.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.in.entities.AbstractUser;

@Repository
public interface AbstractUserRepository extends JpaRepository<AbstractUser, Integer> {

	public abstract AbstractUser findByUserName(String userName);

	public abstract AbstractUser findByPassword(String password);
}
