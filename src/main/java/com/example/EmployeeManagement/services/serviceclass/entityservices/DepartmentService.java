package com.example.EmployeeManagement.services.serviceclass.entityservices;

import com.example.EmployeeManagement.Exception.EntityNotFound;
import com.example.EmployeeManagement.entity.entities.Department;
import com.example.EmployeeManagement.repository.entityrepo.DepartmentRepo;
import com.example.EmployeeManagement.services.serviceinterface.entityinterface.DepartmentServiceInterface;
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
