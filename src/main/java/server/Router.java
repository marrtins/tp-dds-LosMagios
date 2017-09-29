package server;


import controllers.InicioController;
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
	
	
	InicioController inicioController = new InicioController();
	
	Spark.get("/", inicioController::arranque, engine);
	Spark.post("/inicio", inicioController::inicio,engine);
}
}
