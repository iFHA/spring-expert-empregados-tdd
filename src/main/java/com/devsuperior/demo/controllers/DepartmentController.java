package com.devsuperior.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.services.DepartmentService;


@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping()
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        return ResponseEntity.ok().body(departmentService.findAll());
    }
    
}
