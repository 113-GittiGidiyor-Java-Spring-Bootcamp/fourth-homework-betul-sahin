package com.betulsahin.schoolmanagementsystemdemov4.dto.request;

import com.betulsahin.schoolmanagementsystemdemov4.entity.enumeration.GenderType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtoInput {
    private long id;

    @ApiModelProperty(example = "Aybike Güliz Enzel Yağmur Eflinnisa Nebioğulları")
    @NotEmpty
    @Size(max=50, message = "Your name cannot be greater than 50 characters")
    private String name;

    @NotEmpty
    private LocalDate birthdate;

    @NotEmpty
    @Size(max=250, message = "Your address cannot be greater than 250 characters")
    private String address;

    @NotEmpty
    private String gender;
}
