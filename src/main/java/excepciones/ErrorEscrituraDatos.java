package excepciones;

import java.io.IOException;

public class ErrorCargaDatos extends IOException{
	public ErrorCargaDatos(Exception e){
		super("Error al cargar los datos.", e);
	}
}
