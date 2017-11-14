package server;


import controllers.CuentasController;
import controllers.IndicadorController;
import controllers.MetodologiasController;
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
	
	VentanasController ventanasController = new VentanasController();
	IndicadorController indicadorController = new IndicadorController();
	MetodologiasController metodologiaController = new MetodologiasController();
	CuentasController cuentasController = new CuentasController();

	
	Spark.get("/", ventanasController::arranque, engine);
	Spark.get("/inicioSesion", ventanasController::arranqueSesion, engine);
	
	Spark.post("/inicio", ventanasController::inicio,engine);
	Spark.post("/inicio/:nombreUsuario", ventanasController::inicioLog,engine);
	
	Spark.post("/inicio/:nombreUsuario/cuenta", ventanasController::cuentas,engine);
	Spark.post("/inicio/:nombreUsuario/cuenta/consultarCuenta", ventanasController::consultarCuenta, engine);
	
	
	Spark.post("/inicio/:nombreUsuario/indicador", ventanasController::indicadores,engine);
	Spark.post("/inicio/:nombreUsuario/indicador/indicadorCreado", ventanasController::indicadorCreado,engine);
	Spark.post("/inicio/:nombreUsuario/indicador/crearIndicador", ventanasController::crearIndicador,engine);
	Spark.post("/inicio/:nombreUsuario/indicador/resultadoIndicador", ventanasController::resultadoIndicador,engine);
	Spark.post("/inicio/:nombreUsuario/indicador/aplicarIndicadores", ventanasController::aplicarIndicadores,engine);


	
	Spark.post("/inicio/:nombreUsuario/metodologia", ventanasController::metodologias,engine);
	Spark.post("/inicio/:nombreUsuario/metodologia/crearMetodologia", ventanasController::crearMetodologia,engine);
	Spark.post("/inicio/:nombreUsuario/metodologia/aplicarMetodologia", ventanasController::aplicarMetodologia,engine);
	Spark.post("/inicio/:nombreUsuario/metodologia/metodologiaCreada", ventanasController::metodologiaCreada,engine);
	Spark.post("/inicio/:nombreUsuario/metodologia/resultadoMetodologia", ventanasController::resultadoMetodologia,engine);
	
}
}
