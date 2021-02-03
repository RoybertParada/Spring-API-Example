package com.dbacess.example.app.persistence;

import com.dbacess.example.app.domain.Course;
import com.dbacess.example.app.domain.repository.CourseRepository;
import com.dbacess.example.app.persistence.crud.CursoCrudRepository;
import com.dbacess.example.app.persistence.entity.Curso;
import com.dbacess.example.app.persistence.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CursoRepository implements CourseRepository {
    @Autowired
    private CursoCrudRepository cursoCrudRepository;

    @Autowired
    private CourseMapper mapper;

    @Override
    public List<Course> getAll() {
        return mapper.toCourses((List<Curso>) cursoCrudRepository.findAll());
    }

    @Override
    public Optional<List<Course>> getByInstructor(int instructorId) {
        return cursoCrudRepository.findByInstructorId(instructorId)
                .map(cursos -> mapper.toCourses(cursos));
    }

    @Override
    public Optional<Course> getCourse(int courseId) {
        return cursoCrudRepository.findById(courseId).map(curso-> mapper.toCourse(curso));
    }

    @Override
    public Course save(Course course) {
        Curso curso = mapper.toCurso(course);
        return mapper.toCourse(cursoCrudRepository.save(curso));
    }

    @Override
    public void delete(int courseId) {
        cursoCrudRepository.deleteById(courseId);
    }
}
