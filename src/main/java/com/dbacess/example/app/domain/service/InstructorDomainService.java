package com.dbacess.example.app.domain.service;

import com.dbacess.example.app.domain.InstructorDTO;
import com.dbacess.example.app.domain.repository.InstructorDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorDomainService {
    @Autowired
    private InstructorDomainRepository instructorDomainRepository;

    public List<InstructorDTO> getAll() {
        return instructorDomainRepository.getAll();
    }

    public Optional<InstructorDTO> getInstructor(Long instructorId) {
        return instructorDomainRepository.getInstructor(instructorId);
    }

    public Optional<InstructorDTO> findByNombre(String name){
        return instructorDomainRepository.findByNombre(name);
    }

    public InstructorDTO save(InstructorDTO instructorDTO) {
       return instructorDomainRepository.save(instructorDTO);
    }

    public Boolean delete(Long instructorId){
        return getInstructor(instructorId).map(instructor -> {
            instructorDomainRepository.deleteById(instructorId);
            return true;
        }).orElse(false);
    }

    public List<InstructorDTO> findAllInstructorsByCourse(Long courseId) {
        return instructorDomainRepository.findAllInstructorsByCourse(courseId);
    }
}
