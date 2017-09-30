package controllers;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;
import entities.Cuenta;
import entities.Empresa;
import entities.Periodo;
import model.CuentaModel;
import model.RepositorioDeEmpresas;
import model.UsuarioModel;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class VentanasController {
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView arranque(Request req, Response res){
//		UsuarioModel modelUsuario =UsuarioModel.getInstance();
//		model.put("usuarios", modelUsuario.getAll());
		return new ModelAndView(model, "base.hbs");
	}


	public ModelAndView inicio(Request req, Response res){
//		UsuarioModel modelUsuario =UsuarioModel.getInstance();
//		model.put("usuarios", modelUsuario.getAll());
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
		return new ModelAndView(model,"crearMetodologia.hbs");
		
	}
	
	public ModelAndView aplicarMetodologia(Request req, Response res){
		return new ModelAndView(model,"aplicarMetodologia.hbs");
		
	}
	public ModelAndView aplicarIndicadores(Request req, Response res){
		return new ModelAndView(model,"aplicarIndicadores.hbs");
		
	}
	
	public ModelAndView crearIndicador(Request req, Response res){
		return new ModelAndView(model,"crearIndicador.hbs");
		
	}
	
}