package co.johan.clientes.servicio;

import co.johan.clientes.aplicacion.ClienteServicio;
import co.johan.clientes.dominio.modelo.Cliente;
import co.johan.clientes.dominio.repositorio.ClienteRepositorio;
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
public class ClienteServicioTest {
    @Inject
    ClienteServicio clienteServicio;

    @InjectMock
    ClienteRepositorio clienteRepositorio;
    private Cliente clientePrueba;
    @BeforeEach
    public void setup(){
        clientePrueba = Cliente
                .builder()
                .nombreCompleto("Elsa")
                .edad(15)
                .correo("correo@correo.com")
                .build();

    }
    @Test
    public void testCrearCliente(){
        clienteServicio.crear(clientePrueba);
        verify(clienteRepositorio, times(1)).crear(any(Cliente.class));
    }
    @Test
    public void testListaEstudiantes(){
        Mockito.when(clienteRepositorio.obtenerTodos()).thenReturn(List.of(clientePrueba));
        var resultado = clienteServicio.listar();
        Assertions.assertFalse(resultado.isEmpty());
        Assertions.assertEquals("Elsa", resultado.get(0).nombreCompleto);
    }
}
