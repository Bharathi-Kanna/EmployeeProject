package com.example.EmployeeManagement.services.serviceclass.entityservices;

import com.example.EmployeeManagement.entity.entities.Payroll;
import com.example.EmployeeManagement.repository.entityrepo.PayrollRepo;
import com.example.EmployeeManagement.services.serviceinterface.entityinterface.PayrollServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService implements PayrollServiceInterface {
    @Autowired
    private PayrollRepo payrollRepo;

    @Override
    public Payroll addEntity(Payroll entity) {
        return null;
    }

    @Override
    public Payroll updateEntity(Long id, Payroll newEntity) {
        return  payrollRepo.save(newEntity);
    }

    @Override
    public List<Payroll> findAllEntity() {
        return null;
    }

    @Override
    public Payroll findEntityById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
