package co.vinni.clientes.infraestructura;

import co.vinni.clientes.aplicacion.ClienteServicio;
import co.vinni.clientes.dominio.modelo.Cliente;
import co.vinni.clientes.infraestructura.dto.ClienteDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteRecursos {

    @Inject
    ClienteServicio clienteServicio;

    @POST
    @Operation(
        summary = "Crear un nuevo cliente",
        description = "Registra el cliente con sus datos nombre, apellido y correo"
    )
    @APIResponse(
        responseCode = "201",
        description = "cliente creado"
    )
    @APIResponse(
        responseCode = "400",
        description = "Datos de entrada invalidos"
    )
    public Response crear(@Valid ClienteDto clienteDto) {
        Cliente cliente = Cliente
                .builder()
                .identificacion(clienteDto.identificacion())
                .nombreCompleto(clienteDto.nombreCompleto())
                .edad(clienteDto.edad())
                .correo(clienteDto.correo())
                .telefono(clienteDto.telefono())
                .build();
        clienteServicio.crear(cliente);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Operation(summary = "Lista todos los cliente")
    public Response obtenerTodos() {
        List<ClienteDto> clienteDtos = clienteServicio.listar().stream()
                .map(cliente -> new ClienteDto(cliente.nombreCompleto,  cliente.identificacion, cliente.edad,  cliente.correo, cliente.telefono ) )
                .toList();
        return Response.status(Response.Status.OK).entity(clienteDtos).build();
    }
}
