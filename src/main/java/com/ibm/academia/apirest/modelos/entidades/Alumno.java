package com.ibm.academia.apirest.modelos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "alumnos", schema = "universidad")
//@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona implements Serializable{
    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "carrera_id", foreignKey = @ForeignKey(name = "FK_CARRERA_ID"))
    @JsonIgnore()
    private Carrera carrera;

    public Alumno(Long id, String nombre, String apellido, String dni, Direccion direccion, String usuarioCreacion){
        super(id, dni, nombre, apellido, direccion, usuarioCreacion);
    }
}
