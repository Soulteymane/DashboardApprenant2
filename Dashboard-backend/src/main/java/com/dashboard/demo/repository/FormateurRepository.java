package com.dashboard.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.demo.model.Formateur;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {

}
