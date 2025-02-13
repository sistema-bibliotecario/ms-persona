package pe.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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

    public Persona obtenerPersonaPorId(Integer id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrado"));
    }

    public Persona agregarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona actualizarPersona(Integer id, Persona persona) {
        return personaRepository.findById(id).map(updatePersona -> {
            updatePersona.setNombres(persona.getNombres());
            updatePersona.setApellidos(persona.getApellidos());
            updatePersona.setEmail(persona.getEmail());
            updatePersona.setTelefono(persona.getTelefono());
            return personaRepository.save(updatePersona);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrado"));
    }

    public void eliminarPersona(Integer id) {
        if (!personaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrado");
        }
        personaRepository.deleteById(id);
    }
}
