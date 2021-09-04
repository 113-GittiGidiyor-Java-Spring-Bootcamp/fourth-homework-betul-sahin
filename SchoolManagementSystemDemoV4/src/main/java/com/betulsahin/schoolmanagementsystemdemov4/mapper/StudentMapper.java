package com.betulsahin.schoolmanagementsystemdemov4.mapper;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.StudentDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

        Student map(StudentDtoInput studentDtoInput);

    // public StudentDtoOutput mapToDto(Student student);
}
