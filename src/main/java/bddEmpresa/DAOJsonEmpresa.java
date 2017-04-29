package bddEmpresa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import clases.Empresa;

//import Domain.Empleado;


public class DAOJsonEmpresa implements DAOEmpresa {

	private String filePath;
	private Gson myGson;
	private BufferedReader bufferToReader;
	private BufferedWriter bufferToWrite;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public DAOJsonEmpresa() {
		super();
		this.myGson = new Gson();
	}

	public void add(Empresa empresa) throws IOException{
		String empresaSerializada = myGson.toJson(empresa);
		this.writeJson(empresaSerializada);
	}

	public void delete(Empresa empresa){

	}

	public ArrayList<Empresa> getAllEmpresas() throws IOException{
		FileReader reader = new	FileReader(this.filePath);
		this.bufferToReader = new BufferedReader(reader);
		ArrayList<Empresa> empresas = this.myGson.fromJson(getJson(), new TypeToken<ArrayList<Empresa>>(){}.getType());
		return empresas;
	}

	public void update(Empresa empresa){

	}
	
	private String getJson() throws IOException{
		StringBuilder empresaSerializada = new StringBuilder();
		String linea;
		while( (linea=this.bufferToReader.readLine()) != null){
			empresaSerializada.append(linea);
		};
		this.bufferToReader.close();
		return empresaSerializada.toString();
	}

	private void writeJson(String empresaSerialized) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter(this.filePath, true));
		this.bufferToWrite.append(empresaSerialized);
		this.bufferToWrite.close();
	}
}