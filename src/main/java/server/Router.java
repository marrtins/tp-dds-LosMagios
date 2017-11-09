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
	
	Spark.post("/inicio/:nombreUsuario/cuenta", inicioController::cuentas,engine);
	Spark.post("/inicio/:nombreUsuario/cuenta/consultarCuenta", inicioController::consultarCuenta, engine);
	
	
	Spark.post("/inicio/:nombreUsuario/indicador", inicioController::indicadores,engine);
	Spark.post("/inicio/:nombreUsuario/indicador/indicadorCreado", inicioController::indicadorCreado,engine);
	Spark.post("/inicio/:nombreUsuario/indicador/crearIndicador", inicioController::crearIndicador,engine);
	Spark.post("/inicio/:nombreUsuario/indicador/resultadoIndicador", inicioController::resultadoIndicador,engine);
	Spark.post("/inicio/:nombreUsuario/indicador/aplicarIndicadores", inicioController::aplicarIndicadores,engine);


	
	Spark.post("/inicio/:nombreUsuario/metodologia", inicioController::metodologias,engine);
	Spark.post("/inicio/:nombreUsuario/metodologia/crearMetodologia", inicioController::crearMetodologia,engine);
	Spark.post("/inicio/:nombreUsuario/metodologia/aplicarMetodologia", inicioController::aplicarMetodologia,engine);
	Spark.post("/inicio/:nombreUsuario/metodologia/metodologiaCreada", inicioController::metodologiaCreada,engine);
	Spark.post("/inicio/:nombreUsuario/metodologia/resultadoMetodologia", inicioController::resultadoMetodologia,engine);
	
}
}
