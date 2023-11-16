package ar.org.centro8.Escuela.entities;

import ar.org.centro8.Escuela.enums.Dia;
import ar.org.centro8.Escuela.enums.Turno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//pongo ciertas anotaciones que ayudan al mapeo de la base de datos, en vez de poner uno por uno usamos esto para agilizar todo
// me las da JAVAEE o JakartaEE

@Entity //esta es una entidad de percistencia
@Table(name="Cursos") //los obj de esta clase se guardan en la tabla Cursos, si no existe se crea automaticamente
public class Curso {

    @Id //este campo es primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //este campo es auto_incremental
    @Column(unique = true, nullable = false)
    Integer id; //no uso int, no uso primitivos
    String titulo;
    String profesor;
    Dia dia;
    Turno turno;


        //estaba esto en el curso de ejemplo, asi que lo dejo anotado por aca por si me sirve
        //@Column(name="cursos") //el autributo curso va a mapear con el atributo cursos, pero no quiero
        //@Transient que este campo exixta en la memoria pero no mapee en la base

    //Constructor Vacio
    public Curso() {
    }

    //Constructor sin ID
    public Curso(String titulo, String profesor, Dia dia, Turno turno) {
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    //Constructor Completo
    public Curso(Integer id, String titulo, String profesor, Dia dia, Turno turno) {
        this.id = id;
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    //ToString
    @Override
    public String toString() {
        return "Curso [id=" + id + ", titulo=" + titulo + ", profesor=" + profesor + ", dia=" + dia + ", turno=" + turno
                + "]";
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    

    

    

    



}
