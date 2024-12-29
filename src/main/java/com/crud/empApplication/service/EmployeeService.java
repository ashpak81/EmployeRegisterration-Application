package com.crud.empApplication.service;

import com.crud.empApplication.entity.Employee;
import com.crud.empApplication.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> gelAllEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(long id){
        if(employeeRepository.existsById(id))
            employeeRepository.deleteById(id);
        else
            throw new EntityNotFoundException("Employe With ID " + id + "Not  found");
    }

    public Employee getEmploye(long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.findById(id).map(existingEmployee -> {

            if (employee.getName() != null) {
                existingEmployee.setName(employee.getName());
            }
            if (employee.getEmail() != null) {
                existingEmployee.setEmail(employee.getEmail());
            }
            if (employee.getPhone() != null) {
                existingEmployee.setPhone(employee.getPhone());
            }
            if (employee.getDepartment() != null) {
                existingEmployee.setDepartment(employee.getDepartment());
            }

            // Save and return updated employee
            return employeeRepository.save(existingEmployee);
        }).orElse(null);
    }

}
