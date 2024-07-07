package com.devsuperior.demo.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.services.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<EmployeeDTO> store(@RequestBody EmployeeDTO dto) {
        dto = service.store(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("employees/{id}").buildAndExpand(dto.equals(dto)).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    
}
