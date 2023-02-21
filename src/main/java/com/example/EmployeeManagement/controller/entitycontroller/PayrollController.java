package com.example.EmployeeManagement.controller.entitycontroller;

import com.example.EmployeeManagement.controller.ControllerInterface;
import com.example.EmployeeManagement.entity.entities.Employee;
import com.example.EmployeeManagement.entity.entities.Payroll;
import com.example.EmployeeManagement.services.serviceinterface.entityinterface.PayrollServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/payroll")
@CrossOrigin

public class PayrollController implements ControllerInterface<Payroll> {

    @Autowired
    private PayrollServiceInterface payrollServiceInterface;
    @Override
    public ResponseEntity<List<Payroll>> findAllEntity() {
        return null;
    }

    @Override
    public ResponseEntity<Payroll> findEntityById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Payroll> addEntity(Payroll entity) {
        return null;
    }
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Payroll> updateEntity(@PathVariable Long id, Payroll entity) {
        return new ResponseEntity<>(payrollServiceInterface.updateEntity(id,entity),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(Long id) {
        return null;
    }
}
