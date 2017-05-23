package ControlRemotoUniversal;

// este es uno de los ConcreteCommand 

public class AbrirGarage implements Command {
	private Garage garage;
	
	public AbrirGarage(Garage garage){ // constructor 
		this.garage = garage;
	}
	
	public void execute(){
		garage.subir();
	}
	
	public void deshacer(){
		garage.bajar();
	}

}
