package com.springbootweb.restAPIpractice.Repository;

import com.springbootweb.restAPIpractice.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<DepartmentEntity,Long> {
}
