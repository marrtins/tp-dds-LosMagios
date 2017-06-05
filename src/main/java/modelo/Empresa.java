package modelo;

import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import modelo.Periodo;

import java.io.Serializable;

public class Empresa implements Serializable {

	private int id;
	private String nombre;
	
	public Empresa(int _id,String _nombre) {
		super();
		this.id = _id;
		this.nombre = _nombre;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}








