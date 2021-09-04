package com.betulsahin.schoolmanagementsystemdemov4.service;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.CourseRegistrationDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Course;
import com.betulsahin.schoolmanagementsystemdemov4.entity.CourseRegistration;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Student;
import com.betulsahin.schoolmanagementsystemdemov4.exception.CourseNotFoundException;
import com.betulsahin.schoolmanagementsystemdemov4.exception.StudentNotFoundException;
import com.betulsahin.schoolmanagementsystemdemov4.exception.StudentNumberForOneCourseExceededException;
import com.betulsahin.schoolmanagementsystemdemov4.mapper.CourseRegistrationMapper;
import com.betulsahin.schoolmanagementsystemdemov4.repository.CourseRegistrationRepository;
import com.betulsahin.schoolmanagementsystemdemov4.repository.CourseRepository;
import com.betulsahin.schoolmanagementsystemdemov4.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.betulsahin.schoolmanagementsystemdemov4.util.ErrorMessageConstants.*;

@Service
@RequiredArgsConstructor
public class CourseRegistrationService {
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseRegistrationMapper courseRegistrationMapper;

    public Optional<CourseRegistration> create(CourseRegistrationDtoInput request){
        int studentCountOfRegistered = courseRegistrationRepository.
                findStudentCountByCourse(request.getCourseId());

        if(studentCountOfRegistered > 20){
            throw new StudentNumberForOneCourseExceededException(
                    String.format(COURSE_EXCEEDED, studentCountOfRegistered));
        }

        CourseRegistration savedRegistrations = courseRegistrationRepository.save(
                courseRegistrationMapper.map(request));

        return Optional.of(savedRegistrations);
    }
}
