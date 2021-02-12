package com.dbacess.example.app.domain.repository;

import com.dbacess.example.app.domain.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    List<Course> getAll();
    Optional<Course> getByNombre(String nombre);
    Optional<Course> getCourse(Long CourseId);
    Course save(Course course);
    void delete(Long courseId);
}
