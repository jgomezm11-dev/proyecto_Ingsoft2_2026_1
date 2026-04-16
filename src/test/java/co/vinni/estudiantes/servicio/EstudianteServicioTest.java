package co.vinni.estudiantes.servicio;

import co.vinni.estudiantes.aplicacion.EstudianteServicio;
import co.vinni.estudiantes.dominio.modelo.Estudiante;
import co.vinni.estudiantes.dominio.repositorio.EstudianteRepositorio;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;


@QuarkusTest
public class EstudianteServicioTest {
    @Inject
    EstudianteServicio estudianteServicio;

    @InjectMock
    EstudianteRepositorio estudianteRepositorio;
    private Estudiante estudiantePrueba;
    @BeforeEach
    public void setup(){
        estudiantePrueba = Estudiante
                .builder()
                .nombreCompleto("Elsa")
                .edad(15)
                .correo("correo@correo.com")
                .build();

    }
    @Test
    public void testCrearEstudiante(){
        estudianteServicio.crear(estudiantePrueba);
        verify(estudianteRepositorio, times(1)).crear(any(Estudiante.class));
    }
    @Test
    public void testListaEstudiantes(){
        Mockito.when(estudianteRepositorio.obtenerTodos()).thenReturn(List.of(estudiantePrueba));
        var resultado = estudianteServicio.listar();
        Assertions.assertFalse(resultado.isEmpty());
        Assertions.assertEquals("Elsa", resultado.get(0).nombreCompleto);
    }
}
