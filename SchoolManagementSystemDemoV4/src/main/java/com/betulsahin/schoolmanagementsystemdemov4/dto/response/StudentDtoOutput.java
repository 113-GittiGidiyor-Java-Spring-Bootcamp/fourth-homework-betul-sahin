package com.betulsahin.schoolmanagementsystemdemov4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtoOutput{
    private String name;
    private LocalDate birthdate;
    private String address;
    private String gender;
}