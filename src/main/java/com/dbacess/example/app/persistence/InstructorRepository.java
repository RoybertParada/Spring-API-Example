package com.dbacess.example.app.persistence;

import com.dbacess.example.app.domain.InstructorDTO;
import com.dbacess.example.app.domain.repository.InstructorDomainRepository;
import com.dbacess.example.app.persistence.crud.InstructorCrudRepository;
import com.dbacess.example.app.persistence.entity.Instructor;
import com.dbacess.example.app.persistence.mapper.InstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class InstructorRepository implements InstructorDomainRepository {
    @Autowired
    private InstructorCrudRepository instructorCrudRepository;

    @Autowired
    private InstructorMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<InstructorDTO> getAll() {
        return mapper.toInstructorsDomain((List<Instructor>) instructorCrudRepository.findAll());
    }

    @Override
    public Optional<InstructorDTO> getInstructor(Long instructorId) {
        return instructorCrudRepository.findById(instructorId).map(instructor-> mapper.toInstructorDomain(instructor));
    }

    @Override
    public Optional<InstructorDTO> findByNombre(String name) {
        return instructorCrudRepository.findByNombre(name).map(instructor-> mapper.toInstructorDomain(instructor));
    }

    @Override
    public void deleteById(Long instructorId) {
        instructorCrudRepository.deleteById(instructorId);
    }

    @Override
    public InstructorDTO save(InstructorDTO instructorDTO) {
        Instructor instructor = mapper.toInstructor(instructorDTO);
        return mapper.toInstructorDomain(instructorCrudRepository.save(instructor));
    }



    @Override
    public List<InstructorDTO> findAllInstructorsByCourse(Long courseId) {
        TypedQuery<Instructor> query = entityManager.createQuery("SELECT ins FROM Instructor ins INNER JOIN Periodo per ON ins.instructorId = per.id.instructorId AND per.id.cursoId=:courseId",Instructor.class).setParameter("courseId",courseId);
        List<Instructor> resultList = query.getResultList();
        return mapper.toInstructorsDomain(resultList);
    }


}


