package com.dbacess.example.app.domain;

public class InstructorDomain {
    private int instructorDomainId;
    private String name;
    private String description;

    public int getInstructorDomainId() {
        return instructorDomainId;
    }

    public void setInstructorDomainId(int instructorDomainId) {
        this.instructorDomainId = instructorDomainId;
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
}
