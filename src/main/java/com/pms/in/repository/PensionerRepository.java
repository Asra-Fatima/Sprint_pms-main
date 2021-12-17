package com.pms.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.in.entities.PensionerDetails;

@Repository
public interface PensionerRepository extends JpaRepository<PensionerDetails, Integer> {

	public abstract PensionerDetails findByAadhar(int aadhar);

}
