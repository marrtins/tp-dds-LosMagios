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
import modelo.Indicador;
import modelo.Indicador;



public class DAOJsonIndicador implements DAOIndicador {

	private String filePathIndicador = "C:\\Users\\martin\\Git\\3-LosMagios\\bd\\indicadores.json";
	private Gson myGson;
	private BufferedReader bufferToReader;
	private BufferedWriter bufferToWrite;
	
	public void setFilePath(String filePath) {
		this.filePathIndicador = filePath;
	}

	public DAOJsonIndicador() {
		super();
		this.myGson = new Gson();
	}

	public void add(Indicador indicador) throws IOException{
		ArrayList<Indicador> indicadores = this.getAllIndicadores();
		indicadores.add(indicador);
		String indicadoresSerializados = myGson.toJson(indicadores);
		this.writeNewJson(indicadoresSerializados);
	}

	public void delete(String nombreIndicador) throws IOException{
		ArrayList<Indicador> indicadores = this.getAllIndicadores();
		indicadores.removeIf(unIndicador->unIndicador.getNombreIndicador().equals(nombreIndicador));				
		String indicadorSerializado = myGson.toJson(indicadores);
		this.writeNewJson(indicadorSerializado);

	}

	public ArrayList<Indicador> getAllIndicadores() throws IOException{
		FileReader reader = new	FileReader(this.filePathIndicador);
		this.bufferToReader = new BufferedReader(reader);
		ArrayList<Indicador> indicadores = this.myGson.fromJson(getJson(), new TypeToken<ArrayList<Indicador>>(){}.getType());
		return indicadores;
	}

	public void update(Indicador indicador) throws IOException{
		ArrayList<Indicador> indicadores = this.getAllIndicadores();
		for(int i=0; i<indicadores.size(); i++){
			String n1 = indicadores.get(i).getNombreIndicador();
			String n2 = indicador.getNombreIndicador();
			if(n1.equals(n2)){
				indicadores.set(i, indicador);
				
			}
		}
		String indicadoresSerializados = myGson.toJson(indicadores);
		this.writeNewJson(indicadoresSerializados);
	}
	
	private String getJson() throws IOException{
		StringBuilder indicadorSerializado = new StringBuilder();
		String linea;
		while( (linea=this.bufferToReader.readLine()) != null){
			indicadorSerializado.append(linea);
		};
		this.bufferToReader.close();
		return indicadorSerializado.toString();
	}

	private void writeJson(String indicadorSerializado) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter(this.filePathIndicador, true));
		this.bufferToWrite.append(indicadorSerializado);
		this.bufferToWrite.close();
	}
	
	private void writeNewJson(String indicadorSerializado) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter(this.filePathIndicador, false));
		this.bufferToWrite.write(indicadorSerializado);
		this.bufferToWrite.close();
	}
	
	
	
}