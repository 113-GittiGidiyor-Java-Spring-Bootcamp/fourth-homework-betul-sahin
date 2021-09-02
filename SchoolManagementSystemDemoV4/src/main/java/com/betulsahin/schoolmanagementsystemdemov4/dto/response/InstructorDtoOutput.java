package com.betulsahin.schoolmanagementsystemdemov4.dto.response;

import com.betulsahin.schoolmanagementsystemdemov4.entity.PermanentInstructor;
import com.betulsahin.schoolmanagementsystemdemov4.entity.VisitingResearcher;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructorDtoOutput.class, name = "permanentInstructorDtoOutput"),
        @JsonSubTypes.Type(value = VisitingResearcherDtoOutput.class, name = "visitingResearcherDtoOutput")
})
public class InstructorDtoOutput {
    private String name;
    private String address;
    private String phoneNumber;

    private List<String> courses = new ArrayList<>();
}
