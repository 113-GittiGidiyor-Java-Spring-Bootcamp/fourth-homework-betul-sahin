package com.betulsahin.schoolmanagementsystemdemov4.mapper;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.CourseDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course map(CourseDtoInput courseDtoInput);
}
