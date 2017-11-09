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

insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (11, 'P', 7579721, 5, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (12, 'P', 1972764, 12, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (13, 'P', 640616, 8, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (14, 'P', 8399620, 15, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (15, 'P', 420554, 16, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (16, 'P', 638703, 17, 2015);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (17, 'PN', 576169, 5, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (18, 'PN', 5225506, 12, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (19, 'PN', 5270267, 8, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (20, 'PN', 8616904, 15, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (21, 'PN', 6820002, 16, 2015);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (22, 'PN', 203304, 17, 2015);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (23, 'Caja', 5828812, 8, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (24, 'Caja', 4838928, 9, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (25, 'Caja', 8989639, 10, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (26, 'Caja', 4544159, 11, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (27, 'Caja', 8542615, 12, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (28, 'Caja', 164381, 13, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (29, 'Caja', 5574875, 2, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (30, 'Caja', 3150037, 15, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (31, 'Caja', 6717517, 16, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (32, 'Caja', 589838, 17, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (33, 'Caja', 2944155, 18, 2014);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (34, 'Caja', 5808696, 19, 2014);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (35, 'Capital', 4858992, 1, 2017);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (36, 'Capital', 7679606, 2, 2017);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (37, 'Capital', 4265562, 3, 2017);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (38, 'Capital', 2085991, 4, 2017);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (39, 'Capital', 5453409, 5, 2017);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (40, 'Capital', 3063223, 6, 2017);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (41, 'Capital', 4472861, 7, 2017);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (42, 'Reservas', 7679606, 2, 2017);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (43, 'Reservas', 506304, 3, 2017);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (44, 'Reservas', 1812340, 4, 2017);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (45, 'Reservas', 5560749, 5, 2017);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (46, 'EBIT', 4033729, 1, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (47, 'EBIT', 8442162, 2, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (48, 'EBIT', 4911535, 3, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (49, 'EBIT', 560137, 4, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (50, 'EBIT', 1740805, 5, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (51, 'EBIT', 8218780, 6, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (52, 'EBIT', 5075888, 7, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (53, 'EBIT', 8627881, 8, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (54, 'EBIT', 4259941, 9, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (55, 'EBIT', 2122003, 10, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (56, 'EBIT', 7448294, 11, 2016);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (57, 'Intereses', 4694222, 1, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (58, 'Intereses', 4820035, 2, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (59, 'Intereses', 8484657, 10, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (60, 'Intereses', 3028061, 8, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (61, 'Intereses', 8884005, 5, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (62, 'Intereses', 717907, 6, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (63, 'Intereses', 7737434, 7, 2016);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (64, 'DocumentosACobrar', 2129448, 15, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (65, 'DocumentosACobrar', 4538260, 16, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (66, 'DocumentosACobrar', 1547371, 17, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (67, 'DocumentosACobrar', 4673395, 18, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (68, 'DocumentosACobrar', 5181443, 8, 2016);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta, empresa_idEmpresa, periodo_anio) values (69, 'DocumentosACobrar', 2383084, 7, 2016);

/*
DATOS EXTRAS
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
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (7, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (5, 2016);
insert into empresa_periodo (Empresa_idEmpresa, periodos_anio) values (12, 2016)
