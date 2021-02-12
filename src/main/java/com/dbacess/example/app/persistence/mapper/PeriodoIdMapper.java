package com.dbacess.example.app.persistence.mapper;

import com.dbacess.example.app.domain.PeriodId;
import com.dbacess.example.app.persistence.entity.PeriodoPK;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface PeriodoIdMapper {
    @Mappings({
            @Mapping(source = "cursoId", target = "cursoId"),
            @Mapping(source = "instructorId", target = "instructorId"),
            @Mapping(source = "periodoId", target = "periodoId"),
            @Mapping(source = "year", target = "year"),
    })
    PeriodId toPeriodId(PeriodoPK periodoPK);

    @InheritInverseConfiguration
    PeriodoPK toPeriodoPK(PeriodId periodId);
}
