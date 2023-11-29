package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Dealership;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership, String> {

}
