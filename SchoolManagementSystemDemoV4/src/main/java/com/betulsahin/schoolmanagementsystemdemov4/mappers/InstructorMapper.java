package com.betulsahin.schoolmanagementsystemdemov4.mappers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.request.InstructorDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.request.PermanentInstructorDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.request.VisitingResearcherDtoInput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.response.InstructorDtoOutput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.response.PermanentInstructorDtoOutput;
import com.betulsahin.schoolmanagementsystemdemov4.dto.response.VisitingResearcherDtoOutput;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Instructor;
import com.betulsahin.schoolmanagementsystemdemov4.entities.PermanentInstructor;
import com.betulsahin.schoolmanagementsystemdemov4.entities.VisitingResearcher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    PermanentInstructor toPermanentInstructor(PermanentInstructorDtoInput permanentInstructorDtoInput);

    VisitingResearcher toVisitingResearcher(VisitingResearcherDtoInput VisitingResearcherDtoInput);

    default Instructor map(InstructorDtoInput instructorDtoInput){
        if(instructorDtoInput instanceof PermanentInstructorDtoInput){
            return toPermanentInstructor((PermanentInstructorDtoInput)instructorDtoInput);
        }
        else if(instructorDtoInput instanceof VisitingResearcherDtoInput){
            return toVisitingResearcher((VisitingResearcherDtoInput)instructorDtoInput);
        }
        return null;
    }

    PermanentInstructorDtoOutput toPermanentInstructorDtoOutput(PermanentInstructor permanentInstructor);

    VisitingResearcherDtoOutput toVisitingResearcherDtoOutput(VisitingResearcher visitingResearcher);

    default InstructorDtoOutput mapToDto(Instructor instructor){
        if(instructor instanceof PermanentInstructor){
            return toPermanentInstructorDtoOutput(
                    (PermanentInstructor)instructor);
        }
        else if(instructor instanceof VisitingResearcher){
            return toVisitingResearcherDtoOutput(
                    (VisitingResearcher)instructor);
        }
        return null;
    }
}