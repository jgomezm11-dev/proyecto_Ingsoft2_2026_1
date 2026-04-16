package co.vinni.estudiantes.infraestructura;

import co.vinni.estudiantes.aplicacion.EstudianteServicio;
import co.vinni.estudiantes.dominio.modelo.Estudiante;
import co.vinni.estudiantes.infraestructura.dto.EstudianteDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@Path("/estudiantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstudianteRecursos {

    @Inject
    EstudianteServicio estudianteServicio;

    @POST
    @Operation(
        summary = "Crear un nuevo Estudiante",
        description = "Registra el Estudiante con sus datos nombre, apellido y correo"
    )
    @APIResponse(
        responseCode = "201",
        description = "Estudiante creado"
    )
    @APIResponse(
        responseCode = "400",
        description = "Datos de entrada invalidos"
    )
    public Response crear(@Valid EstudianteDto estudianteDto) {
        Estudiante estudiante = Estudiante
                .builder()
                .nombreCompleto(estudianteDto.nombreCompleto())
                .identificacion(estudianteDto.identificacion())
                .edad(estudianteDto.edad())
                .correo(estudianteDto.correo())
                .programaAcademico(estudianteDto.programaAcademico())
                .build();
        estudianteServicio.crear(estudiante);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Operation(summary = "Lista todos los estudiante")
    public Response obtenerTodos() {
        List<EstudianteDto> estudianteDtos = estudianteServicio.listar().stream()
                .map(estudiante -> new EstudianteDto(estudiante.nombreCompleto,  estudiante.identificacion, estudiante.edad,  estudiante.correo, estudiante.programaAcademico ) )
                .toList();
        return Response.status(Response.Status.OK).entity(estudianteDtos).build();
    }
}
