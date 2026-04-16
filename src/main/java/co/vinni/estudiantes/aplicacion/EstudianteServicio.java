package co.vinni.estudiantes.aplicacion;

import co.vinni.estudiantes.dominio.modelo.Estudiante;
import co.vinni.estudiantes.dominio.repositorio.EstudianteRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class EstudianteServicio {
    @Inject
    EstudianteRepositorio repositorio;

    public void crear(Estudiante estudiante) {
        repositorio.crear(estudiante);
    }

    public List<Estudiante> listar(){return repositorio.obtenerTodos();}

}
