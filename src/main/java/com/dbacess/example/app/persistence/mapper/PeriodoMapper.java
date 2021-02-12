package com.dbacess.example.app.persistence.mapper;

import com.dbacess.example.app.domain.Period;
import com.dbacess.example.app.persistence.entity.Periodo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {InstructorMapper.class, CourseMapper.class} )
public interface PeriodoMapper {
    @Mappings({
            @Mapping(source = "id.periodoId", target = "periodId"),
            @Mapping(source = "id.year", target= "year"),
            @Mapping(source = "instructor", target = "instructor"),
            @Mapping(source = "curso", target = "curso"),
    })
    Period toPeriod(Periodo periodo);
    List<Period> toPeriods(List<Periodo> periodos);

    @InheritInverseConfiguration
    Periodo toPeriodo(Period period);

}
