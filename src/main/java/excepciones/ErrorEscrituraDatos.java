package excepciones;

import java.io.IOException;

public class ErrorEscrituraDatos extends IOException{
	public ErrorEscrituraDatos(Exception e){
		super("Error al escribir los datos en el archivo. Verifique que la sintaxis sea correcta", e);
	}
}
