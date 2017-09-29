package controllers;

import java.util.HashMap;
import java.util.Map;

import model.RepositorioDeEmpresas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class VentanasController {
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView arranque(Request req, Response res){
		return new ModelAndView(model, "base.hbs");
	}


	public ModelAndView inicio(Request req, Response res){
		return new ModelAndView(model,"inicio.hbs");
	}
	
	public ModelAndView cuentas(Request req, Response res){
		return new ModelAndView(model,"cuentas.hbs");
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
}