package bddCuentas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import clases.Cuenta;

public class DAOJsonCuenta implements DAOCuenta {

	private String filePath;
	private Gson myGson;
	private BufferedReader bufferToReader;
	private BufferedWriter bufferToWrite;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Gson getMyGson() {
		return myGson;
	}
	public void setMyGson(Gson myGson) {
		this.myGson = myGson;
	}
	public BufferedReader getBufferToReader() {
		return bufferToReader;
	}
	public void setBufferToReader(BufferedReader bufferToReader) {
		this.bufferToReader = bufferToReader;
	}
	public BufferedWriter getBufferToWrite() {
		return bufferToWrite;
	}
	public void setBufferToWrite(BufferedWriter bufferToWrite) {
		this.bufferToWrite = bufferToWrite;
	}
	
	
	public DAOJsonCuenta() {
		super();
		this.myGson = new Gson();
	}
	
	public void add(Cuenta cuenta) throws IOException{
		/*String cuentaSerializada = myGson.toJson(cuenta);
		this.writeJson(cuentaSerializada);*/
		ArrayList<Cuenta> cuentas = this.getAllCuentas();
		cuentas.add(cuenta);
		String cuentasSerializadas = myGson.toJson(cuentas);
		this.writeNewJson(cuentasSerializadas);
	}
	
	public void delete(Cuenta cuenta) throws IOException{
		ArrayList<Cuenta> cuentas = this.getAllCuentas();
		
		for(int i=0; i<cuentas.size(); i++){
			if(cuentas.get(i).getIdCuenta()==cuenta.getIdCuenta()){
				cuentas.remove(cuentas.get(i));
				i = cuentas.size();
			}
		}
		String cuentaSerializada = myGson.toJson(cuentas);
		this.writeNewJson(cuentaSerializada);

	}
	
	public ArrayList<Cuenta> getAllCuentas() throws IOException{
		FileReader reader = new	FileReader(this.filePath);
		this.bufferToReader = new BufferedReader(reader);
		ArrayList<Cuenta> cuentas = this.myGson.fromJson(getJson(), new TypeToken<ArrayList<Cuenta>>(){}.getType());
		return cuentas;
	}

	
	public void update(Cuenta cuenta) throws IOException{
		ArrayList<Cuenta> cuentas = this.getAllCuentas();
		for(int i=0; i<cuentas.size(); i++){
			if(cuentas.get(i).getIdCuenta()==cuenta.getIdCuenta()){
				cuentas.set(i, cuenta);
			}
		}
		String empleadoSerializado = myGson.toJson(cuentas);
		this.writeNewJson(empleadoSerializado);
	}
	
	private String getJson() throws IOException{
		StringBuilder cuentaSerializada = new StringBuilder();
		String linea;
		while( (linea=this.bufferToReader.readLine()) != null){
			cuentaSerializada.append(linea);
		};
		this.bufferToReader.close();
		return cuentaSerializada.toString();
	}
	
	private void writeJson(String cuentaSerialized) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter(this.filePath, true));
		this.bufferToWrite.append(cuentaSerialized);
		this.bufferToWrite.close();
	}
	
	private void writeNewJson(String cuentaSerialized) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter(this.filePath, false));
		this.bufferToWrite.write(cuentaSerialized);
		this.bufferToWrite.close();
	}

	
	
	
	
}
