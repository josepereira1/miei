
-- ------------------------------------------------------
-- ------------------------------------------------------
-- Universidade do Minho
-- Mestrado Integrado em Engenharia Informática
-- Unidade Curricular de Bases de Dados
-- 
-- Caso de Estudo:A loja BracaTECH
-- Povoamento inicial da base de dados
-- Novembro/2018
-- ------------------------------------------------------
-- ------------------------------------------------------

--
-- Esquema: "BracaTECH"

USE BracaTECH;

-- Povoamento da tabeba "Cliente"

INSERT INTO Cliente
	(nif_cliente, nome_completo , sexo, valor_total_descontos, valor_total_gasto, data_nascimento, data_registo_perfil, pontos_acumulados, email, estado_profissional, codigo_postal, cidade, freguesia, rua)
    Values
    (748637829,'Miguel Nuno Martins Oliveira', 'M',0,0,'1997-11-22','2016-5-31',0,'mnunooliveira@gmail.com', 'Canalizador', '4715-500','Braga', 'Gualtar', 'Rua da Borga'),
    (849677721,'Filipe André Gomes', 'M',0,0,'1990-01-01','2017-02-23',0,'filipegomes@gmail.com', 'Médico', '4715-315','Braga', 'Real', 'Rua da Escada');
    (845577721,'Maria José do Carmo', 'F',0,0,'1990-01-01','2017-02-23',0,'mariacarmo@gmail.com', 'Enfermeira', '4715-200','Braga', 'Nogueira', 'Rua da Escada');

--
-- DELETE FROM Cliente;
SELECT * FROM Cliente;

