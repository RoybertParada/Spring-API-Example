package com.dbacess.example.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstructorDTO {
    private Long instructorDTOId;
    private String name;
    private String description;
    private String periodId;
    private String year;

    @JsonProperty("instructorId")
    public Long getinstructorDTOId() {
        return instructorDTOId;
    }

    public void setinstructorDTOId(Long instructorDTOId) {
        this.instructorDTOId = instructorDTOId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
