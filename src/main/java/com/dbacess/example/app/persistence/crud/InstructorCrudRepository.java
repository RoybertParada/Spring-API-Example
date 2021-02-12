package com.dbacess.example.app.persistence.crud;

import com.dbacess.example.app.persistence.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface InstructorCrudRepository extends CrudRepository<Instructor, Long> {
    Optional<Instructor> findByNombre(String name);
}