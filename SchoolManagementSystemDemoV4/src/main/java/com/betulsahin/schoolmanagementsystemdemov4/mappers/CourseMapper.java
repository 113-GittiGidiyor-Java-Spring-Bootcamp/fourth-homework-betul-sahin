package com.betulsahin.schoolmanagementsystemdemov4.mappers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.CourseDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course map(CourseDtoInput courseDtoInput);
}
