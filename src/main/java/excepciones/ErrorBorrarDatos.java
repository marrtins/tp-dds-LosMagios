package excepciones;

import java.io.IOException;

public class ErrorBorrarDatos extends IOException{
	public ErrorBorrarDatos(Exception e){
		super("Error al intentar borrar los datos. Verifique que existan", e);
	}
}
