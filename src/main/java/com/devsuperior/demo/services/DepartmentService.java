package com.devsuperior.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.repositories.DepartmentRepository;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    
    public List<DepartmentDTO> findAll() {
        return this.departmentRepository.findByOrderByNameAsc().stream().map(DepartmentDTO::new).toList();
    }
}
