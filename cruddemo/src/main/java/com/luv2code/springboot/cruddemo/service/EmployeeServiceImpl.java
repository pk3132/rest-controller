package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAO employeeDAO;
	
	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO)
	{
		this.employeeDAO=employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
	return	employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findBy(int theId) {
		
		return employeeDAO.findBy(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		
		employeeDAO.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);

	}

}
