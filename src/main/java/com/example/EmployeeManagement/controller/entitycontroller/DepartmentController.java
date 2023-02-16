package com.example.EmployeeManagement.controller.entitycontroller;

import com.example.EmployeeManagement.controller.ControllerInterface;
import com.example.EmployeeManagement.entity.entities.Department;
import com.example.EmployeeManagement.services.serviceinterface.entityinterface.DepartmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/department")
public class DepartmentController implements ControllerInterface<Department> {
    @Autowired
    private DepartmentServiceInterface departmentService;
    @GetMapping("/findAll")
    @Override
    public ResponseEntity<List<Department>> findAllEntity() {
        return new ResponseEntity(departmentService.findAllEntity(), HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    @Override
    public ResponseEntity<Department> findEntityById(@PathVariable Long id) {
        return new ResponseEntity(departmentService.findEntityById(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    @Override
    public ResponseEntity<Department> addEntity(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.addEntity(department),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Department> updateEntity(@PathVariable Long id,@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.updateEntity(id,department),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<HttpStatus> deleteById(Long id) {
        departmentService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
