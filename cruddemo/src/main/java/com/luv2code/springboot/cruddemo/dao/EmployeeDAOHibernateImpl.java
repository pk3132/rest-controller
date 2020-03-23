package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	EmployeeDAOHibernateImpl(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}

	@Override

	public List<Employee> findAll() {
		
		 Session currentSession=entityManager.unwrap(Session.class);
		 Query<Employee> theQuery=currentSession.createQuery("From Employee",Employee.class);
	     List<Employee>employees=theQuery.getResultList();
	
		return employees;
	}

	@Override
	@Transactional
	public Employee findBy(int theId) {
		Session currentSession=entityManager.unwrap(Session.class);
		
		
		Employee theEmployee=	currentSession.get(Employee.class, theId);
	  
		return theEmployee;
	}

	@Override
	
	public void save(Employee theEmployee) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		
		
	}

	@Override

	public void deleteById(int theId) {
	Session currentSession=entityManager.unwrap(Session.class);
	
	Query<Employee> theQuery=currentSession.createQuery("delete from Employee where id=:employeeId");
	theQuery.setParameter("employeeId", theId);
        System.out.println("This is git testing");
	theQuery.executeUpdate();
        System.out.println("This is second git commit");
        System.out.println("This is my commit code through eclipse");
		System.out.println("I have changed in my git now i want to pull");
		
	}
	

}
