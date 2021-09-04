package com.betulsahin.schoolmanagementsystemdemov4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRegistrationDtoInput {
    private long id;
    private long studentId;
    private long courseId;
}
