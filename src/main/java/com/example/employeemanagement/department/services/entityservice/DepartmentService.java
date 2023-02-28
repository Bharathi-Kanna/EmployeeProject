package com.example.employeemanagement.department.services.entityservice;

import com.example.employeemanagement.exception.EntityNotFound;
import com.example.employeemanagement.department.entity.Department;
import com.example.employeemanagement.department.repository.DepartmentRepo;
import com.example.employeemanagement.department.services.serviceinterface.DepartmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService implements DepartmentServiceInterface {

    @Autowired
    DepartmentRepo departmentRepo;
    @Override
    public List<Department> findAllEntity() {
        return departmentRepo.findAll() ;
    }

    @Override
    public Department findEntityById(Long id) {
        return departmentRepo.findById(id).orElseThrow(()->new EntityNotFound("Department not found "+id));
    }

    @Override
    public void deleteById(Long id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public Department addEntity(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public Department updateEntity(Long id, Department newDepartment) {
        Department department = findEntityById(id);
        department.setDepartmentName(newDepartment.getDepartmentName());
        return departmentRepo.save(department);
    }


}
