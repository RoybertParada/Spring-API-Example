package com.dbacess.example.app.web;

import com.dbacess.example.app.domain.*;
import com.dbacess.example.app.domain.service.CourseService;
import com.dbacess.example.app.domain.service.InstructorDomainService;
import com.dbacess.example.app.domain.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private PeriodService periodService;

    @Autowired
    private InstructorDomainService instructorDomainService;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAll(){
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourse(@PathVariable Long courseId){
        return courseService.getCourse(courseId)
                .map(course -> new ResponseEntity<>(course, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByNombre(@PathVariable("name") String name) {
        return courseService.getByNombre(name)
                .map(course -> new ResponseEntity<>(course, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Course> save(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long courseId) {
        if (courseService.delete(courseId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/instructors/{coursesId}")
    public ResponseEntity<?> getAllInstructorsCourses(@PathVariable List<Long> coursesId) {
        List<InstructorsByCourseRS> instructorsRS = new ArrayList<>();
        List<InstructorDTO> instructors = new ArrayList<>();
        for(Long courseId: coursesId){
            InstructorsByCourseRS instructorsByCourseRS = new InstructorsByCourseRS();
            instructorsByCourseRS.setCourseId(courseId);
            List<Period> periods = periodService.findAllPeriodByCourseId(courseId);
            for(Period period: periods){
                period.getInstructor().setPeriodId(period.getPeriodId());
                period.getInstructor().setYear(period.getYear());
                instructors.add(period.getInstructor());
            }
            instructorsByCourseRS.setInstructors(instructors);
            instructorsRS.add(instructorsByCourseRS);
        }
        return new ResponseEntity<>(instructorsRS, HttpStatus.OK);
    }

    @GetMapping("/instructors/all")
    public ResponseEntity<?> getAllInstructorsCourses() {
        List<Course> courses;
        courses = courseService.getAll();
        List<InstructorsByCourseRS> instructorsRS = new ArrayList<>();
        for(Course course: courses){
            List<InstructorDTO> instructors = new ArrayList<>();
            InstructorsByCourseRS instructorsByCourseRS = new InstructorsByCourseRS();
            instructorsByCourseRS.setCourseId(course.getCourseId());
            List<Period> periods = periodService.findAllPeriodByCourseId(course.getCourseId());
            for(Period period: periods){
                period.getInstructor().setPeriodId(period.getPeriodId());
                period.getInstructor().setYear(period.getYear());
                instructors.add(period.getInstructor());
            }
            instructorsByCourseRS.setInstructors(instructors);
            instructorsRS.add(instructorsByCourseRS);
        }
        return new ResponseEntity<>(instructorsRS, HttpStatus.OK);
    }
}
