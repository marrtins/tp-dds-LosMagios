create schema dondeinvierto -- para crear la bd. NECESARIO PARA QUE ARRANQUE EL PROGRAMA POR PRIMERA VEZ Y CREE LAS TABLAS

select * from metodologia
select * from indicador
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

insert into periodo(anio,id) values(2017,1); -- 2017 para empresa1
insert into periodo(anio,id) values(2016,2);	-- 2016 para empresa 1
insert into periodo(anio,id) values(2015,3); -- 2015 para empresa 1
insert into periodo(anio,id) values(2014,4); -- 2014 ára empresa 1

insert into periodo(anio,id) values(2017,5); -- 2017 para empresa2
insert into periodo(anio,id) values(2016,6); -- 2016 para empresa2
insert into periodo(anio,id) values(2015,7); -- 2015 para empresa2
insert into periodo(anio,id) values(2014,8); -- 2014 para empresa2

insert into periodo(anio,id) values(2017,9); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,10); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,11); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,12); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,13); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,14); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,15); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,16); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,17); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,18); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,19); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,20); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,21); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,22); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,23); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,24); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,25); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,26); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,27); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,28); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,29); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,30); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,31); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,32); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,33); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,34); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,35); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,36); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,37); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,38); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,39); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,40); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,41); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,42); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,43); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,44); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,45); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,46); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,47); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,48); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,49); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,50); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,51); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,52); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,53); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,54); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,55); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,56); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,57); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,58); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,59); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,60); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,61); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,62); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,63); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,64); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,65); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,66); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,67); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,68); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,69); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,70); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,71); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,72); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,73); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,74); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,75); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,76); -- 2014 para empresa3

insert into periodo(anio,id) values(2017,77); -- 2017 para empresa3
insert into periodo(anio,id) values(2016,78); -- 2016 para empresa3
insert into periodo(anio,id) values(2015,79); -- 2015 para empresa3
insert into periodo(anio,id) values(2014,80); -- 2014 para empresa3

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

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (23, 'CAJA', 5828812);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (24, 'CAJA', 4838928);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (25, 'CAJA', 8989639);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (26, 'CAJA', 4544159);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (27, 'CAJA', 8542615);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (28, 'CAJA', 164381);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (29, 'CAJA', 5574875);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (30, 'CAJA', 3150037);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (31, 'CAJA', 6717517);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (32, 'CAJA', 589838);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (33, 'CAJA', 2944155);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (34, 'CAJA', 5808696);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (35, 'CAPITAL', 4858992);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (36, 'CAPITAL', 7679606);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (37, 'CAPITAL', 4265562);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (38, 'CAPITAL', 2085991);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (39, 'CAPITAL', 5453409);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (40, 'CAPITAL', 3063223);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (41, 'CAPITAL', 4472861);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (42, 'RESERVAS', 7679606);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (43, 'RESERVAS', 506304);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (44, 'RESERVAS', 1812340);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (45, 'RESERVAS', 5560749);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (75, 'RESERVAS', 4412444);


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

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (57, 'INTERESES', 4694222);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (58, 'INTERESES', 4820035);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (59, 'INTERESES', 8484657);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (60, 'INTERESES', 3028061);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (61, 'INTERESES', 8884005);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (62, 'INTERESES', 717907);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (63, 'INTERESES', 7737434);

insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (64, 'DOCUMENTOSACOBRAR', 2129448);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (65, 'DOCUMENTOSACOBRAR', 4538260);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (66, 'DOCUMENTOSACOBRAR', 1547371);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (67, 'DOCUMENTOSACOBRAR', 4673395);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (68, 'DOCUMENTOSACOBRAR', 5181443);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (69, 'DOCUMENTOSACOBRAR', 2383084);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (90, 'DOCUMENTOSACOBRAR', 0);
insert into cuenta (idCuenta, nombreCuenta, valorCuenta) values (91, 'DOCUMENTOSACOBRAR', 0);



/*
DATOS EXTRAS
*/

-- EMPRESA_PERIODO

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (1, 1); -- 2017 p empresa 1
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (1, 2); -- 2016 p empresa 1
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (1, 3); -- 2015 p empresa 1
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (1, 4); -- 2014 p empresa 1


insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (2, 5); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (2, 6); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (2, 7); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (2, 8); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (3, 9); -- 2017 p empresa 3
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (3, 10); -- 2016 p empresa 3
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (3, 11); -- 2015 p empresa 3
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (3, 12); -- 2014 p empresa 3

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (4, 13); -- 2017 p empresa 4
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (4, 14); -- 2016 p empresa 4
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (4, 15); -- 2015 p empresa 4
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (4, 16); -- 2014 p empresa 4

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (5, 17); -- 2017 p empresa 5
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (5, 18); -- 2016 p empresa 5
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (5, 19); -- 2015 p empresa 5
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (5, 20); -- 2014 p empresa 5

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (6, 21); -- 2017 p empresa 6
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (6, 22); -- 2016 p empresa 6
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (6, 23); -- 2015 p empresa 6
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (6, 24); -- 2014 p empresa 6

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (7, 25); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (7, 26); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (7, 27); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (7, 28); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (8, 29); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (8, 30); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (8, 31); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (8, 32); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (9, 33); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (9, 34); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (9, 35); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (9, 36); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (10, 37); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (10, 38); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (10, 39); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (10, 40); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (11, 41); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (11, 42); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (11, 43); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (11, 44); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (12, 45); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (12, 46); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (12, 47); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (12, 48); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (13, 49); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (13, 50); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (13, 51); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (13, 52); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (14, 53); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (14, 54); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (14, 55); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (14, 56); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (15, 57); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (15, 58); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (15, 59); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (15, 60); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (16, 61); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (16, 62); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (16, 63); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (16, 64); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (17, 65); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (17, 66); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (17, 67); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (17, 68); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (18, 69); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (18, 70); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (18, 71); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (18, 72); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (19, 73); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (19, 74); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (19, 75); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (19, 76); -- 2014 p empresa 2

insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (20, 77); -- 2017 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (20, 78); -- 2016 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (20, 79); -- 2015 p empresa 2
insert into empresa_periodo (Empresa_idEmpresa, periodos_id) values (20, 80); -- 2014 p empresa 2

-- PERIODO_CUENTA

insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (14, 1);
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (30, 2); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (26, 3);
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (18, 4); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (46, 5); 

insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (14, 6);
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (30, 7); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (26, 8); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (18, 9); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (46, 10); 

insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (19, 11); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (47, 12); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (31, 13); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (59, 14); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (63, 15); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (67, 16); 

insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (19, 17); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (47, 18); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (31, 19); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (59, 20); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (63, 21); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (67, 22); 

insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (32, 23); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (36, 24); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (40, 25); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (44, 26); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (48, 27); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (52, 28); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (8, 29); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (60, 30); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (64, 31); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (68, 32); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (72, 33); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (76, 34);

insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (1, 35); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (5, 36); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (9, 37); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (13, 38); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (17, 39); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (21, 40); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (25, 41);
 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (5, 42); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (9, 43); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (13, 44); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (17, 45);
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (25, 75);

insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (2, 46); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (6, 47); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (10, 48); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (14, 49); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (18, 50); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (22, 51); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (26, 52);
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (30, 53); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (34, 54); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (38, 55); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (42, 56); 

insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (2, 57); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (6, 58); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (38, 59);
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (30, 60); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (18, 61); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (22, 62); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (26, 63); 

insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (58, 64); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (62, 65);
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (66, 66); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (70, 67); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (30, 68); 
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (26, 69);
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (18, 90);
insert into periodo_cuenta (Periodo_id, cuentas_idCuenta) values (38, 91);

-- INDICADORES
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (1, '{AC}/{PC}', 'LIQUIDEZCORRIENTE', 'grupo3');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (2, '{AC}-{PC}', 'CAPITALDETRABAJO', 'grupo3');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (3, '{P}/{PN}', 'ENDEUDAMIENTO', 'grupo3');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (4, '{EBIT}/{VENTAS}', 'RENTABILIDADOPERATIVA', 'grupo3');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (5, '{EBIT}/{INTERESES}', 'COBERTURADEINTERESES', 'grupo3');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (6, '{OCF}-{TDS}', 'COBERTURADEDEUDA', 'grupo3');

insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (7, '{AC}/{PC}', 'LIQUIDEZCORRIENTE', 'Paula');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (8, '{AC}-{PC}', 'CAPITALDETRABAJO', 'Paula');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (9, '{P}/{PN}', 'ENDEUDAMIENTO', 'Paula');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (10, '{EBIT}/{VENTAS}', 'RENTABILIDADOPERATIVA', 'Paula');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (11, '{EBIT}/{INTERESES}', 'COBERTURADEINTERESES', 'Paula');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (12, '{OCF}-{TDS}', 'COBERTURADEDEUDA', 'Paula');

insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (13, '{AC}/{PC}', 'LIQUIDEZCORRIENTE', 'Eze');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (14, '{AC}-{PC}', 'CAPITALDETRABAJO', 'Eze');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (15, '{P}/{PN}', 'ENDEUDAMIENTO', 'Eze');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (16, '{EBIT}/{VENTAS}', 'RENTABILIDADOPERATIVA', 'Eze');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (17, '{EBIT}/{INTERESES}', 'COBERTURADEINTERESES', 'Eze');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (18, '{OCF}-{TDS}', 'COBERTURADEDEUDA', 'Eze');
-- insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (31, '{CAJA}', 'CAJA', 'Eze');
-- insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (32, '{RESERV}', 'RESERVAS', 'Eze');

insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (19, '{AC}/{PC}', 'LIQUIDEZCORRIENTE', 'Miguel');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (20, '{AC}-{PC}', 'CAPITALDETRABAJO', 'Miguel');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (21, '{P}/{PN}', 'ENDEUDAMIENTO', 'Miguel');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (22, '{EBIT}/{VENTAS}', 'RENTABILIDADOPERATIVA', 'Miguel');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (23, '{EBIT}/{INTERESES}', 'COBERTURADEINTERESES', 'Miguel');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (24, '{OCF}-{TDS}', 'COBERTURADEDEUDA', 'Miguel');
-- insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (34, '{DEUDORESVARIOS}', 'DEUDORESVARIOS', 'Miguel');

insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (25, '{AC}/{PC}', 'LIQUIDEZCORRIENTE', 'David');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (26, '{AC}-{PC}', 'CAPITALDETRABAJO', 'David');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (27, '{P}/{PN}', 'ENDEUDAMIENTO', 'David');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (28, '{EBIT}/{VENTAS}', 'RENTABILIDADOPERATIVA', 'David');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (29, '{EBIT}/{INTERESES}', 'COBERTURADEINTERESES', 'David');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (30, '{OCF}-{TDS}', 'COBERTURADEDEUDA', 'David');
insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (31, '{DOCUMENTOSACOBRAR}+{INTERESES}', 'PODER', 'David');
-- insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (31, '{ResultadoDelEjercicio}', 'RESULTADODELEJERCICIO', 'David');
-- insert into indicador (idIndicador, calculoIndicador, nombreIndicador, nombreUsuario) values (32, '{Proveedores}', 'PROVEEDORES', 'David');

-- METODOLOGIAS
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (1, 'SuperLiquida', 'Paula');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (2, 'Cumplidora', 'Paula');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (3, 'Segura', 'Paula');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (4, 'LaMenosJugada', 'Eze');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (5, 'LaMasRobable', 'Eze');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (6, 'Rica', 'Eze');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (7, 'Bancadora', 'Eze');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (8, 'LaMenosCubierta', 'Miguel');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (9, 'Solvente', 'Miguel');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (10, 'Endeudada', 'Miguel');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (11, 'Poderosa', 'David');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (12, 'SegunResultado', 'David');
insert into metodologia (idMetodologia, nombreMetodologia, usuario) values (13, 'Endeudada', 'David');

-- CONDICIONES
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (1, 3, 'LIQUIDEZCORRIENTE', 'higherThan', 1.5);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (2, 3, 'CAPITALDETRABAJO', 'higherThan', 400000);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (3, 3, 'LIQUIDEZCORRIENTE', 'higherThan', 1.5);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (4, 3, 'CAPITALDETRABAJO', 'higherThan', 400000);

insert into condicionnotaxativa (id, anios, indicadorString, operadorString, peso) values (1, 3, 'ENDEUDAMIENTO', 'lowest', 3);
insert into condicionnotaxativa (id, anios, indicadorString, operadorString, peso) values (2, 3, 'CAJA', 'highest', 3);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (5, 3, 'CAPITAL', 'higherThan', 4200000);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (6, 3, 'RESERVAS', 'higherThan', 4300000);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (7, 3, 'CAPITALDETRABAJO', 'higherThan', 420000);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (8, 3, 'RESERVAS', 'higherThan', 430000);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (9, 3, 'ENDEUDAMIENTO', 'higherThan', 1);

insert into condicionnotaxativa (id, anios, indicadorString, operadorString, peso) values (3, 3, 'COBERTURADEINTERESES', 'lowest', 3);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (10, 3, 'ENDEUDAMIENTO', 'lowerThan', 1);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (11, 3, 'DEUDORESVARIOS', 'lowerThan', 7500250);

insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (12, 3, 'PODER', 'higherThan', 5000000);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (13, 3, 'RESULTADODELEJERCICIO', 'higherThan', 8000000);
insert into condiciontaxativa (id, anios, indicadorString, operadorString, valorComparacion) values (14, 3, 'PROVEEDORES', 'lowerThan', 1400000);

-- METODOLOGIA_CONDICIONES

insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (1, 1);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (2, 2);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (3, 3);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (3, 4);

insert into metodologia_condicionnotaxativa (Metodologia_idMetodologia, cNoTaxativas_id) values (4, 1);
insert into metodologia_condicionnotaxativa (Metodologia_idMetodologia, cNoTaxativas_id) values (5, 2);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (6, 5);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (6, 6);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (7, 7);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (7, 8);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (7, 9);

insert into metodologia_condicionnotaxativa (Metodologia_idMetodologia, cNoTaxativas_id) values (8, 3);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (9, 10);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (10, 11);

insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (11, 12);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (12, 13);
insert into metodologia_condiciontaxativa (Metodologia_idMetodologia, cTaxativas_id) values (13, 14);

