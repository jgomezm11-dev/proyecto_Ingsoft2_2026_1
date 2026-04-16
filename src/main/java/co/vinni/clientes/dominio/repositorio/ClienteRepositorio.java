package co.vinni.clientes.dominio.repositorio;

import co.vinni.clientes.dominio.modelo.Cliente;

import java.util.List;

public interface ClienteRepositorio {
    void crear(Cliente cliente);
    List<Cliente> obtenerTodos();

}
