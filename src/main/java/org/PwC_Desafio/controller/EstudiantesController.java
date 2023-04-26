package org.PwC_Desafio.controller;

import org.PwC_Desafio.model.Cursos;
import org.PwC_Desafio.model.Estudiantes;
import org.PwC_Desafio.service.impl.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {

    private EstudiantesService estudiantesService;

    @Autowired
    public void setService(EstudiantesService estudiantesService) { this.estudiantesService = estudiantesService; }

    //---------------------------------------------------------------------------------------------------
    // TODO: Parte del requerimiento del desafío.
    /* Matriculamos un estudiante a un curso */
    @PutMapping("/{id}")
    public ResponseEntity<Estudiantes> matricularEstudiante(@PathVariable Long id, @RequestParam Long idCurso) {
        return ResponseEntity.ok(estudiantesService.matricularEstudiantes(id, idCurso));
    }
    //----------------------------------------------------------------------------------------------------
    // Adicional

    /* Agregamos un estudiante */
    @PostMapping
    public ResponseEntity<Estudiantes> crearEstudiantes(@RequestBody Estudiantes estudiante) {
        return ResponseEntity.ok(estudiantesService.crearEstudiantes(estudiante));
    }

    /* Buscamos un estudiante por su id */
    @GetMapping("/{id}")
    public ResponseEntity<Estudiantes> buscarEstudiantesPorId(@PathVariable Long id){
        Estudiantes estudianteABuscar = estudiantesService.buscarEstudiantesPorId(id);

        if(estudianteABuscar == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudianteABuscar);
    }

    /* Borramos un estudiante */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiantes(@PathVariable Long id){
        estudiantesService.eliminarEstudiantes(id);
        return ResponseEntity.ok().build();
    }

    /* Desmatriculamos un estudiante de un curso */
    @PutMapping("/{id}")
    public ResponseEntity<Estudiantes> desmatricularEstudiantes(@PathVariable Long id) {
        return ResponseEntity.ok(estudiantesService.desmatricularEstudiantes(id));
    }
}
