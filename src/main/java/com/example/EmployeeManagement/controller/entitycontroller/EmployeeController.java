package com.example.EmployeeManagement.controller.entitycontroller;

import com.example.EmployeeManagement.controller.ControllerInterface;
import com.example.EmployeeManagement.entity.entities.Employee;
import com.example.EmployeeManagement.response.EmployeeResponse;
import com.example.EmployeeManagement.services.serviceinterface.entityinterface.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements ControllerInterface<Employee>{

    @Autowired
    private EmployeeServiceInterface employeeServices;


    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeResponse>> findAllEntityWithNames() {

        return new ResponseEntity<>(employeeServices.findAllEntityWithNames(), HttpStatus.OK) ;
    }
    @GetMapping("/findAllWithId")
    public ResponseEntity<List<Employee>> findAllEntity() {

        return new ResponseEntity<>(employeeServices.findAllEntity(), HttpStatus.OK) ;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<EmployeeResponse> findEntityByIdWithId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeServices.findEntityByIdWithNames(id),HttpStatus.OK);
    }
    @Override
    @GetMapping("/findByIdWithId/{id}")
    public ResponseEntity<Employee> findEntityById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeServices.findEntityById(id),HttpStatus.OK);
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<Employee> addEntity(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServices.addEntity(employee), HttpStatus.OK);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEntity(@PathVariable("id") Long id,@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServices.updateEntity(id,employee),HttpStatus.OK);
    }

}
