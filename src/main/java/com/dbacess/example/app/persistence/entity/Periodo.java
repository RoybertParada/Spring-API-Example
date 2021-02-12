package com.dbacess.example.app.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "periodo")
public class Periodo {
    @EmbeddedId
    private PeriodoPK id;

    private LocalDateTime inicio;
    private LocalDateTime fin;

    @ManyToOne
    @MapsId("instructorId")
    @JoinColumn(name = "instructorid")
    private Instructor instructor;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "cursoid")
    private Curso curso;

    public PeriodoPK getId() {
        return id;
    }

    public void setId(PeriodoPK id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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

}
