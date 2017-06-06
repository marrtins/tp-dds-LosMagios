package ControlRemotoUniversal;

// esta clase es el Invoker

public class ControlRemoto {
	Command[] botonesDeEncendido;
	Command[] botonesDeApagado;
	Command botonDeDeshacer;
	
	public ControlRemoto(){ // constructor
		botonesDeEncendido = new Command[7];
		botonesDeApagado = new Command[7];
		
		Command noCommand = new NoCommand();		
		for (int i =0; i < 7; i++){
			botonesDeEncendido[i] = noCommand;
			botonesDeApagado[i] = noCommand;
		}
		botonDeDeshacer = noCommand;

	}
	
	public void setBotones(int slot, Command botonDeEncendido, Command botonDeApagado){
		botonesDeEncendido[slot] = botonDeEncendido;
		botonesDeApagado[slot] = botonDeApagado;
	}
	
	public void onFuePresionado(int slot){
		botonesDeEncendido[slot].execute();
		botonDeDeshacer = botonesDeEncendido[slot];
	}
	
	public void offFuePresionado(int slot){
		botonesDeApagado[slot].execute();
		botonDeDeshacer = botonesDeApagado[slot];
	}
	
	public void deshacerFuePresionado(int slot){
		botonDeDeshacer.deshacer();
	}
}
