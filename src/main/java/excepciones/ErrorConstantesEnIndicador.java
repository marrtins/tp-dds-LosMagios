package excepciones;

import java.io.IOException;

public class ErrorConstantesEnIndicador extends IOException{
	public ErrorConstantesEnIndicador(Exception e){
		super("Error al intentar aplicar el indicador debido a que la cuenta o el indicador de la formula, no existe", e);
	}
}
