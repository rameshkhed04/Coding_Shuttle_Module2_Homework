package com.springbootweb.restAPIpractice.Controller;

import com.springbootweb.restAPIpractice.Entity.DepartmentEntity;
import com.springbootweb.restAPIpractice.Repository.DepartementRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping
    public List<DepartmentEntity> getAllDepartment(){
        return departementRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentEntity> getDepartmentByID(@PathVariable Long id){
        return departementRepository.findById(id)
                .map(ResponseEntity :: ok)
                .orElseThrow(()-> new NoSuchElementException("Element not found"));
    }



    @PostMapping
    public DepartmentEntity createDepartement(@RequestBody DepartmentEntity department){
        return departementRepository.save(department);
    }
    @PutMapping
    public ResponseEntity<DepartmentEntity> updateDepartment(@RequestBody DepartmentEntity departmentdetails){
        if(departmentdetails.getId()== 0){
            return ResponseEntity.badRequest().build();
        }
        return departementRepository.findById(departmentdetails.getId())
                .map(exictingDepartment ->{
                    exictingDepartment.setTitle(departmentdetails.getTitle());
                    exictingDepartment.setActive(departmentdetails.isActive());

                    DepartmentEntity updateDepartment = departementRepository.save(exictingDepartment);
                    return ResponseEntity.ok(updateDepartment);
                   })
                   .orElse(ResponseEntity.notFound().build());
        }

    @DeleteMapping
    public ResponseEntity<String> deleteDepartment(@RequestParam Long id) {
        return departementRepository.findById(id)
                .map(department -> {
                    departementRepository.delete(department);
                    return ResponseEntity.ok("Department deleted successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }


}