package com.example.crudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudoperation.entity.Employ;
import com.example.crudoperation.service.EmployService;

@RestController
//talk to service class
public class Employcontroller {
	@Autowired
  private EmployService service;
	@PostMapping("/addemploy")
  public Employ addEmploy(@RequestBody Employ employ)
  {
	  return service.saveEmploy(employ);
  }
	@PostMapping("/addemploys")
  public List<Employ> addEmploys(@RequestBody List<Employ> employs)
  {
	  return service.saveEmploys(employs);
  }
	@GetMapping("/employs")
	 public List<Employ> findAllEmploys()
	  {
		  return service.getEmploys();	  
		}
	@GetMapping("/employ/{id}")
	public Employ findEmployById(@PathVariable int id)
	{
	  return service.getEmployById(id);	  
	  }
	@GetMapping("/employ/{name}")
	public Employ findEmployByName(@PathVariable String name)
	{
	  return service.getEmployByName(name);	  
	  }
	@PutMapping("/update")
	 public Employ updateEmploy(@RequestBody Employ employ)
	  {
		  return service.updateEmploy(employ);
	  }
	@DeleteMapping("/delete/{id}")
	 public String deleteEmploy(@PathVariable int  id)
	  {
		  return service.deleteEmploy(id);
	  }
	}
