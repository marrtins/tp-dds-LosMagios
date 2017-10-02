package controllers;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.lang.Integer;
import entities.Cuenta;
import entities.Empresa;
import entities.Indicador;
import entities.Metodologia;
import entities.Periodo;
import entities.Usuario;
import entities.TiposCondicion.CondicionNoTaxativa;
import entities.TiposCondicion.CondicionTaxativa;
import model.CuentaModel;
import model.RepositorioDeEmpresas;
import model.UsuarioModel;
import persistence.DataCollector;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class VentanasController {
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView arranque(Request req, Response res){
//		UsuarioModel modelUsuario =UsuarioModel.getInstance();
//		model.put("usuarios", modelUsuario.getAll());
		model.clear();
		return new ModelAndView(model, "base.hbs");
	}


	public ModelAndView inicio(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
//		model.put("usuarios", modelUsuario.getAll());
		String pass=req.queryParams("pass");
		
		String nombreUsuario = req.queryParams("usuario");
				
		Usuario usuario = modelCuentas.getUsuario(nombreUsuario,pass);
		if(usuario.getNombre().equals("null")){
			return new ModelAndView(model,"logFail.hbs");

		}
		
		model.put("usuario",usuario.getNombre());
		return new ModelAndView(model,"inicio.hbs");
	}
	
	
	
	public ModelAndView inicioLog(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
//		
		
		String nombreUsuario = req.params(":nombreUsuario");

		model.put("usuario",nombreUsuario);
		return new ModelAndView(model,"inicio.hbs");
	}

	
	public ModelAndView cuentas(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		String empresaBuscada = req.queryParams("nombreEmpresa");
		ArrayList<Periodo> periodos = new ArrayList<>();		
				
		
		model.put("empresas",modelCuentas.getAll());
		model.put("periodos",periodos);
		return new ModelAndView(model,"cuentas.hbs");
	}
	public ModelAndView consultarCuenta(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		String nombreEmpresa = req.queryParams("empresaSeleccionada");
		
		Empresa empresaSeleccionada = modelCuentas.getEmpresa(nombreEmpresa);
		
		ArrayList<Cuenta>cuentasDeEmpresa=new ArrayList<>();
		cuentasDeEmpresa=modelCuentas.getCuentasDeEmpresa(empresaSeleccionada);
		model.put("empresa",empresaSeleccionada);
		model.put("cuentas",cuentasDeEmpresa);
		
		
		return new ModelAndView(model,"consultarCuenta.hbs");
	}
	
	public ModelAndView indicadores(Request req, Response res){
		return new ModelAndView(model,"indicadores.hbs");
	}
	public ModelAndView indicadorCreado(Request req, Response res){
		String nombreIndicador = req.queryParams("nombreI");
		String valorIndicador = req.queryParams("valorI");
		DataCollector persistence= new DataCollector();
		String nombreUsuario = req.params(":nombreUsuario");

		persistence.crearIndicador(nombreIndicador, valorIndicador,nombreUsuario);
		
		return new ModelAndView(model,"indicadorCreado.hbs");
	}
	
	public ModelAndView metodologiaCreada(Request req, Response res){
		
		String nombreMetodologia=req.queryParams("nombreMetodologia");
		
		String indicador1 = req.queryParams("indicador1");
		String condicion1 = req.queryParams("condicion1");
		
		ArrayList<CondicionTaxativa> taxativas=new ArrayList<>();
		ArrayList<CondicionNoTaxativa> noTaxativas=new ArrayList<>();
		
		
		if(!indicador1.equals("-1")){
			Double valor1 = Double.valueOf( req.queryParams("valor1"));
			CondicionTaxativa ct1 = new CondicionTaxativa(" ", condicion1, 3, indicador1, valor1);
			taxativas.add(ct1);
		}
		
		
		String indicador2 = req.queryParams("indicador2");
		String condicion2 = req.queryParams("condicion2");
		
		
		if(!indicador2.equals("-1")){
			Double valor2 = Double.valueOf( req.queryParams("valor2"));
			CondicionTaxativa ct2 = new CondicionTaxativa(" ", condicion2, 3, indicador2, valor2);taxativas.add(ct2);
		}
		
		String indicador3 = req.queryParams("indicador3");
		String condicion3 = req.queryParams("condicion3");
		
		
		if(!indicador3.equals("-1")){
			Double valor3 = Double.valueOf( req.queryParams("valor3"));
			CondicionTaxativa ct3 = new CondicionTaxativa(" ", condicion3, 3, indicador3, valor3);taxativas.add(ct3);
		}
		
		String indicador4 = req.queryParams("indicador4");
		String condicion4 = req.queryParams("condicion4");
		
		if(!indicador4.equals("-1")){
			CondicionNoTaxativa cnt1= new CondicionNoTaxativa(" ", condicion4, 3, 3, indicador4);noTaxativas.add(cnt1);
		}
		
		
		String indicador5 = req.queryParams("indicador5");
		String condicion5 = req.queryParams("condicion5");
		
		if(!indicador5.equals("-1")){
			CondicionNoTaxativa cnt2= new CondicionNoTaxativa(" ", condicion5, 3, 3, indicador5);noTaxativas.add(cnt2);
		}
		
		
		String indicador6 = req.queryParams("indicador6");
		String condicion6 = req.queryParams("condicion6");
		
		if(!indicador6.equals("-1")){
			CondicionNoTaxativa cnt3= new CondicionNoTaxativa(" ", condicion6, 3, 3, indicador6);noTaxativas.add(cnt3);
		}
		
		
		String nombreUsuario = req.params(":nombreUsuario");

		DataCollector persistence= new DataCollector();
		persistence.crearMetodologia(nombreMetodologia, taxativas, noTaxativas,nombreUsuario);
		
		
		return new ModelAndView(model,"metodologiaCreada.hbs");
	}
	
	public ModelAndView metodologias(Request req, Response res){
		
		return new ModelAndView(model,"metodologias.hbs");
	}
	
	public ModelAndView grafico(Request req, Response res){
		return new ModelAndView(model,"grafico.hbs");
	}
	
	public ModelAndView empresas(Request req, Response res){
		return new ModelAndView(model,"empresas.hbs");
		
	}
	
	public ModelAndView crearCuenta(Request req, Response res){
		return new ModelAndView(model,"crearCuenta.hbs");
		
	}
		
	public ModelAndView crearMetodologia(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		String nombreUsuario = req.params(":nombreUsuario");

		model.put("indicadores", modelCuentas.getAllIndicadores(nombreUsuario));

		
		return new ModelAndView(model,"crearMetodologia.hbs");
		
	}
	
	public ModelAndView aplicarMetodologia(Request req, Response res){
		
		CuentaModel modelCuentas=CuentaModel.getInstance();
		String nombreUsuario = req.params(":nombreUsuario");

		model.put("metodologias", modelCuentas.getAllMetodologias(nombreUsuario));
		
		
		return new ModelAndView(model,"aplicarMetodologia.hbs");
		
	}
	public ModelAndView aplicarIndicadores(Request req, Response res){
		
		CuentaModel modelCuentas=CuentaModel.getInstance();
		
		String nombreUsuario = req.params(":nombreUsuario");

		model.put("indicadores", modelCuentas.getAllIndicadores(nombreUsuario));
		model.put("empresas",modelCuentas.getAll());
		return new ModelAndView(model,"aplicarIndicadores.hbs");
		
	}
	
	public ModelAndView crearIndicador(Request req, Response res){
		return new ModelAndView(model,"crearIndicador.hbs");
		
	}
	public ModelAndView resultadoIndicador(Request req, Response res){
		
		CuentaModel modelCuentas=CuentaModel.getInstance();
		
		String indicadorSeleccionado = req.queryParams("indicadorSeleccionado");
		String empresaSeleccionada = req.queryParams("empresaSeleccionada");
		String periodoSeleccioando=req.queryParams("periodoSeleccionado");
		
		Empresa empresa = modelCuentas.getEmpresa(empresaSeleccionada);
		Indicador indicador=modelCuentas.getIndicador(indicadorSeleccionado);
		Periodo periodo=modelCuentas.getPeriodoDe(empresa,periodoSeleccioando);
		
		String resultado = String.valueOf(indicador.aplicarIndicadorA(empresa, periodo));
				
		model.put("empresa",empresa);
		model.put("indicador",indicador);
		model.put("periodo",periodoSeleccioando);
		model.put("resultado",resultado);

		return new ModelAndView(model,"resultadoIndicador.hbs");
		
	}
	
	public ModelAndView resultadoMetodologia(Request req, Response res){
		CuentaModel modelCuentas=CuentaModel.getInstance();
		
		String metodologiaSeleccionada = req.queryParams("metodologiaSeleccionada");
		Metodologia metodologia = modelCuentas.getMetodologia(metodologiaSeleccionada);
		LinkedList<Empresa> resultado=new LinkedList<>();
		
		
		
		
		resultado= metodologia.aplicarMetodologia(modelCuentas.getArrayEmpresas());
		
		model.put("resultado",resultado);
		model.put("metodologia",metodologiaSeleccionada);


		
		
		return new ModelAndView(model,"resultadoMetodologia.hbs");
	}
}