package com.example.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudoperation.entity.Employ;
@Repository
public interface EmployRepo extends JpaRepository<Employ, Integer>  {

	Employ findByName(String name);
	
}
