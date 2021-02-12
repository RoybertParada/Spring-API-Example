package com.dbacess.example.app.domain;

import java.time.LocalDateTime;

public class Period {
    private String periodId;
    private String year;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private InstructorDTO instructor;
    private Course curso;

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public InstructorDTO getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorDTO instructor) {
        this.instructor = instructor;
    }

    public Course getCurso() {
        return curso;
    }

    public void setCurso(Course curso) {
        this.curso = curso;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
