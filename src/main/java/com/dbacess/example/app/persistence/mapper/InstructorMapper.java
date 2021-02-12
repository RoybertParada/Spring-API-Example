package com.dbacess.example.app.persistence.mapper;

import com.dbacess.example.app.domain.InstructorDTO;
import com.dbacess.example.app.persistence.entity.Instructor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    @Mappings({
            @Mapping(source = "instructorId", target = "instructorDTOId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
    })
    InstructorDTO toInstructorDomain(Instructor instructor);
    List<InstructorDTO> toInstructorsDomain(List<Instructor> instructors);

    @InheritInverseConfiguration
    Instructor toInstructor(InstructorDTO instructorDTO);
}
