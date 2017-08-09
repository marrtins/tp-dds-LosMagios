package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.internal.ArrayComparisonFailure;

import modelo.Cuenta;
import modelo.Empresa;
import modelo.Periodo;

public class FixtureTests {
	
	
	
	ArrayList<String> nombresCuentas;
	
	
	public ArrayList<Empresa> setearCuentasParaTest1(ArrayList<Empresa> empresas){
		
		nombresCuentas = new ArrayList<>();
		nombresCuentas.add("IngresoNetoOD");
		nombresCuentas.add("IngresoNetoCC");
		nombresCuentas.add("CapitalTotal");
		nombresCuentas.add("PasivoTotal");
		nombresCuentas.add("VentasNetas");
		nombresCuentas.add("PatrimonioNeto");

		
		int[]valoresAppleP1=new int[]{1000,	1000,20,100,10,10};
		int[]valoresAppleP2=new int[]{1000,1000,21,	101,9,10};
		int[]valoresAppleP3=new int[]{1000,1000,22,102,8,10};
		int[]valoresAppleP4=new int[]{1000,1000,23,	103,7,10};

		int[][]valoresApple={valoresAppleP1,valoresAppleP2,valoresAppleP3,valoresAppleP4};

		int[]valoresFBP1=new int[]{1000,1000,10,3,4,200};
		int[]valoresFBP2=new int[]{1000,1000,(int)11,3,3,200};
		int[]valoresFBP3=new int[]{1000,1000,(int) 12,	3,2,200};
		int[]valoresFBP4=new int[]{1000,1000,(int) 13,3,1,200};

		int[][]valoresFB={valoresFBP1,valoresFBP2,valoresFBP3,valoresFBP4};
		
		
		int[]valoresGoogleP1=new int[]{1000,1000,30,3,7,1};
		int[]valoresGoogleP2=new int[]{1000,1000,(int) 31,	3,(int) 6,1};
		int[]valoresGoogleP3=new int[]{1000,1000,(int) 32,3,(int) 5,1};
		int[]valoresGoogleP4=new int[]{1000,1000,(int) 33,3,(int) 4,1};

		
		int[][]valoresGoogle={valoresGoogleP1,valoresGoogleP2,valoresGoogleP3,valoresGoogleP4};
		
		int[]valoresPepsiP1=new int[]{1000,1000,200,3,7,1};
		int[]valoresPepsiP2=new int[]{1000,	1000,546,3,(int)6,1};
		int[]valoresPepsiP3=new int[]{1000,1000,588,3,(int)5,1};
		int[]valoresPepsiP4=new int[]{1000,1000,7897,3,(int)4,1};

		int[][]valoresPepsi={valoresPepsiP1,valoresPepsiP2,valoresPepsiP3,valoresPepsiP4};
		
		
		int[]valoresCocaP1=new int[]{1000,1000,2,40,(int) 6,1};
		int[]valoresCocaP2=new int[]{1000,1000,(int) 41,3,(int) 65,1};
		int[]valoresCocaP3=new int[]{1000,1000,(int) 42,3,3,1};
		int[]valoresCocaP4=new int[]{1000,1000,(int) 43,3,(int) 89,1};


		int[][]valoresCoca={valoresCocaP1,valoresCocaP2,valoresCocaP3,valoresCocaP4};
		
		
		empresas =this.crear5Empresas("APPLE","FB","GOOGLE","PEPSI","COCA");

		
		Empresa apple = empresas.get(0);
		Empresa fb = empresas.get(1);
		Empresa google = empresas.get(2);
		Empresa pepsi = empresas.get(3);
		Empresa coca = empresas.get(4);
		
		
		
		this.agregarCuentasAEmpresa(apple,valoresApple,4);
		this.agregarCuentasAEmpresa(fb,valoresFB,4);
		this.agregarCuentasAEmpresa(google,valoresGoogle,4);
		this.agregarCuentasAEmpresa(pepsi,valoresPepsi,4);
		this.agregarCuentasAEmpresa(coca,valoresCoca,4);
		
	

		return empresas;
	}
	
	
	public ArrayList<Empresa> setearCuentasParaTest2(ArrayList<Empresa> empresas){
		
		nombresCuentas = new ArrayList<>();
		nombresCuentas.add("IngresoNetoOD");
		nombresCuentas.add("CapitalTotal");
		nombresCuentas.add("VentasNetas");
		nombresCuentas.add("IngresoNetoCC");
		
		int[]valoresAppleP1=new int[]{2000,20,10,0};
		int[]valoresAppleP2=new int[]{2000,21,9,0};
		int[]valoresAppleP3=new int[]{2000,22,8,0};
		int[]valoresAppleP4=new int[]{2000,23,7,0};

		int[][]valoresApple={valoresAppleP1,valoresAppleP2,valoresAppleP3,valoresAppleP4};

		int[]valoresFBP1=new int[]{2000,10,4000,0};
		int[]valoresFBP2=new int[]{2000,11,4000,0};
		int[]valoresFBP3=new int[]{2000,12,4000,0};
		int[]valoresFBP4=new int[]{2000,13,4000,0};

		int[][]valoresFB={valoresFBP1,valoresFBP2,valoresFBP3,valoresFBP4};
		
		
		int[]valoresGoogleP1=new int[]{2000,30,7,0};
		int[]valoresGoogleP2=new int[]{2000,31,6,0};
		int[]valoresGoogleP3=new int[]{2000,32,5,0};
		int[]valoresGoogleP4=new int[]{2000,33,4,0};


		
		int[][]valoresGoogle={valoresGoogleP1,valoresGoogleP2,valoresGoogleP3,valoresGoogleP4};
		
		String nombreEmpresas[] = {"APPLE","FACEBOOK","GOOGLE"};
		
		empresas = this.crearXEmpresas(nombreEmpresas);
		
		Empresa apple = empresas.get(0);
		Empresa fb = empresas.get(1);
		Empresa google = empresas.get(2);
		
		this.agregarCuentasAEmpresa(apple,valoresApple,4);
		this.agregarCuentasAEmpresa(fb,valoresFB,4);
		this.agregarCuentasAEmpresa(google,valoresGoogle,4);
		
		return empresas;
		
		
		
		
	}


