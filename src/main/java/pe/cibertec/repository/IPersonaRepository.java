package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.model.Persona;

import java.util.Optional;


public interface IPersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByDni(String dni);
}

