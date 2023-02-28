package com.example.employeemanagement.certificate.controller;
import com.example.employeemanagement.generics.ControllerInterface;
import com.example.employeemanagement.certificate.entity.Certificate;
import com.example.employeemanagement.certificate.services.serviceinterface.CertificateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/certificate")
@CrossOrigin
public class CertificateController implements ControllerInterface<Certificate> {
    @Autowired
    CertificateServiceInterface certificateService;
    @GetMapping("/findAll")
    @Override
    public ResponseEntity<List<Certificate>> findAllEntity() {
        return new ResponseEntity<>(certificateService.findAllEntity(),HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    @Override
    public ResponseEntity<Certificate> findEntityById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(certificateService.findEntityById(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    @Override
    public ResponseEntity<Certificate> addEntity(@RequestBody Certificate entity) {
        return new ResponseEntity<>(certificateService.addEntity(entity),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<Certificate> updateEntity(@PathVariable("id") Long id,@RequestBody Certificate entity) {
        return new ResponseEntity<>(certificateService.updateEntity(id,entity),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<HttpStatus> deleteById(Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
