package com.example.crudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudoperation.entity.Employ;
import com.example.crudoperation.repository.EmployRepo;

@Service
public class  EmployService {
	@Autowired
	private EmployRepo repository;
	//post
	public Employ saveEmploy(Employ employ)
	{
		return repository.save(employ);
	}
	public List<Employ> saveEmploys(List<Employ> employs)
	{
		return repository.saveAll(employs);
	}
	//get
	public List<Employ> getEmploys()
	{
		return repository.findAll();
	}
	public Employ getEmployById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	public Employ getEmployByName(String name)
	{
		return repository.findByName(name);
	}
	//delete
	public String deleteEmploy(int id)
	{
		repository.deleteById(id);
		return "Employ removed"+id;
	}
	//put
	public Employ updateEmploy(Employ employ)
	{
		Employ existingEmploy=repository.findById(employ.getId()).orElse(null);
		existingEmploy.setName(employ.getName());
		existingEmploy.setId(employ.getId());
		existingEmploy.setEmail(employ.getEmail());
		existingEmploy.setAbout(employ.getAbout());
		existingEmploy.setPassword(employ.getPassword());
		return repository.save(existingEmploy);
	}
}
