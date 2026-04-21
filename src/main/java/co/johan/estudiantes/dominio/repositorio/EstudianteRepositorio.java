package co.johan.estudiantes.dominio.repositorio;

import co.johan.estudiantes.dominio.modelo.Estudiante;

import java.util.List;

public interface EstudianteRepositorio {
    void crear(Estudiante estudiante);
    List<Estudiante> obtenerTodos();

}
