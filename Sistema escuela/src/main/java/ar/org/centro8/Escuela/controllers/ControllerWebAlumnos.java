// como una aduana que me diga que pasar y que no al html


package ar.org.centro8.Escuela.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.Escuela.entities.Alumno;
import ar.org.centro8.Escuela.repositories.AlumnoRepository;

import ar.org.centro8.Escuela.entities.Curso;
import ar.org.centro8.Escuela.repositories.CursoRepository;


@Controller
public class ControllerWebAlumnos { //Con este controler decido que se publica y que no, es importante para seguridad

    @Autowired //se va a engargar de fabricar todo el objeto y guardarlo automaticamente
    private AlumnoRepository ar;

    @Autowired // --> TENGO QUE HACER ESTO CON ALUMNOS TAMBIEN
    private CursoRepository cr;

    private String mensajeAlumno="Ingrese un nuevo alumno!";//quiero que la web muestre este mensaje

    @GetMapping("/")
    public String getIndex(Model model) {
        //dr.findAll().forEach(System.out::println); esto es para ver la base de datos en la consola
        //model.addAttribute("mensaje", mensaje);
        //model.addAttribute("mensaje", mensaje);
        //bajo el nombre "mensaje" yo estoy autorizando a que se vea la variable "mensaje" en el frontend
        
        //model.addAttribute("dispositivo",new Dispositivo());
    
        
        return "index";
    }
    
    /* 
    @GetMapping("/dispositivos")
    public String dispositivos(Model model){
        model.addAttribute("lista", ar.findAll());
        return "dispositivos";
    }
    */

    @GetMapping("/alumnos")
    public String getAlumno(
        @RequestParam(name="buscarAlumno",required = false , defaultValue = "") String buscarAlumno,
        Model model) {
        //dr.findAll().forEach(System.out::println); esto es para ver la base de datos en la consola
        model.addAttribute("mensajeAlumno", mensajeAlumno);
        //model.addAttribute("mensaje", mensaje);
        //bajo el nombre "mensaje" yo estoy autorizando a que se vea la variable "mensaje" en el frontend
        model.addAttribute("alumno",new Alumno());

        model.addAttribute("lista", ar.findAll());
        model.addAttribute("listaCurso", ((List<Curso>) cr.findAll()));
        //lo comentarie, pero me sirve para listar todos los alumnos?

        model.addAttribute("listaApellido", ((List<Alumno>) ar.findAll())
            .stream()
            .filter(a -> a.getApellido().toLowerCase().contains(buscarAlumno.toLowerCase()))
            .toList());
    
        
        return "alumnos";
    }


    
    @PostMapping("/saveAlumno")
    public String save(@ModelAttribute Alumno alumno){
        
        System.out.println("*****************************************************");
        System.out.println(alumno); //para ver en consola si esta bien guardado
        System.out.println("*****************************************************");
        // dispositivo.setId(0);
        ar.save(alumno);

        if(alumno.getId()>0){
            mensajeAlumno="se guardo el Alumno con ID:"+alumno.getId()+"!";
        }else{
            mensajeAlumno="no se pudo guardar el alumno";
        };

        return "redirect:alumnos";
    }
    
}
