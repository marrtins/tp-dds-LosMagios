package server;


import controllers.VentanasController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
	public static void configure(){
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();
	
	
	VentanasController inicioController = new VentanasController();
	
	Spark.get("/", inicioController::arranque, engine);
	Spark.post("/inicio", inicioController::inicio,engine);
<<<<<<< HEAD

=======
>>>>>>> e2318fd03e8f44964a12e1cfde268fb78c1d2ec0
	Spark.post("/inicio/cuenta", inicioController::cuentas,engine);
	Spark.post("/inicio/cuenta/consultarCuenta", inicioController::consultarCuenta, engine);
	Spark.post("/inicio/metodologia", inicioController::metodologias,engine);
	Spark.post("/inicio/indicador", inicioController::indicadores,engine);
	Spark.post("/inicio/grafico", inicioController::grafico,engine);
	Spark.post("/inicio/empresa", inicioController::empresas,engine);
<<<<<<< HEAD
=======
	Spark.post("/inicio/cuenta/crearCuenta", inicioController::crearCuenta,engine);
	Spark.post("/inicio/cuenta/consultarCuenta", inicioController::consultarCuenta,engine);
	Spark.post("/inicio/cuenta/crearMetodologia", inicioController::crearMetodologia,engine);
	Spark.post("/inicio/cuenta/aplicarMetodologia", inicioController::aplicarMetodologia,engine);
	Spark.post("/inicio/cuenta/crearIndicador", inicioController::crearIndicador,engine);
	Spark.post("/inicio/cuenta/aplicarIndicadores", inicioController::aplicarIndicadores,engine);
>>>>>>> e2318fd03e8f44964a12e1cfde268fb78c1d2ec0
}
}
