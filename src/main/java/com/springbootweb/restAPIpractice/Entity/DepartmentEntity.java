package com.springbootweb.restAPIpractice.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="department")

public class DepartmentEntity {


    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String title;

   private boolean isActive;

   private LocalDateTime createdAt;

   @PrePersist
   protected void OnCreate(){
       this.createdAt = LocalDateTime.now();
       this.isActive = true;
   }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
