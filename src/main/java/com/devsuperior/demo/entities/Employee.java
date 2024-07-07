package com.devsuperior.demo.entities;

import com.devsuperior.demo.dto.EmployeeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public String email;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	public Department department;
	
	public Employee() {
	}

	public Employee(Long id, String name, String email, Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}

	public Employee(EmployeeDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.department = new Department();
		this.department.setId(dto.getDepartmentId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
