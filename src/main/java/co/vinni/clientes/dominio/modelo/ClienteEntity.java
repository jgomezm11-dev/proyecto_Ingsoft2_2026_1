package co.vinni.clientes.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity extends PanacheEntityBase {

    @Id
    public String identificacion;

    public String nombreCompleto;
    public Integer edad;
    public String correo;
    public String telefono;

}
