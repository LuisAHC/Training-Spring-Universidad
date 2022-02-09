package com.ibm.academia.apirest.modelos.entidades;

import com.ibm.academia.apirest.enumeradores.TipoEmpleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "empleados", schema = "universidad")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona {
    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @Column(name = "tipo_empleado")
    @Enumerated
    private TipoEmpleado tipoEmpleado;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
    private Pabellon pabellon;

    public Empleado(Long id, String dni, String nombre, String apellido, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado, String usuarioCreacion) {
        super(id, dni, nombre, apellido, direccion, usuarioCreacion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empleado{");
        sb.append("sueldo=").append(sueldo);
        sb.append(", tipoEmpleado=").append(tipoEmpleado);
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}
