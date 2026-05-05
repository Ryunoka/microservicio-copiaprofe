package com.hospital.msvc_pacientes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pacientes")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Long pacienteId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El campo run no puede ser vacio")
    @Pattern(regexp = "^\\d{7,8}-[\\dkK]$", message = "El formato del run debe ser xxxxxxxx-x")
    private String pacienteRun;

    @Column(name = "nombre_completo", nullable = false)
    @NotBlank(message = "El campo nombre completo no puede ser vacio")
    private String nombreCompletoPaciente;

    @Embedded
    private Audit audit =  new Audit();
}
