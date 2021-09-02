package com.betulsahin.schoolmanagementsystemdemov4.dto.request;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("permanentInstructorDtoInput")
public class PermanentInstructorDtoInput extends InstructorDtoInput{

    @NotEmpty
    @ApiModelProperty(example = "12500.0")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double salary;
}
