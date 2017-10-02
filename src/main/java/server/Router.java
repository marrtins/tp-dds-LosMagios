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
	Spark.post("/inicio/cuenta", inicioController::cuentas,engine);
	Spark.post("/inicio/cuenta/consultarCuenta", inicioController::consultarCuenta, engine);
	Spark.post("/inicio/metodologia", inicioController::metodologias,engine);
	Spark.post("/inicio/indicador", inicioController::indicadores,engine);
	Spark.post("/inicio/grafico", inicioController::grafico,engine);
	Spark.post("/inicio/empresa", inicioController::empresas,engine);

	Spark.post("/inicio/indicador/indicadorCreado", inicioController::indicadorCreado,engine);
	Spark.post("/inicio/cuenta/consultarCuenta", inicioController::consultarCuenta,engine);
	Spark.post("/inicio/cuenta/crearMetodologia", inicioController::crearMetodologia,engine);
	Spark.post("/inicio/cuenta/aplicarMetodologia", inicioController::aplicarMetodologia,engine);
	Spark.post("/inicio/metodologia/metodologiaCreada", inicioController::metodologiaCreada,engine);
	Spark.post("/inicio/metodologia/resultadoMetodologia", inicioController::resultadoMetodologia,engine);
	Spark.post("/inicio/cuenta/crearIndicador", inicioController::crearIndicador,engine);
	Spark.post("/inicio/indicador/resultadoIndicador", inicioController::resultadoIndicador,engine);
	Spark.post("/inicio/cuenta/aplicarIndicadores", inicioController::aplicarIndicadores,engine);

}
}
