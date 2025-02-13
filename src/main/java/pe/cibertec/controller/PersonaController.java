package pe.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.model.Persona;
import pe.cibertec.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/api/ms-persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/listPersonas")
    public ResponseEntity<List<Persona>> listarPersonas() {
        return ResponseEntity.ok(personaService.listarPersonas());
    }

    @GetMapping("/Persona/{id}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable Integer id) {
        return ResponseEntity.ok(personaService.obtenerPersonaPorId(id));
    }

    @PostMapping("/agregarPersona")
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona persona) {
        return ResponseEntity.status(201).body(personaService.agregarPersona(persona));
    }

    @PutMapping("/actualizarPersona/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.actualizarPersona(id, persona));
    }

    @DeleteMapping("/eliminarPersona/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Integer id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }

}
