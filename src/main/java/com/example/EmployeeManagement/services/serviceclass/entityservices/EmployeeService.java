package com.example.EmployeeManagement.services.serviceclass.entityservices;

import com.example.EmployeeManagement.Exception.EntityNotFound;
import com.example.EmployeeManagement.entity.entities.Department;
import com.example.EmployeeManagement.entity.entities.Designation;
import com.example.EmployeeManagement.entity.entities.Employee;
import com.example.EmployeeManagement.repository.entityrepo.DepartmentRepo;
import com.example.EmployeeManagement.repository.entityrepo.DesignationRepo;
import com.example.EmployeeManagement.repository.entityrepo.EmployeeRepo;
import com.example.EmployeeManagement.response.EmployeeResponse;
import com.example.EmployeeManagement.services.serviceinterface.entityinterface.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface  {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    DesignationRepo designationRepo;
    @Override
    public List<Employee> findAllEntity() {
        return employeeRepo.findAll();
    }


    @Override
    public List<EmployeeResponse> findAllEntityWithNames(){
       List<EmployeeResponse> employeeResponseList =new ArrayList<  >();
       List<Employee> employees = findAllEntity();
       employees.forEach((employee)->{
           String departmentName;
           String designationName;
           EmployeeResponse employeeResponse = new EmployeeResponse();
           employeeResponse.setEmployee_id(employee.getEmployee_id());
           employeeResponse.setName(employee.getName());
           Department department  = departmentRepo.findById(employee.getEmployee_id()).orElseThrow(() -> new EntityNotFound("department not found "));
           departmentName=department.getDepartmentName();
           employeeResponse.setDepartmentName(departmentName);
           Designation designation = designationRepo.findById(employee.getEmployee_id()).orElseThrow(() -> new EntityNotFound("designation not found "));
           designationName=designation.getDesignationName();
           employeeResponse.setDesignationName(designationName);
           employeeResponse.setAddress(employee.getAddress());
           employeeResponse.setEmail(employee.getEmail());
           employeeResponse.setDateOfBirth(employee.getDateOfBirth());
           employeeResponse.setStatus(employee.getStatus());
           employeeResponse.setJoinDate(employee.getJoinDate());
           employeeResponse.setLeftDate(employee.getLeftDate());
           employeeResponse.setPhoneNumber(employee.getPhoneNumber());
           employeeResponseList.add(employeeResponse);
       });
        return employeeResponseList ;
    }
    @Override
    public EmployeeResponse findEntityByIdWithNames(Long id) {
        EmployeeResponse employeeResponse=new EmployeeResponse();
        Employee employee = findEntityById(id);
        String departmentName;
        String designationName;
        employeeResponse.setEmployee_id(employee.getEmployee_id());
        employeeResponse.setName(employee.getName());
        Department department  = departmentRepo.findById(employee.getEmployee_id()).orElseThrow(() -> new EntityNotFound("department not found "));
        departmentName=department.getDepartmentName();
        employeeResponse.setDepartmentName(departmentName);
        Designation designation = designationRepo.findById(employee.getEmployee_id()).orElseThrow(() -> new EntityNotFound("designation not found "));
        designationName=designation.getDesignationName();
        employeeResponse.setDesignationName(designationName);
        employeeResponse.setAddress(employee.getAddress());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setDateOfBirth(employee.getDateOfBirth());
        employeeResponse.setStatus(employee.getStatus());
        employeeResponse.setJoinDate(employee.getJoinDate());
        employeeResponse.setLeftDate(employee.getLeftDate());
        employeeResponse.setPhoneNumber(employee.getPhoneNumber());
        return employeeResponse;
    }

    @Override
    public Employee addEntity(Employee employee){
        return employeeRepo.save(employee);
    }

    @Override
    public Employee findEntityById(Long id){
        return employeeRepo.findById(id).orElseThrow(() -> new EntityNotFound("employee not found " + id));
    }
    @Override
    public Employee updateEntity(Long id,Employee newEmployee) {
        Employee employee = findEntityById(id);
        employee.setName(newEmployee.getName());
        employee.setAddress(newEmployee.getAddress());
        employee.setDateOfBirth(newEmployee.getDateOfBirth());
        employee.setEmail(newEmployee.getEmail());
        employee.setDepartment_id(newEmployee.getDepartment_id());
        employee.setDesignation_id(newEmployee.getDesignation_id());
        employee.setPhoneNumber(newEmployee.getPhoneNumber());
        employee.setStatus(newEmployee.getStatus());
        employee.setJoinDate(newEmployee.getJoinDate());
        employee.setLeftDate(newEmployee.getLeftDate());
        return employeeRepo.save(employee);
    }

}

