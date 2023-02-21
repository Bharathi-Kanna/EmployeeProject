package com.example.EmployeeManagement.controller.entitycontroller;

import com.example.EmployeeManagement.controller.ControllerInterface;
import com.example.EmployeeManagement.entity.entities.Designation;
import com.example.EmployeeManagement.services.serviceinterface.entityinterface.DesignationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/designation")
public class DesignationController implements ControllerInterface<Designation> {

    @Autowired
    private DesignationServiceInterface designationService;
    @GetMapping("/findAll")
    @Override
    public ResponseEntity<List<Designation>> findAllEntity() {
        return new ResponseEntity<>(designationService.findAllEntity(), HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    @Override
    public ResponseEntity<Designation> findEntityById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(designationService.findEntityById(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    @Override
    public ResponseEntity<Designation> addEntity(@RequestBody Designation designation) {
        return new ResponseEntity<>(designationService.addEntity(designation),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Designation> updateEntity(@PathVariable("id") Long id, @RequestBody Designation designation) {
        return new ResponseEntity<>(designationService.updateEntity(id,designation),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteById( @PathVariable("id") Long id) {
        designationService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
