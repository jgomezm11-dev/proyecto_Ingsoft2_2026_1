package co.johan.clientes.dominio.repositorio;

import co.johan.clientes.dominio.modelo.Cliente;

import java.util.List;

public interface ClienteRepositorio {
    void crear(Cliente cliente);
    List<Cliente> obtenerTodos();

}
