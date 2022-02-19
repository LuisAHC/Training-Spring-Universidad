package com.ibm.academia.apirest.modelos.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarreraDTO implements Serializable {
	private Long carreraId;
	private String nombre;
	private Integer cantidadMaterias;
	private Integer cantidadAnios;
	private Date fechaCreacion;
}