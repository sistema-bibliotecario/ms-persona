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
        try {
            return ResponseEntity.ok(personaService.listarPersonas());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(personaService.obtenerPorId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/agregarPersona")
    public void agregarPersona(@RequestBody Persona persona) {
        try {
            personaService.agregarPersona(persona);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/actualizarPersona/{id}")
    public ResponseEntity<String> actualizarPersona(@PathVariable Integer id, @RequestBody Persona persona) {
        try {
            return ResponseEntity.ok(personaService.actualizarPersona(id, persona));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/eliminarPersona/{id}")
    public String eliminarPersona(@PathVariable Integer id) {
        return personaService.eliminarPersona(id);
    }

    @GetMapping("/personaDni")
    public ResponseEntity<Persona> obtenerPorDni(@RequestParam String dni) {
        try {
            return ResponseEntity.ok(personaService.obtenerPorDni(dni));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

}
