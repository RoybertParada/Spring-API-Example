package com.dbacess.example.app.domain.repository;

import com.dbacess.example.app.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    List<Course> getAll();
    Optional<List<Course>> getByInstructor(int instructorId);
    Optional<Course> getCourse(int CourseId);
    Course save(Course course);
    void delete(int courseId);
}
