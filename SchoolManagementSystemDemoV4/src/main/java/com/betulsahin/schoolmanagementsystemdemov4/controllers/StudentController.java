package com.betulsahin.schoolmanagementsystemdemov4.controllers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.StudentDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Student;
import com.betulsahin.schoolmanagementsystemdemov4.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDtoInput studentDtoInput) {
        Optional<Student> studentOptional = studentService.create(studentDtoInput);

        if(studentOptional.isPresent()){
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
