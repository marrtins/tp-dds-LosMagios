package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import analizadorIndicadores.AnalizadorSintactico;
import entities.Cuenta;
import entities.Empresa;
import entities.Indicador;
import entities.Metodologia;
import entities.Periodo;
import entities.Usuario;
import entities.TiposCondicion.CondicionNoTaxativa;
import entities.TiposCondicion.CondicionTaxativa;
import model.CuentaModel;
import model.UsuarioModel;
import persistence.DataCollector;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class VentanasController {
	private Map<String, Object> model=new HashMap<>();
	UsuarioModel modelUsuario =UsuarioModel.getInstance();
	
	public ModelAndView arranque(Request req, Response res){
		model.put("usuarios", modelUsuario.getAll());
		model.clear();
		return new ModelAndView(model, "base.hbs");
	}
	
	public ModelAndView arranqueSesion(Request req, Response res){
		model.put("usuarios", modelUsuario.getAll());
		model.clear();
		return new ModelAndView(model, "inicioSesion.hbs");
	}


	public ModelAndView inicio(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		model.put("usuarios", modelUsuario.getAll());
		String pass=req.queryParams("pass");
		
		String nombreUsuario = req.queryParams("usuario");
				
		Usuario usuario = modelCuentas.getUsuario(nombreUsuario,pass);
		if(usuario.getNombre().equals("null")){
			
			return new ModelAndView(model,"logFail.hbs");

		}
		
		model.put("usuario", nombreUsuario);
		return new ModelAndView(model,"inicio.hbs");
	}
	
	
	
	public ModelAndView inicioLog(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		String nombreUsuario = req.params(":nombreUsuario");

		model.put("usuario",nombreUsuario);
		return new ModelAndView(model,"inicioUsuario.hbs");
	}
	
	
	
	public ModelAndView indicadores(Request req, Response res){
		return new ModelAndView(model,"indicadores.hbs");
	}
	public ModelAndView indicadorCreado(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		String nombreUsuario = req.params(":nombreUsuario");

		AnalizadorSintactico sintax = new AnalizadorSintactico();
		String nombreIndicador = req.queryParams("nombreI");
		String valorIndicador = req.queryParams("valorI");
		if(nombreIndicador.equals("") || valorIndicador.equals("")) {
			model.put("usuario", nombreUsuario);
			return new ModelAndView(model,"indicadorNoCreado.hbs");

		}
		DataCollector persistence= new DataCollector();
		String formulaI = sintax.parseInput(valorIndicador);
		
		 modelCuentas.getAllIndicadores(nombreUsuario);
		
		
		if(!persistence.crearIndicador(nombreIndicador, formulaI,nombreUsuario)) {
			model.put("usuario", nombreUsuario);
			return new ModelAndView(model,"indicadorNoCreado.hbs");
		}
		
		return new ModelAndView(model,"indicadorCreado.hbs");
	}
	
	public ModelAndView aplicarIndicadores(Request req, Response res){

		CuentaModel modelCuentas=CuentaModel.getInstance();
		

		String nombreUsuario = req.params(":nombreUsuario");
		model.put("usuario", nombreUsuario);
		model.put("indicadores", modelCuentas.getAllIndicadores(nombreUsuario));
		model.put("empresas",modelCuentas.getAll());
		return new ModelAndView(model,"aplicarIndicadores.hbs");

	}

	public ModelAndView crearIndicador(Request req, Response res){
		String nombreUsuario = req.params(":nombreUsuario");
		model.put("usuario", nombreUsuario);
		return new ModelAndView(model,"crearIndicador.hbs");

	}
	public ModelAndView resultadoIndicador(Request req, Response res) throws IOException{

		CuentaModel modelCuentas=CuentaModel.getInstance();

		String indicadorSeleccionado = req.queryParams("indicadorSeleccionado");
		String empresaSeleccionada = req.queryParams("empresaSeleccionada");
		String periodoSeleccioando=req.queryParams("periodoSeleccionado");
		String nombreUsuario = req.params(":nombreUsuario");
		model.put("usuario", nombreUsuario);

		if(indicadorSeleccionado.equals("-1") || empresaSeleccionada.equals("-1") || periodoSeleccioando.equals("-1")) {
			model.put("usuario", nombreUsuario);
			return new ModelAndView(modelCuentas, "resultadoIndicadorFail.hbs");
		}
		
		Empresa empresa = modelCuentas.getEmpresa(empresaSeleccionada);
		Indicador indicador=modelCuentas.getIndicador(indicadorSeleccionado);
		Periodo periodo=modelCuentas.getPeriodoDe(empresa,periodoSeleccioando);

		String resultado = String.valueOf(indicador.aplicarIndicadorA(empresa, periodo));
		if(resultado.equals("-999.9")) {
			model.put("usuario", nombreUsuario);
			return new ModelAndView(model,"resultadoIndicadorNoAplica.hbs");
		}
		

		model.put("empresa",empresa);
		model.put("indicador",indicador);
		model.put("periodo",periodoSeleccioando);
		model.put("resultado",resultado);

		return new ModelAndView(model,"resultadoIndicador.hbs");

	}
	
	
	public ModelAndView metodologias(Request req, Response res){
		String nombreUsuario = req.params(":nombreUsuario");
		model.put("usuario", nombreUsuario);
		return new ModelAndView(model,"metodologias.hbs");
	}


	public ModelAndView crearMetodologia(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		String nombreUsuario = req.params(":nombreUsuario");
		
		model.put("indicadores", modelCuentas.getAllIndicadores(nombreUsuario));
		model.put("usuario", nombreUsuario);

		return new ModelAndView(model,"crearMetodologia.hbs");

	}

	public ModelAndView aplicarMetodologia(Request req, Response res){

		CuentaModel modelCuentas=CuentaModel.getInstance();
		String nombreUsuario = req.params(":nombreUsuario");

		model.put("metodologias", modelCuentas.getAllMetodologias(nombreUsuario));
		model.put("usuario", nombreUsuario);

		return new ModelAndView(model,"aplicarMetodologia.hbs");

	}


	public ModelAndView resultadoMetodologia(Request req, Response res) throws IOException{
		CuentaModel modelCuentas=CuentaModel.getInstance();

		String metodologiaSeleccionada = req.queryParams("metodologiaSeleccionada");
		String periodoSeleccionado=req.queryParams("periodoSeleccionado");
		String nombreUsuario = req.params(":nombreUsuario");
		model.put("usuario", nombreUsuario);
		if(metodologiaSeleccionada.equals("-1") || periodoSeleccionado.equals("-1")) {
			model.put("usuario", nombreUsuario);
			return new ModelAndView(model,"aplicarMetodologiaFail.hbs");
		}
		Metodologia metodologia = modelCuentas.getMetodologia(metodologiaSeleccionada);
		List<Empresa> resultado=new LinkedList<>();




		resultado= metodologia.aplicarMetodologia(modelCuentas.getArrayEmpresas(),periodoSeleccionado);

		if(resultado.isEmpty()) {
			model.put("usuario", nombreUsuario);
			return new ModelAndView(model,"resultadoMetodologiaVacio.hbs");
		}

		model.put("resultado",resultado);
		model.put("metodologia",metodologiaSeleccionada);




		return new ModelAndView(model,"resultadoMetodologia.hbs");
	}



	public ModelAndView metodologiaCreada(Request req, Response res){

		String nombreMetodologia=req.queryParams("nombreMetodologia");
		String nombreUsuario = req.params(":nombreUsuario");
		model.put("usuario", nombreUsuario);
		if(nombreMetodologia.equals("")) {
			model.put("usuario", nombreUsuario);
			return new ModelAndView(model,"metodologiaNoCreada.hbs");
		}
		String indicador1 = req.queryParams("indicador1").toUpperCase();
		String condicion1 = req.queryParams("condicion1");

		ArrayList<CondicionTaxativa> taxativas=new ArrayList<>();
		ArrayList<CondicionNoTaxativa> noTaxativas=new ArrayList<>();


		if(!indicador1.equals("")){
			Double valor1 = Double.valueOf( req.queryParams("valor1"));
			CondicionTaxativa ct1 = new CondicionTaxativa(/*" ", condicion1, 3, indicador1, valor1*/);
			inicializarCondicionTaxativa(ct1, " ", condicion1, 3, indicador1, valor1);
			taxativas.add(ct1);
		}


		String indicador2 = req.queryParams("indicador2").toUpperCase();
		String condicion2 = req.queryParams("condicion2");


		if(!indicador2.equals("")){
			Double valor2 = Double.valueOf( req.queryParams("valor2"));
			CondicionTaxativa ct2 = new CondicionTaxativa(/*" ", condicion2, 3, indicador2, valor2*/);
			inicializarCondicionTaxativa(ct2, " ", condicion2, 3, indicador2, valor2);
			taxativas.add(ct2);
		}

		String indicador3 = req.queryParams("indicador3").toUpperCase();
		String condicion3 = req.queryParams("condicion3");


		if(!indicador3.equals("")){
			Double valor3 = Double.valueOf( req.queryParams("valor3"));
			CondicionTaxativa ct3 = new CondicionTaxativa(/*" ", condicion3, 3, indicador3, valor3*/);
			inicializarCondicionTaxativa(ct3, " ", condicion3, 3, indicador3, valor3);
			taxativas.add(ct3);
		}

		String indicador4 = req.queryParams("indicador4").toUpperCase();
		String condicion4 = req.queryParams("condicion4");

		if(!indicador4.equals("")){
			CondicionNoTaxativa cnt1= new CondicionNoTaxativa(/*" ", condicion4, 3, 3, indicador4*/);
			inicializarCondicionNoTaxativa(cnt1, " ", condicion4, 3, 3, indicador4);
			noTaxativas.add(cnt1);
		}


		String indicador5 = req.queryParams("indicador5").toUpperCase();
		String condicion5 = req.queryParams("condicion5");

		if(!indicador5.equals("")){
			CondicionNoTaxativa cnt2= new CondicionNoTaxativa(/*" ", condicion5, 3, 3, indicador5*/);
			inicializarCondicionNoTaxativa(cnt2, " ", condicion5, 3, 3, indicador5);
			noTaxativas.add(cnt2);
		}


		String indicador6 = req.queryParams("indicador6").toUpperCase();
		String condicion6 = req.queryParams("condicion6");

		if(!indicador6.equals("")){
			CondicionNoTaxativa cnt3= new CondicionNoTaxativa(/*" ", condicion6, 3, 3, indicador6*/);
			inicializarCondicionNoTaxativa(cnt3, " ", condicion6, 3, 3, indicador6);
			noTaxativas.add(cnt3);
		}



		DataCollector persistence= new DataCollector();
		persistence.crearMetodologia(nombreMetodologia, taxativas, noTaxativas,nombreUsuario);


		return new ModelAndView(model,"metodologiaCreada.hbs");
	}
	
	private void inicializarCondicionTaxativa(CondicionTaxativa ct, String nombreCondicion, String operadorString, int anios, String indicadorString,
			Double valorComparacion){
		ct.setNombreCondicion(nombreCondicion);
		ct.setOperadorString(operadorString);
		ct.setAnios(anios);
		ct.setIndicadorString(indicadorString);
		ct.setValorComparacion(valorComparacion);
	}

	private void inicializarCondicionNoTaxativa(CondicionNoTaxativa cnt, String nombreCondicion, String operadorString, int anios, int peso,String indicadorString){
		cnt.setNombreCondicion(nombreCondicion);
		cnt.setOperadorString(operadorString);
		cnt.setAnios(anios);
		cnt.setPeso(peso);
		cnt.setIndicadorString(indicadorString);
	}
	
	
	public ModelAndView cuentas(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		String nombreUsuario = req.params(":nombreUsuario");
		model.put("usuario", nombreUsuario);
		ArrayList<Periodo> periodos = new ArrayList<>();		


		model.put("empresas",modelCuentas.getAll());
		model.put("periodos",periodos);
		return new ModelAndView(model,"cuentas.hbs");
	}
	public ModelAndView consultarCuenta(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		String nombreEmpresa = req.queryParams("empresaSeleccionada");
		String nombreUsuario = req.params(":nombreUsuario");
		model.put("usuario", nombreUsuario);
		if(nombreEmpresa.equals("-1")) {
			model.put("usuario", nombreUsuario);
			return new ModelAndView(model,"consultarCuentaFail.hbs");
		}
		Empresa empresaSeleccionada = modelCuentas.getEmpresa(nombreEmpresa);

		ArrayList<Cuenta>cuentasDeEmpresa=new ArrayList<>();
		cuentasDeEmpresa=modelCuentas.getCuentasDeEmpresa(empresaSeleccionada);
		
		model.put("empresa",empresaSeleccionada);
		model.put("cuentas",cuentasDeEmpresa);


		return new ModelAndView(model,"consultarCuenta.hbs");
	}


	

	
}