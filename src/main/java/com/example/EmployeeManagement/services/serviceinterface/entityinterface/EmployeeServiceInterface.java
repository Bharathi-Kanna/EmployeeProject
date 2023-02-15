package com.example.EmployeeManagement.services.serviceinterface.entityinterface;

import com.example.EmployeeManagement.entity.entities.Employee;
import com.example.EmployeeManagement.response.EmployeeResponse;
import com.example.EmployeeManagement.services.serviceinterface.ServiceInterface;

import java.util.List;

public interface EmployeeServiceInterface extends ServiceInterface<Employee> {


    List<EmployeeResponse> findAllEntityWithNames();
    EmployeeResponse findEntityByIdWithNames(Long id);



}
