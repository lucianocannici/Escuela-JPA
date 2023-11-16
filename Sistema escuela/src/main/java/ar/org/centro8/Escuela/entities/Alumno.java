package ar.org.centro8.Escuela.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//pongo ciertas anotaciones que ayudan al mapeo de la base de datos, en vez de poner uno por uno usamos esto para agilizar todo
// me las da JAVAEE o JakartaEE

@Entity //esta es una entidad de percistencia
@Table(name="Alumnos") //los obj de esta clase se guardan en la tabla Alumnos, si no existe se crea automaticamente
public class Alumno {

    @Id //este campo es primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //este campo es auto_incremental
    @Column(unique = true, nullable = false)
    Integer id; //no uso int, no uso primitivos
    String nombre;
    String apellido;
    Integer edad;
    Integer idCurso;


        //estaba esto en el curso de ejemplo, asi que lo dejo anotado por aca por si me sirve
        //@Column(name="cursos") //el autributo curso va a mapear con el atributo cursos, pero no quiero
        //@Transient que este campo exixta en la memoria pero no mapee en la base

    //Constructor Vacio
    public Alumno() {
    }

    //Constructor SIN ID
    public Alumno(String nombre, String apellido, Integer edad, Integer idCurso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.idCurso = idCurso;
    }

    //Contructor completo
    public Alumno(Integer id, String nombre, String apellido, Integer edad, Integer idCurso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.idCurso = idCurso;
    }

    //ToString
    @Override
    public String toString() {
        return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", idCurso="
                + idCurso + "]";
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    
    

    

    
}
