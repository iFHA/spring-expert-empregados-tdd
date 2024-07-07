package com.devsuperior.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demo.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public List<Department> findByOrderByNameAsc();
}
