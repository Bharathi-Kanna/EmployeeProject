package com.example.EmployeeManagement.services.serviceinterface;

import com.example.EmployeeManagement.entity.entities.Employee;
import com.example.EmployeeManagement.response.EmployeeResponse;

import java.util.List;

public interface ServiceInterface<T> {


    T addEntity(T entity);

    T updateEntity(Long id, T newEntity);
    List<T> findAllEntity();
    T findEntityById(Long id);

    void deleteById(Long id);




}
