package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.Department;

public record DepartmentDTO(Long id, String name) {
    public DepartmentDTO(Department entity) {
        this(entity.getId(), entity.getName());
    }
}
