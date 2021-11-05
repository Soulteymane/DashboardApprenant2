package com.dashboard.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dashboard.demo.model.ListPresence;

@Repository
public interface ListPresenceRepository extends JpaRepository<ListPresence, Long>{

}
