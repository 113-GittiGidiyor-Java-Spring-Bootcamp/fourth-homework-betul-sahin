package com.betulsahin.schoolmanagementsystemdemov4.controller;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.InstructorDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.response.InstructorDtoOutput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Instructor;
import com.betulsahin.schoolmanagementsystemdemov4.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody InstructorDtoInput request){
        Optional<Instructor> instructorOptional = instructorService.create(request);

        if(instructorOptional.isPresent()){
            return new ResponseEntity<>(instructorOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<InstructorDtoOutput>> getAll(){
        final List<InstructorDtoOutput> instructors = instructorService.findAll();

        return new ResponseEntity<List<InstructorDtoOutput>>(
                instructors,
                HttpStatus.OK
        );
    }
}
