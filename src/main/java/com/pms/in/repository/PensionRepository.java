package com.pms.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.in.repository.PensionRepository;
import com.pms.in.entities.PensionDetails;

@Repository
public interface PensionRepository extends JpaRepository<PensionDetails, Integer> {

}
