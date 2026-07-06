package com.springbootweb.restAPIpractice.Entity;

import com.springbootweb.restAPIpractice.Annotations.PrimeValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@NotNull(message = "This field should not be null")
    private String name;
@Email(message = "Email format is wrong")
    private String email;
@Min( value = 5000 ,message = "salary is should be greater than 5000")
    private Long salary;
@PrimeValidation
    private Long age;



}
