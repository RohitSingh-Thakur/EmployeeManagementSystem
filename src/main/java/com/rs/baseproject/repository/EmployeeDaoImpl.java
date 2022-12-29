package com.rs.baseproject.repository;

import java.lang.reflect.Field;  
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;
import com.rs.baseproject.entity.Employee;
import com.rs.baseproject.payloads.EmployeeDto;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public Employee registerNewEmployee(Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			session.persist(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		Session session = factory.openSession();
		try {
			return session.createQuery("from Employee").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public Employee searchEmployee(Integer employeeId) {
		Session session = factory.openSession();
		try {
			return session.find(Employee.class, employeeId);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee updateEmployeeByID(Integer employeeId, Map<String, Object> fields) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			Employee searchEmployee = searchEmployee(employeeId);

			if (searchEmployee != null) {
				
				
				fields.forEach((Key, Value) -> {
					Field myField = ReflectionUtils.findField(Employee.class, Key);
					myField.setAccessible(true);
					ReflectionUtils.setField(myField, searchEmployee, Value);
				});

				session.saveOrUpdate(searchEmployee);
				transaction.commit();
				return searchEmployee;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Employee deleteEmployeeById(Integer employeeId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Employee find = session.find(Employee.class, employeeId);
			session.remove(find);
			transaction.commit();
			return find;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Employee searchEmployeeByName(String employeeName) 
	{
		Session session = factory.openSession();
		
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			Criteria add = criteria.add(Restrictions.like("employeeName", "%"+employeeName+"%"));
			
			return (Employee) add.uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> searchEmployeeByDepartment(String employeeDepartment) {
		Session session = factory.openSession();
		try {
				@SuppressWarnings("deprecation")
				Criteria criteria = session.createCriteria(Employee.class);
				Criteria add = criteria.add(Restrictions.like("employeeDepartment", "%" + employeeDepartment + "%"));
				return add.list();
		}catch (Exception e) {
		e.printStackTrace();
		return null;
		}finally {
			session.close();
		}
	}

}
