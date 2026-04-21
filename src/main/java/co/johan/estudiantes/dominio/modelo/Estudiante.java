package co.johan.estudiantes.dominio.modelo;

import lombok.Builder;

@Builder
public class Estudiante {
    public String identificacion;
    public String nombreCompleto;
    public Integer edad;
    public String correo;
    public String programaAcademico;
}
