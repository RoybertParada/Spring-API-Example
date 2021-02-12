package com.dbacess.example.app.domain.repository;

import com.dbacess.example.app.domain.InstructorDTO;

import java.util.List;
import java.util.Optional;

public interface InstructorDomainRepository {
    List<InstructorDTO> getAll();
    InstructorDTO save(InstructorDTO instructor);
    List<InstructorDTO> findAllInstructorsByCourse(Long courseId);
    Optional<InstructorDTO> getInstructor(Long instructorId);
    Optional<InstructorDTO> findByNombre(String name);
    void deleteById(Long instructorId);
}
