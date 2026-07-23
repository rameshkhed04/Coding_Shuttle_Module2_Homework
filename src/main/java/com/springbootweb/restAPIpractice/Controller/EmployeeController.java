package com.springbootweb.restAPIpractice.Controller;

import com.springbootweb.restAPIpractice.Entity.Employee;
import com.springbootweb.restAPIpractice.Repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
   private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployeeDetails(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable Long id){
        return employeeRepository.findById(id)
                .map(ResponseEntity ::ok)
                .orElseThrow(()-> new NoSuchElementException("Employee not found"));

    }


    @PostMapping
    public Employee createNewEmployee(@Valid @RequestBody Employee employeeDetails){
        return employeeRepository.save(employeeDetails);
    }

}
