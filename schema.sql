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
insert into empresa (idEmpresa, nombreEmpresa) values (1, 'LasRuinas');
insert into empresa (idEmpresa, nombreEmpresa) values (2, 'LosRobles');
insert into empresa (idEmpresa, nombreEmpresa) values (3, 'LosNostálgicos');
insert into empresa (idEmpresa, nombreEmpresa) values (4, 'Cloud');
insert into empresa (idEmpresa, nombreEmpresa) values (5, 'Ford');
insert into empresa (idEmpresa, nombreEmpresa) values (6, 'BHP');
insert into empresa (idEmpresa, nombreEmpresa) values (7, 'NestleSA');
insert into empresa (idEmpresa, nombreEmpresa) values (8, 'ChinaMobile');
insert into empresa (idEmpresa, nombreEmpresa) values (9, 'BerkshireHathaway');
insert into empresa (idEmpresa, nombreEmpresa) values (10, 'GeneralElectricCompany');
insert into empresa (idEmpresa, nombreEmpresa) values (11, 'WalMartStores');
insert into empresa (idEmpresa, nombreEmpresa) values (12, 'Google');
insert into empresa (idEmpresa, nombreEmpresa) values (13, 'ChevronCorporation');
insert into empresa (idEmpresa, nombreEmpresa) values (14, 'InternationalBusinessMachinesCorporation');
insert into empresa (idEmpresa, nombreEmpresa) values (15, 'Procter&GambleCo');
insert into empresa (idEmpresa, nombreEmpresa) values (16, 'HSBCHoldings');
insert into empresa (idEmpresa, nombreEmpresa) values (17, 'AT&T');
insert into empresa (idEmpresa, nombreEmpresa) values (18, 'RioTinto');
insert into empresa (idEmpresa, nombreEmpresa) values (19, 'BankOfChina');
insert into empresa (idEmpresa, nombreEmpresa) values (20, 'Citigroup');

-- PERIODOS
insert into periodo(anio) values(2017);
insert into periodo(anio) values(2016);
insert into periodo(anio) values(2015);
insert into periodo(anio) values(2014);

-- CUENTAS
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (1, 'AC', 3265682);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (2, 'AC', 4774158);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (3, 'AC', 3077335);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (4, 'AC', 3417452);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (5, 'AC', 1317562);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (6, 'PC', 7403864);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (7, 'PC', 7783453);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (8, 'PC', 8973744);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (9, 'PC', 2550692);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (10, 'PC', 7234060);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (11, 'P', 7579721);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (12, 'P', 1972764);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (13, 'P', 640616);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (14, 'P', 8399620);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (15, 'P', 420554);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (16, 'P', 638703);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (17, 'PN', 576169);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (18, 'PN', 5225506);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (19, 'PN', 5270267);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (20, 'PN', 8616904);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (21, 'PN', 6820002);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (22, 'PN', 203304);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (23, 'Caja', 5828812);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (24, 'Caja', 4838928);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (25, 'Caja', 8989639);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (26, 'Caja', 4544159);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (27, 'Caja', 8542615);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (28, 'Caja', 164381);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (29, 'Caja', 5574875);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (30, 'Caja', 3150037);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (31, 'Caja', 6717517);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (32, 'Caja', 589838);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (33, 'Caja', 2944155);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (34, 'Caja', 5808696);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (35, 'Capital', 4858992);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (36, 'Capital', 7679606);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (37, 'Capital', 4265562);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (38, 'Capital', 2085991);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (39, 'Capital', 5453409);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (40, 'Capital', 3063223);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (41, 'Capital', 4472861);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (42, 'Reservas', 7679606);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (43, 'Reservas', 506304);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (44, 'Reservas', 1812340);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (45, 'Reservas', 5560749);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (46, 'EBIT', 4033729);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (47, 'EBIT', 8442162);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (48, 'EBIT', 4911535);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (49, 'EBIT', 560137);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (50, 'EBIT', 1740805);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (51, 'EBIT', 8218780);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (52, 'EBIT', 5075888);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (53, 'EBIT', 8627881);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (54, 'EBIT', 4259941);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (55, 'EBIT', 2122003);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (56, 'EBIT', 7448294);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (57, 'Intereses', 4694222);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (58, 'Intereses', 4820035);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (59, 'Intereses', 8484657);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (60, 'Intereses', 3028061);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (61, 'Intereses', 8884005);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (62, 'Intereses', 717907);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (63, 'Intereses', 7737434);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (64, 'DocumentosACobrar', 2129448);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (65, 'DocumentosACobrar', 4538260);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (66, 'DocumentosACobrar', 1547371);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (67, 'DocumentosACobrar', 4673395);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (68, 'DocumentosACobrar', 5181443);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (69, 'DocumentosACobrar', 2383084);

/*
DATOS EXTRAS
*/
/*
insert into cuenta_periodo_empresa (idEmpresa, periodos_anio, cuenta_idCuenta) values (4, 2016, 1);
insert into cuenta_periodo_empresa (idEmpresa, periodos_anio, cuenta_idCuenta) values (8, 2016, 2);
insert into cuenta_periodo_empresa (idEmpresa, periodos_anio, cuenta_idCuenta) values (7, 2016, 3);
insert into cuenta_periodo_empresa (idEmpresa, periodos_anio, cuenta_idCuenta) values (5, 2016, 4);
*/

-- EMPRESA_PERIODO

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (1, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (1, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (1, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (1, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (2, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (2, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (2, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (2, 2017);


insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (3, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (3, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (3, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (3, 2017);


insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (4, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (4, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (4, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (4, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (5, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (5, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (5, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (5, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (6, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (6, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (6, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (6, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (7, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (7, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (7, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (7, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (8, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (8, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (8, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (8, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (9, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (9, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (9, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (9, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (10, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (10, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (10, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (10, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (11, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (11, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (11, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (11, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (12, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (12, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (12, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (12, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (13, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (13, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (13, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (13, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (14, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (14, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (14, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (14, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (15, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (15, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (15, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (15, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (16, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (16, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (16, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (16, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (17, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (17, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (17, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (17, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (18, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (18, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (18, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (18, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (19, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (19, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (19, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (19, 2017);

insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (20, 2014);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (20, 2015);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (20, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (20, 2017);

-- PERIODO_CUENTA
insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 1);
insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 2);
insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 3);
insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 4);
insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 5);

insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 6);
insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 7);
insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 8);
insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 9);
insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2016, 10);

insert into periodo_cuenta (Periodo_anio, cuentas_idCuenta) values (2015, 11);

