package com.mytech.employeemgmt.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mytech.employeemgmt.ejb.PreferenceBean;
import com.mytech.employeemgmt.web.models.Employee;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("employeeBean")
@SessionScoped
public class EmployeeManagedBean implements Serializable {

	private static final long serialVersionUID = -2776166670103131819L;

	private String username;
	private String password;

	private List<Employee> listEmployees;

	private Employee employee;

	public EmployeeManagedBean() {
		listEmployees = new ArrayList<Employee>();
		listEmployees.add(new Employee("emp1", "admin1", "123456", 26));
		listEmployees.add(new Employee("emp2", "admin2", "123456", 27));
		listEmployees.add(new Employee("emp3", "admin3", "123456", 28));
	}

	@EJB
	private PreferenceBean preferenceBean;

	// New employee
	public String displayAdd() {
		employee = new Employee();
		return "add";
	}

	public String performAdd() {
		listEmployees.add(employee);
		return "home";
	}
	
	// Login
	public String performLogin() {
		System.out.println("username: " + username + " -- password " + password);
		for (Employee employee : listEmployees) {
			if (employee.getEmployeeName().equals(username)) {
				if (employee.getEmployeePassword().equals(password)) {
					return "home";
				} else {
					return "failed";
				}
			}
		}
		return "failed";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(List<Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeToWork() {
		return preferenceBean.getWorkingStart();
	}

	public int getTimeToLeave() {
		return preferenceBean.getWorkingEnd();
	}
}
