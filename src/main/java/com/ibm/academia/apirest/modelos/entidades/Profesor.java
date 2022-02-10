package com.ibm.academia.apirest.modelos.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "profesores", schema = "universidad")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona implements Serializable {
    @Column(name = "sueldo", nullable = false)
    private BigDecimal sueldo;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(
            name = "profesor_carrera", schema = "universidad",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    private Set<Carrera> carreras;

    public Profesor(Long id, String dni, String nombre, String apellido, Direccion direccion, BigDecimal sueldo, String usuarioCreacion) {
        super(id, dni, nombre, apellido, direccion, usuarioCreacion);
        this.sueldo = sueldo;
    }
}
