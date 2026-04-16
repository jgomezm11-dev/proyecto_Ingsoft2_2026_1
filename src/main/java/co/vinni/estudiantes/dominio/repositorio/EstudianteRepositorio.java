package co.vinni.estudiantes.dominio.repositorio;

import co.vinni.estudiantes.dominio.modelo.Estudiante;

import java.util.List;

public interface EstudianteRepositorio {
    void crear(Estudiante estudiante);
    List<Estudiante> obtenerTodos();

}
