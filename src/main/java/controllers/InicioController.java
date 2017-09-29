package controllers;

import java.util.HashMap;
import java.util.Map;

import model.RepositorioDeEmpresas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class InicioController {
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView arranque(Request req, Response res){
		return new ModelAndView(model, "base.hbs");
	}


	public ModelAndView inicio(Request req, Response res){
		return new ModelAndView(model,"inicio.hbs");
	}
}