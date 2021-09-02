package com.betulsahin.schoolmanagementsystemdemov4.service;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.StudentDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Student;
import com.betulsahin.schoolmanagementsystemdemov4.mapper.StudentMapper;
import com.betulsahin.schoolmanagementsystemdemov4.repository.StudentRepository;
import com.betulsahin.schoolmanagementsystemdemov4.util.StudentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private static final String STUDENT_NOT_FOUND = "Student not found with this id : ";

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Transactional
    public Optional<Student> create(StudentDtoInput request) {
        this.validateRequest(request);

        Student student = studentMapper.mapFromStudentDtoInputToStudent(request);

        Student savedStudent = studentRepository.save(student);

        return Optional.of(savedStudent);
    }

    private void validateRequest(StudentDtoInput request) {
        StudentValidator.validateAge(request.getBirthdate());
    }
}
