package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService)
	{
		employeeService=theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		
		
		return employeeService.findAll();
		
	}
	
	
	@GetMapping("/employees/{employeeId}")
	
	public Employee getemployee(@PathVariable int employeeId)
	{
		Employee theEmployee=	employeeService.findBy(employeeId);
		if(theEmployee==null)
		{
			throw new RuntimeException("Employee id not found     "+theEmployee);
		}
		
		return theEmployee;
	}
	@PostMapping("/employees")// For create employee
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		  return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employeeId )
	{
		
		
	employeeService.save(employeeId);
	
	
	return employeeId;
		
	}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		Employee tempEmployee=employeeService.findBy(employeeId);
		if(tempEmployee==null)
		{
			throw new RuntimeException("This id is not found Please enter valid id which is avaliable in our data base");
		}
		
		employeeService.deleteById(employeeId);
		return " This id has been deleted"+ employeeId;
		
	}
	

}
