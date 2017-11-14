package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import analizadorIndicadores.AnalizadorSintactico;
import entities.Empresa;
import entities.Indicador;
import entities.Periodo;
import model.CuentaModel;
import model.UsuarioModel;
import persistence.DataCollector;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadorController {

	private Map<String, Object> model=new HashMap<>();
	UsuarioModel modelUsuario =UsuarioModel.getInstance();

	

}
