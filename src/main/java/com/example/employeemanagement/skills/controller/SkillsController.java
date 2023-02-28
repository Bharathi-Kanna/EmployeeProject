package com.example.employeemanagement.skills.controller;
import com.example.employeemanagement.generics.ControllerInterface;
import com.example.employeemanagement.skills.entity.Skills;
import com.example.employeemanagement.skills.services.serviceinterface.SkillsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/skills")
@CrossOrigin
public class SkillsController implements ControllerInterface<Skills> {
    @Autowired
    SkillsServiceInterface skillsServiceInterface;

    @GetMapping("/findAll")
    @Override
    public ResponseEntity<List<Skills>> findAllEntity() {
        return new ResponseEntity<>(skillsServiceInterface.findAllEntity(),HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    @Override
    public ResponseEntity<Skills> findEntityById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(skillsServiceInterface.findEntityById(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    @Override
    public ResponseEntity<Skills> addEntity(@RequestBody Skills entity) {
        return new ResponseEntity<>(skillsServiceInterface.addEntity(entity),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Skills> updateEntity(@PathVariable("id") Long id,@RequestBody Skills entity) {
        return new ResponseEntity<>(skillsServiceInterface.updateEntity(id,entity),HttpStatus.OK );
    }
    @Override
    public ResponseEntity<HttpStatus> deleteById(Long id) {
        return null;
    }
}
