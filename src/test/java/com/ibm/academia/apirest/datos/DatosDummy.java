package com.ibm.academia.apirest.datos;

import java.math.BigDecimal;

import com.ibm.academia.apirest.enumeradores.TipoEmpleado;
import com.ibm.academia.apirest.modelos.entidades.*;

import static java.lang.Long.valueOf;

public class DatosDummy {
	public static Carrera carrera01() 
	{
		return new Carrera(valueOf(0), "Ingenieria en Sistemas", 50, 5, "nsegura");
	}

	public static Carrera carrera02() 
	{
		return new Carrera(valueOf(1), "Licenciatura en Sistemas", 45, 4, "nsegura");
	}

	public static Carrera carrera03() 
	{
		return new Carrera(valueOf(2), "Ingenieria Industrial", 60, 5, "nsegura");
	}
	
	public static Persona empleado01() {return new Empleado(null, "25147036", "Lautaro", "Lopez", new Direccion(), new BigDecimal("46750"), TipoEmpleado.ADMINISTRATIVO, "nsegura");}
	
	public static Persona empleado02() {return new Empleado(null, "25174630", "Lenadro", "Lopez", new Direccion(), new BigDecimal("46750.70"), TipoEmpleado.MANTENIMIENTO, "nsegura");}
	
	public static Persona profesor01() {return new Profesor(null, "4477899", "Martin", "Axacar", new Direccion(), new BigDecimal("600000"), "nsegura");}
	
	public static Persona alumno01()
	{
		return new Alumno(null, "Jhon", "Benitez", "4223715", new Direccion(), "nsegura");
	}
	
	public static Persona alumno02() { return new Alumno(null, "Andres", "Benitez", "45233891", new Direccion(), "nsegura");}

	public static Persona alumno03() {return new Alumno(null, "Joaquin", "Leon", "45233012", new Direccion(), "nsegura");}

	public static Pabellon pabellon01() { return new Pabellon(valueOf(0), 500.0, "Kala", new Direccion(), "luisceciliano"); }
}