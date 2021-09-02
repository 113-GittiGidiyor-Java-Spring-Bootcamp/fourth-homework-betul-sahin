package com.betulsahin.schoolmanagementsystemdemov4.dto.response;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("visitingResearcherDtoOutput")
public class VisitingResearcherDtoOutput extends InstructorDtoOutput {
    private int monthlyWorkingHours;
    private double hourlyRate;
}
