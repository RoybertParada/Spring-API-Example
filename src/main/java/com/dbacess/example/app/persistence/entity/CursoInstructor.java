package com.dbacess.example.app.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CursoInstructor")
public class CursoInstructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CursoInstructorId")
    private Integer cursoInstructorId;

    @ManyToOne
    @MapsId("instructorId")
    @JoinColumn(name = "instructorId", insertable = false, updatable = false)
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "cursoId", insertable = false, updatable = false)
    private Curso curso;


    private Date inicio;
    private Date fin;
    private String nombre;

    public Integer getCursoInstructorId() {
        return cursoInstructorId;
    }

    public void setCursoInstructorId(Integer cursoInstructorId) {
        this.cursoInstructorId = cursoInstructorId;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
