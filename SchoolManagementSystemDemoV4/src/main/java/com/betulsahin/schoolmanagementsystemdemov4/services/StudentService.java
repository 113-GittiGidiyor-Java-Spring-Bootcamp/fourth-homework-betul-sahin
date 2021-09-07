package com.betulsahin.schoolmanagementsystemdemov4.services;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.StudentDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Student;
import com.betulsahin.schoolmanagementsystemdemov4.exceptions.StudentNotFoundException;
import com.betulsahin.schoolmanagementsystemdemov4.mappers.StudentMapper;
import com.betulsahin.schoolmanagementsystemdemov4.repositories.StudentRepository;
import com.betulsahin.schoolmanagementsystemdemov4.utils.StudentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private static final String STUDENT_NOT_FOUND = "Student not found with this id : ";

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final LogService logService;

    @Transactional
    public Optional<Student> create(StudentDtoInput request) {
        this.validateRequest(request);

        Student savedStudent = studentRepository.save(
                studentMapper.map(request));

        return Optional.of(savedStudent);
    }

    private void validateRequest(StudentDtoInput request) {
        StudentValidator.validateAge(request.getBirthdate());
    }

    @Transactional(readOnly = true)
    public Student findById(long id){
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(!studentOptional.isPresent()){
            // logging..
            logService.log(StudentNotFoundException.class.getSimpleName(), String.format(STUDENT_NOT_FOUND, id), Instant.now());

            throw new StudentNotFoundException(
                    String.format(STUDENT_NOT_FOUND, id));
        }
        return studentOptional.get();
    }
}