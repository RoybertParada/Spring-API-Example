package com.dbacess.example.app.persistence.crud;

import com.dbacess.example.app.persistence.entity.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CursoCrudRepository extends CrudRepository<Curso, Integer> {
    Optional<List<Curso>> findByInstructorId(int instructorId);
}
