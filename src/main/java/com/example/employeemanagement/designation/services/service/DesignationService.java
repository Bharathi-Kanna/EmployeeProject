package com.example.employeemanagement.designation.services.service;

import com.example.employeemanagement.exception.EntityNotFound;
import com.example.employeemanagement.designation.entity.Designation;
import com.example.employeemanagement.designation.repository.DesignationRepo;
import com.example.employeemanagement.designation.services.serviceinterface.DesignationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DesignationService implements DesignationServiceInterface {

    @Autowired
    private DesignationRepo designationRepo;
    @Override
    public List<Designation> findAllEntity() {
        return designationRepo.findAll();
    }

    @Override
    public Designation findEntityById(Long id) {
        return designationRepo.findById(id).orElseThrow(()-> new EntityNotFound("Designation not found "+id));
    }

    @Override
    public void deleteById(Long id) {
         designationRepo.deleteById(id);
    }

    @Override
    public Designation addEntity(Designation designation) {
        return designationRepo.save(designation);
    }

    @Override
    public Designation updateEntity(Long id, Designation newDesignation) {
        Designation designation = findEntityById(id);
        designation.setDesignationName(newDesignation.getDesignationName());
        return designationRepo.save(designation);
    }
}
