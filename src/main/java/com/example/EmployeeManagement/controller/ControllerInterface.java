package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.entity.entities.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
public interface ControllerInterface <T>{

ResponseEntity<List<T>> findAllEntity();
    ResponseEntity<T> findEntityById(Long id);

    ResponseEntity<T> addEntity( T entity);
    ResponseEntity<T> updateEntity(Long id,T entity);



}
