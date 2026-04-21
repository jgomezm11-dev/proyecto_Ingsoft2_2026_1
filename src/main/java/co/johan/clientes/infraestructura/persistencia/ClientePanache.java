package co.johan.clientes.infraestructura.persistencia;

import co.johan.clientes.dominio.modelo.Cliente;
import co.johan.clientes.dominio.modelo.ClienteEntity;
import co.johan.clientes.dominio.repositorio.ClienteRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ClientePanache implements ClienteRepositorio, PanacheRepository<ClienteEntity>{

    @Override
    @Transactional
    public void crear(Cliente cliente) {
        ClienteEntity clienteEntity = ClienteEntity
                .builder()
                .identificacion(cliente.identificacion)
                .nombreCompleto(cliente.nombreCompleto)
                .edad(cliente.edad)
                .correo(cliente.correo)
                .telefono(cliente.telefono)
                .build();
        persist(clienteEntity);

    }

    @Override
    public List<Cliente> obtenerTodos() {
        return listAll().stream().map(
                entidad ->{
                    Cliente cliente = Cliente
                            .builder()
                            .identificacion(entidad.identificacion)
                            .nombreCompleto(entidad.nombreCompleto)
                            .edad(entidad.edad)
                            .correo(entidad.correo)
                            .telefono(entidad.telefono)
                            .build();
                    return cliente;
                }
        ).toList();
    }
}
