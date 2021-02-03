package com.dbacess.example.app.persistence.crud;

import com.dbacess.example.app.persistence.entity.Instructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InstructorCrudRepository extends CrudRepository<Instructor, Integer> {
    Optional<List<Instructor>> findByCursoId(int cursoId);
}
