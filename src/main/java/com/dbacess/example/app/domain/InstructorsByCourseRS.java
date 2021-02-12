package com.dbacess.example.app.domain;

import java.util.List;

public class InstructorsByCourseRS {
    private Long courseId;
    private List<InstructorDTO> instructors;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<InstructorDTO> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<InstructorDTO> instructors) {
        this.instructors = instructors;
    }

}
