package com.devsuperior.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.entities.Employee;
import com.devsuperior.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    public Page<EmployeeDTO> findAll() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("name"));
        return this.repository.findAll(pageRequest).map(EmployeeDTO::new);
    }
    public EmployeeDTO store(EmployeeDTO dto) {
        dto.setId(null);
        return new EmployeeDTO(repository.save(new Employee(dto)));
    }
}
