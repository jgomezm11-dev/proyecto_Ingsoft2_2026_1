package co.vinni.clientes.dominio.modelo;

import lombok.Builder;

@Builder
public class Cliente {
    public String identificacion;
    public String nombreCompleto;
    public Integer edad;
    public String correo;
    public String telefono;
}