	public void agregarCuentasEnPeriodo(Periodo periodoAAgregar,int[] valoresCuentas){

		for(int i=0;i<valoresCuentas.length;i++){
			Cuenta unaCuenta = new Cuenta();
			unaCuenta.setear(nombresCuentas.get(i),valoresCuentas[i]);
			periodoAAgregar.agregarCuenta(unaCuenta);
		}

	}
	
	public void agregarCuentasAEmpresa(Empresa unaEmpresa, int[][]valoresCuentas,int anios){
		int firstYear = Calendar.getInstance().get(Calendar.YEAR)-1;
		int lastYear = firstYear-anios+1;
		
		int i;
		int j=0;
		for(i=firstYear;i>=lastYear;i--){
			Periodo periodoTemp = new Periodo(i);
			unaEmpresa.agregarPeriodo(periodoTemp);
			this.agregarCuentasEnPeriodo(periodoTemp, valoresCuentas[j]);
			j++;
		}
	}
	public Empresa crearEmpresa(String nombreEmpresa){
		Empresa ret = new Empresa(nombreEmpresa);
		return ret;
	}
	
	
	
	public ArrayList<Empresa> crearXEmpresas(String[] arrayDeNombres){
		
		ArrayList<Empresa> empresas = new ArrayList<>();
		
		
		int cant = arrayDeNombres.length;
		int i;
		for(i=0;i<cant;i++){
			empresas.add(this.crearEmpresa(arrayDeNombres[i]));
		}	
		return empresas;
		
	}
	
	public ArrayList<Empresa> crear5Empresas(String n1,String n2,String n3,String n4,String n5){
		
		ArrayList<Empresa> empresas = new ArrayList<>();
		
		empresas.add(this.crearEmpresa(n1));
		empresas.add(this.crearEmpresa(n2));
		empresas.add(this.crearEmpresa(n3));
		empresas.add(this.crearEmpresa(n4));
		empresas.add(this.crearEmpresa(n5));
		
			
		return empresas;
	}
	
	
	
	
	public ArrayList<Empresa> crearXPeriodosParaCadaEmpresa(ArrayList<Empresa> empresas,int cantPeriodos){
		
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int firstYear = thisYear-cantPeriodos;
		int i;

		ArrayList<Periodo> periodosAgregar=new ArrayList<>();
		
		for(i=firstYear;i<thisYear;i++){
			Periodo periodoTemp = new Periodo(i);
			periodosAgregar.add(periodoTemp);
		}
		
		empresas.forEach(unaEmpresa->{
			unaEmpresa.agregarPeriodos(periodosAgregar);
		});
		
		return empresas;
	}


	
	
	
	
	
}
