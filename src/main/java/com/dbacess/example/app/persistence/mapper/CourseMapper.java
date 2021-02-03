package com.dbacess.example.app.persistence.mapper;

import com.dbacess.example.app.domain.Course;
import com.dbacess.example.app.persistence.entity.Curso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mappings({
            @Mapping(source = "cursoId", target= "courseId"),
            @Mapping(source = "nombre", target= "name"),
            @Mapping(source = "descripcion", target = "description"),
    })
    Course toCourse(Curso curso);
    List<Course> toCourses(List<Curso> cursos);

    @InheritInverseConfiguration
    Curso toCurso(Course course);
}
