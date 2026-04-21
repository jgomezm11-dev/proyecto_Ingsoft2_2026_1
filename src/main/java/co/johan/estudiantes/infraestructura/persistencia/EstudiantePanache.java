package co.johan.estudiantes.infraestructura.persistencia;

import co.johan.estudiantes.dominio.modelo.Estudiante;
import co.johan.estudiantes.dominio.modelo.EstudianteEntity;
import co.johan.estudiantes.dominio.repositorio.EstudianteRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EstudiantePanache implements EstudianteRepositorio, PanacheRepository<EstudianteEntity>{

    @Override
    @Transactional
    public void crear(Estudiante estudiante) {
        EstudianteEntity estudianteEntity = EstudianteEntity
                .builder()
                .nombreCompleto(estudiante.nombreCompleto)
                .identificacion(estudiante.identificacion)
                .edad(estudiante.edad)
                .correo(estudiante.correo)
                .programaAcademico(estudiante.programaAcademico)
                .build();
        persist(estudianteEntity);

    }

    @Override
    public List<Estudiante> obtenerTodos() {
        return listAll().stream().map(
                entidad ->{
                    Estudiante estudiante = Estudiante
                            .builder()
                            .nombreCompleto(entidad.nombreCompleto)
                            .identificacion(entidad.identificacion)
                            .edad(entidad.edad)
                            .correo(entidad.correo)
                            .programaAcademico(entidad.programaAcademico)
                            .build();
                    return estudiante;
                }
        ).toList();
    }
}
