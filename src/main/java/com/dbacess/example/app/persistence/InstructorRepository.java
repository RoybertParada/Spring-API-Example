package com.dbacess.example.app.persistence;

import com.dbacess.example.app.domain.InstructorDomain;
import com.dbacess.example.app.domain.repository.InstructorDomainRepository;
import com.dbacess.example.app.persistence.crud.InstructorCrudRepository;
import com.dbacess.example.app.persistence.entity.Instructor;
import com.dbacess.example.app.persistence.mapper.InstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InstructorRepository implements InstructorDomainRepository {
    @Autowired
    private InstructorCrudRepository instructorCrudRepository;

    @Autowired
    private InstructorMapper mapper;

    @Override
    public List<InstructorDomain> getAll() {
        return mapper.toInstructorsDomain((List<Instructor>) instructorCrudRepository.findAll());
    }

    @Override
    public Optional<List<InstructorDomain>> getByCourse(int courseId) {
        return instructorCrudRepository.findByCursoId(courseId).
                map(instructores -> mapper.toInstructorsDomain(instructores));
    }

    @Override
    public InstructorDomain save(InstructorDomain instructorDomain) {
        Instructor instructor = mapper.toInstructor(instructorDomain);
        return mapper.toInstructorDomain(instructorCrudRepository.save(instructor));
    }
}
