create schema dondeinvierto -- para crear la bd. NECESARIO PARA QUE ARRANQUE EL PROGRAMA POR PRIMERA VEZ Y CREE LAS TABLAS

/*
 *AUXILIARES
*/
drop schema dondeinvierto -- Para borrar la bd

use dondeinvierto -- Para seleccionar la bd (en caso de querer hacer consultas).

/*
* INSERTAR DATOS
*/

-- USUARIOS
insert into usuario (nombreUsuario, pass) values ('grupo3', 'admin');
insert into usuario (nombreUsuario, pass) values ('Paula', 'admin1');
insert into usuario (nombreUsuario, pass) values ('Eze', 'admin2');
insert into usuario (nombreUsuario, pass) values ('Miguel', 'admin3');
insert into usuario (nombreUsuario, pass) values ('David', 'admin4');

-- EMPRESAS
insert into empresa (idEmpresa, nombreEmpresa) values (1, 'Las ruinas');
insert into empresa (idEmpresa, nombreEmpresa) values (2, 'Los robles');
insert into empresa (idEmpresa, nombreEmpresa) values (3, 'Los nostálgicos');
insert into empresa (idEmpresa, nombreEmpresa) values (4, 'Cloud');
insert into empresa (idEmpresa, nombreEmpresa) values (5, 'Ford');
insert into empresa (idEmpresa, nombreEmpresa) values (6, 'BHP');
insert into empresa (idEmpresa, nombreEmpresa) values (7, 'Nestle S.A.');
insert into empresa (idEmpresa, nombreEmpresa) values (8, 'China Mobile');
insert into empresa (idEmpresa, nombreEmpresa) values (9, 'Berkshire Hathaway');
insert into empresa (idEmpresa, nombreEmpresa) values (10, 'General Electric Company');
insert into empresa (idEmpresa, nombreEmpresa) values (11, 'Wal-Mart Stores');
insert into empresa (idEmpresa, nombreEmpresa) values (12, 'Google');
insert into empresa (idEmpresa, nombreEmpresa) values (13, 'Chevron Corporation');
insert into empresa (idEmpresa, nombreEmpresa) values (14, 'International Business Machines Corporation');
insert into empresa (idEmpresa, nombreEmpresa) values (15, 'Procter & Gamble Co');
insert into empresa (idEmpresa, nombreEmpresa) values (16, 'HSBC Holdings');
insert into empresa (idEmpresa, nombreEmpresa) values (17, 'AT&T');
insert into empresa (idEmpresa, nombreEmpresa) values (18, 'Rio Tinto');
insert into empresa (idEmpresa, nombreEmpresa) values (19, 'Bank of China');
insert into empresa (idEmpresa, nombreEmpresa) values (20, 'Citigroup');

-- PERIODOS
insert into periodo(anio) values(2017);
insert into periodo(anio) values(2016);
insert into periodo(anio) values(2015);
insert into periodo(anio) values(2014);

-- CUENTAS
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (1, 'AC', 3265682, 4, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (2, 'AC', 4774158, 8, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (3, 'AC', 3077335, 7, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (4, 'AC', 3417452, 5, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (5, 'AC', 1317562, 12, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (6, 'PC', 7403864, 4, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (7, 'PC', 7783453, 8, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (8, 'PC', 8973744, 7, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (9, 'PC', 2550692, 5, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (10, 'PC', 7234060, 12, 2016);

-- EMPRESA_PERIODO
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (4, 2016)