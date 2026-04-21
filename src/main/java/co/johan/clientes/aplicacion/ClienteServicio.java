package co.johan.clientes.aplicacion;

import co.johan.clientes.dominio.modelo.Cliente;
import co.johan.clientes.dominio.repositorio.ClienteRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClienteServicio {
    @Inject
    ClienteRepositorio repositorio;

    public void crear(Cliente cliente) {
        repositorio.crear(cliente);
    }

    public List<Cliente> listar(){return repositorio.obtenerTodos();}

}
