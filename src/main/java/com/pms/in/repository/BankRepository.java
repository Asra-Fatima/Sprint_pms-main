package com.pms.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.in.entities.BankDetails;

@Repository
public interface BankRepository extends JpaRepository<BankDetails, Long> {

}
