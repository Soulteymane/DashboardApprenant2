package com.dashboard.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.demo.model.Apprenant;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long>{

}
