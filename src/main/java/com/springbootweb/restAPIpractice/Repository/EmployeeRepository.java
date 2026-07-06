package com.springbootweb.restAPIpractice.Repository;

import com.springbootweb.restAPIpractice.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
