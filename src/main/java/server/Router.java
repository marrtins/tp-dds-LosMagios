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
	
	Spark.staticFiles.location("/public");
	
	VentanasController inicioController = new VentanasController();
	
	Spark.get("/", inicioController::arranque, engine);
	Spark.get("/relog", inicioController::arranque, engine);
	
	Spark.post("/inicio", inicioController::inicio,engine);
	Spark.post("/inicio/:nombreUsuario", inicioController::inicioLog,engine);
	
	Spark.post("/inicio/cuenta/:nombreUsuario", inicioController::cuentas,engine);
	Spark.post("/inicio/cuenta/:nombreUsuario/consultarCuenta", inicioController::consultarCuenta, engine);
	
	
	Spark.post("/inicio/indicador/:nombreUsuario", inicioController::indicadores,engine);
	Spark.post("/inicio/indicador/:nombreUsuario/indicadorCreado", inicioController::indicadorCreado,engine);
	Spark.post("/inicio/indicador/:nombreUsuario/crearIndicador", inicioController::crearIndicador,engine);
	Spark.post("/inicio/indicador/:nombreUsuario/resultadoIndicador", inicioController::resultadoIndicador,engine);
	Spark.post("/inicio/indicador/:nombreUsuario/aplicarIndicadores", inicioController::aplicarIndicadores,engine);


	
	Spark.post("/inicio/metodologia/:nombreUsuario", inicioController::metodologias,engine);
	Spark.post("/inicio/metodologia/:nombreUsuario/crearMetodologia", inicioController::crearMetodologia,engine);
	Spark.post("/inicio/metodologia/:nombreUsuario/aplicarMetodologia", inicioController::aplicarMetodologia,engine);
	Spark.post("/inicio/metodologia/:nombreUsuario/metodologiaCreada", inicioController::metodologiaCreada,engine);
	Spark.post("/inicio/metodologia/:nombreUsuario/resultadoMetodologia", inicioController::resultadoMetodologia,engine);
	
}
}
