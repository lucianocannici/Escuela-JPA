package ar.org.centro8.Escuela.repositories;

import org.springframework.data.repository.CrudRepository;

import ar.org.centro8.Escuela.entities.Alumno;

public interface AlumnoRepository //aca no agregamos nada, lo crea JPA Y  SPRINGDATA solo en tiempo de ejecucion
    extends CrudRepository<Alumno, Integer> {

}

 

