package com.kgfsl.springdata1.repository;

import com.kgfsl.springdata1.model1.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student,Long> {

	// Object addStudent(Student student);

	// Object updateStudent(Student student1);
    
	
}