package pe.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import pe.cibertec.model.Persona;
import pe.cibertec.repository.IPersonaRepository;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    IPersonaRepository personaRepository;

    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    public Persona obtenerPorId(Integer id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrado"));
    }

    public void agregarPersona(Persona persona) {
        personaRepository.save(persona);

    }

    public String actualizarPersona(Integer id, Persona persona) {
        return personaRepository.findById(id)
                .map(updatePersona -> {
                    updatePersona.setNombres(persona.getNombres());
                    updatePersona.setApellidos(persona.getApellidos());
                    updatePersona.setEmail(persona.getEmail());
                    updatePersona.setTelefono(persona.getTelefono());
                    personaRepository.save(updatePersona);
                    return "Persona se actualizo correctamente";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Persona con ID: " + id));
    }

    public String eliminarPersona(Integer id) {
        return personaRepository.findById(id).
                map(existingPersona -> {
                    personaRepository.delete(existingPersona);
                    return "Persona eliminado correctamente";
                }).orElse("Persona no encontrada con ID: " + id);

    }

    public Persona obtenerPorDni(String dni) {
        return personaRepository.findByDni(dni)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrado con DNI: " + dni));
    }
}
