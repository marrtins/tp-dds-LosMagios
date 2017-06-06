package bddPeriodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import clases.Cuenta;
import clases.Empresa;
import clases.Periodo;

public class DAOJsonPeriodo implements DAOPeriodo {

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
	
	
	public DAOJsonPeriodo() {
		super();
		this.myGson = new Gson();
	}
	
	public void add(Periodo periodo) throws IOException{
		/*String periodoSerializado = myGson.toJson(periodo);
		this.writeJson(periodoSerializado);*/
		ArrayList<Periodo> periodos= this.getAllPeriodos();
		periodos.add(periodo);
		String periodosSerializados = myGson.toJson(periodos);
		this.writeNewJson(periodosSerializados);
	}
	
	public void delete(Periodo periodo) throws IOException{
		ArrayList<Periodo> periodos = this.getAllPeriodos();
		
		for(int i=0; i<periodos.size(); i++){
			if(periodos.get(i).getAnio()==periodo.getAnio()){
				periodos.remove(periodos.get(i));
			}
		}
		String periodoSerializado = myGson.toJson(periodos);
		this.writeNewJson(periodoSerializado);

	}
	
	public ArrayList<Periodo> getAllPeriodos() throws IOException{
		FileReader reader = new	FileReader(this.filePath);
		this.bufferToReader = new BufferedReader(reader);
		ArrayList<Periodo> periodos = this.myGson.fromJson(getJson(), new TypeToken<ArrayList<Periodo>>(){}.getType());
		return periodos;
	}
	
	
	
	public void update(Cuenta cuenta){
		

	}
	
	private String getJson() throws IOException{
		StringBuilder periodoSerializado = new StringBuilder();
		String linea;
		while( (linea=this.bufferToReader.readLine()) != null){
			periodoSerializado.append(linea);
		};
		this.bufferToReader.close();
		return periodoSerializado.toString();
	}
	
	private void writeJson(String periodoSerialized) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter(this.filePath, true));
		this.bufferToWrite.append(periodoSerialized);
		this.bufferToWrite.close();
	}
	
	private void writeNewJson(String periodoSerialized) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter(this.filePath, false));
		this.bufferToWrite.write(periodoSerialized);
		this.bufferToWrite.close();
	}

	
	@Override
	public void update(Periodo periodo) throws IOException {
		ArrayList<Periodo> periodos= this.getAllPeriodos();
		for(int i=0; i<periodos.size(); i++){
			if(periodos.get(i).getAnio()==periodo.getAnio()){
				periodos.set(i, periodo);
			}
		}
		String periodoSerializado = myGson.toJson(periodos);
		this.writeNewJson(periodoSerializado);
	}

	
	
	
	
}
