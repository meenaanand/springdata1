package com.kgfsl.springdata1.controller;
import com.kgfsl.springdata1.model1.*;
public class StudentBuilder {
    private Student student = new Student();
    
    public StudentBuilder id(Long id) {
      student.setId(id);
      return this;
    }
    
    public StudentBuilder name(String name) {
      student.setName(name);
      return this;
    }
    
    public Student build() {
      return student;
    }
  }