package com.dbacess.example.app.domain.service;

import com.dbacess.example.app.domain.InstructorDomain;
import com.dbacess.example.app.domain.repository.InstructorDomainRepository;
import com.dbacess.example.app.persistence.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorDomainService {
    @Autowired
    private InstructorDomainRepository instructorDomainRepository;

    public List<InstructorDomain> getAll() {
        return instructorDomainRepository.getAll();
    }

    public Optional<List<InstructorDomain>> getByCourse(int courseId) {
        return instructorDomainRepository.getByCourse(courseId);
    }

    public InstructorDomain save(InstructorDomain instructorDomain) {
       return instructorDomainRepository.save(instructorDomain);
    }
}
