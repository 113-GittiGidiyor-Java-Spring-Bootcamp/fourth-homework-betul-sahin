package com.betulsahin.schoolmanagementsystemdemov4.mapper;

import com.betulsahin.schoolmanagementsystemdemov4.dto.StudentDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.StudentDtoOutput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentMapper {

        Student mapFromStudentDtoInputToStudent(StudentDtoInput studentDto);

    // public StudentDtoOutput mapToDto(Student student);
}
