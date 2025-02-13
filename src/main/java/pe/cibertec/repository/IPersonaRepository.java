package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.model.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {
}

