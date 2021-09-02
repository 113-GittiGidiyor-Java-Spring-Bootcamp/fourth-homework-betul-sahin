package com.betulsahin.schoolmanagementsystemdemov4.mapper;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.InstructorDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.request.PermanentInstructorDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.request.VisitingResearcherDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.response.InstructorDtoOutput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.response.PermanentInstructorDtoOutput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.response.VisitingResearcherDtoOutput;
import com.betulsahin.schoolmanagementsystemdemov4.entity.Instructor;
import com.betulsahin.schoolmanagementsystemdemov4.entity.PermanentInstructor;
import com.betulsahin.schoolmanagementsystemdemov4.entity.VisitingResearcher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    PermanentInstructor mapFromPermanentInstructorDtoInputToPermanentInstructor(PermanentInstructorDtoInput permanentInstructorDtoInput);

    VisitingResearcher mapFromVisitingResearcherDtoInputToVisitingResearcher(VisitingResearcherDtoInput VisitingResearcherDtoInput);

    default Instructor mapFromInstructorDtoInputToInstructor(InstructorDtoInput dto){
        if(dto instanceof PermanentInstructorDtoInput){
            return mapFromPermanentInstructorDtoInputToPermanentInstructor((PermanentInstructorDtoInput)dto);
        }

        return mapFromVisitingResearcherDtoInputToVisitingResearcher((VisitingResearcherDtoInput)dto);
    }

    @Mapping(target = "courses", ignore = true)
    PermanentInstructorDtoOutput toDtoFromPermanentInstructor(PermanentInstructor permanentInstructor);

    @Mapping(target = "courses", ignore=true)
    VisitingResearcherDtoOutput toDtoFromVisitingResearcher(VisitingResearcher visitingResearcher);

    @Mapping(target = "courses", ignore = true)
    InstructorDtoOutput toDtoFromInstructor(Instructor instructor);

    default InstructorDtoOutput map(Instructor instructor){
        if(instructor instanceof PermanentInstructor){
            return toDtoFromPermanentInstructor(
                    (PermanentInstructor)instructor);
        }
        else if(instructor instanceof VisitingResearcher){
            return toDtoFromVisitingResearcher(
                    (VisitingResearcher)instructor);
        }
        return toDtoFromInstructor(instructor);
    }
}


// TODO : courses getirilecek