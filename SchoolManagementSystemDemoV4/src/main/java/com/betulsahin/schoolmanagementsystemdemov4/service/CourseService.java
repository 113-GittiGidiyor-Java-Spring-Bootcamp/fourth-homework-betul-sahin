package com.betulsahin.schoolmanagementsystemdemov4.service;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.CourseDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Course;
import com.betulsahin.schoolmanagementsystemdemov4.exception.CourseIsAlreadyExistException;
import com.betulsahin.schoolmanagementsystemdemov4.mapper.CourseMapper;
import com.betulsahin.schoolmanagementsystemdemov4.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.betulsahin.schoolmanagementsystemdemov4.util.ErrorMessageConstants.FOUND_COURSE;

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
                courseMapper.mapFromCourseDtoInputToCourse(request));

        return Optional.of(savedCourse);
    }
}
