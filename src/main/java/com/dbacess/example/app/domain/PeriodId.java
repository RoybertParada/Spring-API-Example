package com.dbacess.example.app.domain;


public class PeriodId {
    private Long cursoId;
    private Long instructorId;
    private String periodoId;
    private String year;

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(String periodoId) {
        this.periodoId = periodoId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
