package com.betulsahin.schoolmanagementsystemdemov4.mapper;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.CourseRegistrationDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Course;
import com.betulsahin.schoolmanagementsystemdemov4.entity.CourseRegistration;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Student;
import com.betulsahin.schoolmanagementsystemdemov4.service.CourseService;
import com.betulsahin.schoolmanagementsystemdemov4.service.StudentService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CourseRegistrationMapper {

    @Autowired
    protected StudentService studentService;
    @Autowired
    protected CourseService courseService;

    @Mapping(target = "student", expression = "java(studentService.findById(courseRegistrationDtoInput.getStudentId()))")
    @Mapping(target = "course", expression = "java(courseService.findById(courseRegistrationDtoInput.getCourseId()))")
    public abstract CourseRegistration map(CourseRegistrationDtoInput courseRegistrationDtoInput);
}
