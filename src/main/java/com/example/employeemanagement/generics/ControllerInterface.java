package com.example.employeemanagement.generics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface ControllerInterface <T>{

    ResponseEntity<List<T>> findAllEntity();

    ResponseEntity<T> findEntityById(Long id);

    ResponseEntity<T> addEntity( T entity);



    ResponseEntity<T> updateEntity(Long id,T entity);

    ResponseEntity<HttpStatus> deleteById(Long id);

}
