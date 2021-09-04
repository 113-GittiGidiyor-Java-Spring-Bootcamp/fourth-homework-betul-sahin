package com.betulsahin.schoolmanagementsystemdemov4.service;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.InstructorDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.response.InstructorDtoOutput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Instructor;
import com.betulsahin.schoolmanagementsystemdemov4.exception.InstructorIsAlreadyExistException;
import com.betulsahin.schoolmanagementsystemdemov4.mapper.InstructorMapper;
import com.betulsahin.schoolmanagementsystemdemov4.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.betulsahin.schoolmanagementsystemdemov4.util.ErrorMessageConstants.FOUND_INSTRUCTOR;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Transactional
    public Optional<Instructor> create(InstructorDtoInput request) {
        boolean instructorExist = instructorRepository.
                findByPhoneNumber(request.getPhoneNumber()).
                isPresent();

        if (instructorExist) {
            throw new InstructorIsAlreadyExistException(
                    String.format(FOUND_INSTRUCTOR, request.getPhoneNumber()));
        }

        Instructor savedInstructor = instructorRepository.save(
                instructorMapper.map(request));

        return Optional.of(savedInstructor);
    }

    @Transactional(readOnly = true)
    public List<InstructorDtoOutput> findAll() {
        return instructorRepository.findAll()
                .stream()
                .map(instructorMapper::mapToDto)
                .collect(Collectors.toList());
    }
}

