package com.dbacess.example.app.domain.repository;

import com.dbacess.example.app.domain.InstructorDomain;

import java.util.List;
import java.util.Optional;

public interface InstructorDomainRepository {
    List<InstructorDomain> getAll();
    Optional<List<InstructorDomain>> getByCourse(int courseId);
    InstructorDomain save(InstructorDomain instructor);
}
