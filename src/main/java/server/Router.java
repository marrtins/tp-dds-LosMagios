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
	Spark.post("/inicio/cuenta", inicioController::cuentas,engine);
	Spark.post("/inicio/metodologia", inicioController::metodologias,engine);
	Spark.post("/inicio/indicador", inicioController::indicadores,engine);
	Spark.post("/inicio/grafico", inicioController::grafico,engine);
	Spark.post("/inicio/empresa", inicioController::empresas,engine);
>>>>>>> 8f32d99d7c9b90c3087362a3736cc85e02b2c719
}
}
