package com.springbootweb.restAPIpractice.Controller;

import com.springbootweb.restAPIpractice.Entity.Employee;
import com.springbootweb.restAPIpractice.Repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
   private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployeeDetails(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createNewEmployee(@Valid @RequestBody Employee employeeDetails){
        return employeeRepository.save(employeeDetails);
    }

}
