package pe.cibertec.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    private String dni;
    private String nombres;
    private String apellidos;
    private int edad;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaNac;
    private String direccion;
    private String email;
    private String telefono;
}
