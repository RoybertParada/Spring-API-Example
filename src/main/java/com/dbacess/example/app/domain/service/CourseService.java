package com.dbacess.example.app.domain.service;

import com.dbacess.example.app.domain.Course;
import com.dbacess.example.app.domain.repository.CourseRepository;
import com.dbacess.example.app.persistence.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll(){
        return courseRepository.getAll();
    }

    public Optional<Course> getByNombre(String nombre){
        return courseRepository.getByNombre(nombre);
    }

    public Optional<Course> getCourse(Long courseId) {
        return courseRepository.getCourse(courseId);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public boolean delete(Long courseId) {
        return getCourse(courseId).map(course -> {
            courseRepository.delete(courseId);
            return true;
        }).orElse(false);
    }
}
