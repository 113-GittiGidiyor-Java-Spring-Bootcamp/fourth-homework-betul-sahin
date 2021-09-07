package com.betulsahin.schoolmanagementsystemdemov4.services;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.CourseDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Course;
import com.betulsahin.schoolmanagementsystemdemov4.exceptions.CourseIsAlreadyExistException;
import com.betulsahin.schoolmanagementsystemdemov4.exceptions.CourseNotFoundException;
import com.betulsahin.schoolmanagementsystemdemov4.mappers.CourseMapper;
import com.betulsahin.schoolmanagementsystemdemov4.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.betulsahin.schoolmanagementsystemdemov4.utils.ErrorMessageConstants.COURSE_NOT_FOUND;
import static com.betulsahin.schoolmanagementsystemdemov4.utils.ErrorMessageConstants.FOUND_COURSE;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Transactional
    public Optional<Course> create(CourseDtoInput request) {
        boolean courseExist = courseRepository.findByCode(request.getCode()).
                isPresent();

        if(courseExist){
            throw new CourseIsAlreadyExistException(
                    String.format(FOUND_COURSE, request.getCode()));
        }

        Course savedCourse = courseRepository.save(
                courseMapper.map(request));

        return Optional.of(savedCourse);
    }

    @Transactional(readOnly = true)
    public Course findById(long id){
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(
                String.format(COURSE_NOT_FOUND, id)));
    }
}
