package excepciones;

import java.io.IOException;

public class ErrorLexico extends IOException{
	public ErrorLexico(Exception e){
		super("Error en la escritura de la formula", e);
	}
}
