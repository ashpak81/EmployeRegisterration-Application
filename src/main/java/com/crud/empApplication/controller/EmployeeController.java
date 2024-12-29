package com.crud.empApplication.controller;

import com.crud.empApplication.entity.Employee;
import com.crud.empApplication.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmp")
    public Employee postEmployee(@RequestBody Employee employee) {
        System.out.println("Create emloyee called " );
        return employeeService.postEmployee(employee);
    }

    @GetMapping("/AllEmployee")
    public List<Employee> allEmployee(){
        return employeeService.gelAllEmployee();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmploye(@PathVariable long id){
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("Employe with id " + id +"Delted Successfully", HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeByid(@PathVariable long id){
            Employee employee  = employeeService.getEmploye(id);
            if(employee == null)
                    return  ResponseEntity.noContent().build();
            return ResponseEntity.ok(employee);
    }

    @PatchMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        try {

            Employee updatedEmployee = employeeService.updateEmployee(id, employee);

            if (updatedEmployee == null) {

                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            }

            return ResponseEntity.ok(updatedEmployee);
        } catch (Exception e) {

            System.err.println("Error updating employee: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
