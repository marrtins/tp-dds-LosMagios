package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entities.Empresa;
import entities.Usuario;

public class DAOJsonUsuario implements DAOUsuario {

	
	private String filePath = "C:\\Users\\martin\\Git\\3-LosMagios\\bd\\usuarios.json";
	private Gson myGson;
	private BufferedReader bufferToReader;
	private BufferedWriter bufferToWrite;
	
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	public ArrayList<Usuario> getAllUsuarios() throws IOException{
		FileReader reader = new	FileReader(this.filePath);
		this.bufferToReader = new BufferedReader(reader);
		ArrayList<Usuario> usuarios = this.myGson.fromJson(getJson(), new TypeToken<ArrayList<Usuario>>(){}.getType());
		return usuarios;
	}

	
	
	private String getJson() throws IOException{
		StringBuilder userSerial = new StringBuilder();
		String linea;
		while( (linea=this.bufferToReader.readLine()) != null){
			userSerial.append(linea);
		};
		this.bufferToReader.close();
		return userSerial.toString();
	}


}
