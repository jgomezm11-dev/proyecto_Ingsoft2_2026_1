package co.johan.estudiantes.infraestructura.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EstudianteDto(
        @NotBlank(message = "El nombre es requerido")
        String identificacion,
        @NotBlank(message = "El nombre es requerido")
        String nombreCompleto,
        @NotNull(message = "La edad es requerida")
        Integer edad,
        @Email(message = "El formato del correo es incorrecto")
        @NotBlank(message = "El email es requerido")
        String correo,
        @NotBlank(message = "El programa académico es requerido")
        String programaAcademico

) {
}