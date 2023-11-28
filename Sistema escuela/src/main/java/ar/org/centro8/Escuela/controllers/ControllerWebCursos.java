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

import ar.org.centro8.Escuela.entities.Curso;
import ar.org.centro8.Escuela.repositories.CursoRepository;


@Controller
public class ControllerWebCursos { //Con este controler decido que se publica y que no, es importante para seguridad


    @Autowired // --> TENGO QUE HACER ESTO CON ALUMNOS TAMBIEN
    private CursoRepository cr;

    private String mensajeCurso="Ingrese un nuevo curso!";//quiero que la web muestre este mensaje
       
    /* 
    @GetMapping("/dispositivos")
    public String dispositivos(Model model){
        model.addAttribute("lista", ar.findAll());
        return "dispositivos";
    }
    */

    @GetMapping("/cursos")

    public String getCurso(
        @RequestParam(name="buscarTitulo",required = false , defaultValue = "") String buscarTitulo,
        Model model) {
        //dr.findAll().forEach(System.out::println); esto es para ver la base de datos en la consola
        model.addAttribute("mensajeCurso", mensajeCurso);
        //model.addAttribute("mensaje", mensaje);
        //bajo el nombre "mensaje" yo estoy autorizando a que se vea la variable "mensaje" en el frontend
        model.addAttribute("curso",new Curso());

        model.addAttribute("lista", cr.findAll());
        //tengo un problema con esto, despues lo arreglo

        model.addAttribute("listaTitulo", ((List<Curso>) cr.findAll())
                    .stream()
                    .filter(c -> c.getTitulo().toLowerCase().contains(buscarTitulo.toLowerCase()))
                    .toList());

        return "cursos";
    }

    @PostMapping("/saveCurso")
    public String save(@ModelAttribute Curso curso){
        
        System.out.println("*****************************************************");
        System.out.println(curso); //para ver en consola si esta bien guardado
        System.out.println("*****************************************************");
        // dispositivo.setId(0);
        cr.save(curso);

        if(curso.getId()>0){
            mensajeCurso="se guardo el Curso con ID:"+curso.getId()+"!";
        }else{
            mensajeCurso="no se pudo guardar el curso";
        };

        return "redirect:cursos";
    }
    
}
