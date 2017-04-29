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
		String cuentaSerializada = myGson.toJson(cuenta);
		this.writeJson(cuentaSerializada);
	}
	
	public void delete(Cuenta cuenta){

	}
	
	public ArrayList<Cuenta> getAllCuentas() throws IOException{
		FileReader reader = new	FileReader(this.filePath);
		this.bufferToReader = new BufferedReader(reader);
		ArrayList<Cuenta> cuentas = this.myGson.fromJson(getJson(), new TypeToken<ArrayList<Cuenta>>(){}.getType());
		return cuentas;
	}
	public List
	
	public void update(Cuenta cuenta){

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

	
	
	
	
}
