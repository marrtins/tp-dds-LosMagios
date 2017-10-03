package model;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Usuario;

public class UsuarioModel {
	private List<Usuario> usuarios;
	private static UsuarioModel instance = null;
	
	
	
	public static UsuarioModel getInstance(){
		if(instance==null){
			instance = new UsuarioModel();
		}
		return instance;
	}
	
	
	private UsuarioModel() {
		this.usuarios = new LinkedList<>();
		this.boot();
	}
	
	public void boot(){

	}
	
	public void addUsuario(Usuario usuario){
		this.usuarios.add(usuario);
	}
	
	public List<Usuario> getAll(){
		return this.usuarios;
	}
	
	public Usuario get(String nombreUsuario){
		List<Usuario> lista = this.usuarios.stream().filter(s->s.getNombre().equals(nombreUsuario)).collect(Collectors.toList());
		return lista.get(0);
	}
	
	
	
}
