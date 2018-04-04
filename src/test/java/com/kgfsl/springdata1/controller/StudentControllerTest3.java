package com.kgfsl.springdata1.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import java.util.Arrays;
import com.kgfsl.springdata1.model1.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.kgfsl.springdata1.repository.StudentRepository;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest3 {

	private static final Long STUDENT_ID = 1L;
	private static final Student EXISTING_STUDENT = new StudentBuilder().id(1L).name("Micky").build();
	private static final Student ANOTHER_STUDENT = new StudentBuilder().id(2L).name("Minny").build();
	private static final Student NEW_STUDENT = new StudentBuilder().name("Micky").build();

	@InjectMocks
	private StudentController studentController;
	@Mock
	private StudentRepository studentRepository;

	@Test
	public void whenCreatingStudentItShouldReturnTheSavedStudent() {
		given(studentRepository.saveAndFlush(NEW_STUDENT)).willReturn((EXISTING_STUDENT));
		assertThat(studentController.addStudent((NEW_STUDENT))).isSameAs(EXISTING_STUDENT);
	}

	@Test
	public void whenUpdatingStudentItShouldReturnTheSavedStudent() {
		given(studentRepository.findOne(STUDENT_ID)).willReturn(EXISTING_STUDENT);
		given(studentRepository.saveAndFlush(EXISTING_STUDENT)).willReturn(EXISTING_STUDENT);
		assertThat(studentController.updateStudent(EXISTING_STUDENT, STUDENT_ID)).isSameAs(EXISTING_STUDENT);
	}

	@Test
	public void whenReadingdingStudentItShouldReturnAllStudent() {
		given(studentRepository.findAll()).willReturn(Arrays.asList(EXISTING_STUDENT, ANOTHER_STUDENT));
		assertThat(studentController.findStudents()).containsOnly(EXISTING_STUDENT, ANOTHER_STUDENT);
	}

	@Test
	public void whenDeletingAStudentItShouldUseTheRepository() {
		studentController.deleteStudent(STUDENT_ID);
		verify(studentRepository).delete(STUDENT_ID);
	}

}