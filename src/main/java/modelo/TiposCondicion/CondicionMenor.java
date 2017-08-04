package modelo.TiposCondicion;

import java.io.IOException;
import java.util.ArrayList;

import modelo.Empresa;
import modelo.Indicador;
import modelo.TipoCondicion;

public class CondicionMenor extends TipoCondicion {
	public CondicionMenor(String formatoCondicion) {
		super(formatoCondicion);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Empresa> aplicar(ArrayList<Empresa> empresas) throws IOException {

		Indicador roe = this.getIndicador("ROE");
		empresas.removeIf(unaEmpresa->!unaEmpresa.indicadorConsistenteEnAnios(roe,10));
		return empresas;
	}

}
