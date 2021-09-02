package com.betulsahin.schoolmanagementsystemdemov4.dto.response;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("permanentInstructorDtoOutput")
public class PermanentInstructorDtoOutput extends InstructorDtoOutput{
    private double salary;
}
