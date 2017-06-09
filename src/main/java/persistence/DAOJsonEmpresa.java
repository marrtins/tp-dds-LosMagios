package persistence;
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

import modelo.Cuenta;
import modelo.Empresa;

//import Domain.Empleado;


public class DAOJsonEmpresa implements DAOEmpresa {

	private String filePath = "C:\\Users\\martin\\Git\\3-LosMagios\\bd\\empresas.json";
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
		/*String empresaSerializada = myGson.toJson(empresa);
		this.writeJson(empresaSerializada);*/
		ArrayList<Empresa> empresas = this.getAllEmpresas();
		empresas.add(empresa);
		String empresasSerializadas = myGson.toJson(empresas);
		this.writeNewJson(empresasSerializadas);
	}

	public void delete(Empresa empresa) throws IOException{
		ArrayList<Empresa> empresas = this.getAllEmpresas();

		for(int i=0; i<empresas.size(); i++){
			/*if(empresas.get(i).getId()==empresa.getId()){
				empresas.remove(empresas.get(i));
				i = empresas.size();
			}*/
		}
		String empresaSerializada = myGson.toJson(empresas);
		this.writeNewJson(empresaSerializada);

	}

	public ArrayList<Empresa> getAllEmpresas() throws IOException{
		FileReader reader = new	FileReader(this.filePath);
		this.bufferToReader = new BufferedReader(reader);
		ArrayList<Empresa> empresas = this.myGson.fromJson(getJson(), new TypeToken<ArrayList<Empresa>>(){}.getType());
		return empresas;
	}

	public void update(Empresa empresa) throws IOException{
		ArrayList<Empresa> empresas = this.getAllEmpresas();
		String empresaSerializada = myGson.toJson(empresa);
		for(int i=0; i<empresas.size(); i++){
			String n1 = empresas.get(i).getNombreEmpresa();
			String n2 = empresa.getNombreEmpresa();
			if(n1.equals(n2)){
				empresas.set(i, empresa);
				
			}
		}
		String empresasSerializadas = myGson.toJson(empresas);
		this.writeNewJson(empresasSerializadas);
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
	
	private void writeNewJson(String empresaSerialized) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter(this.filePath, false));
		this.bufferToWrite.write(empresaSerialized);
		this.bufferToWrite.close();
	}
	
	
	
}