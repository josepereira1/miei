USE myDB;

-- 1
CREATE TABLE ListaFaltas(
	NrCromo INT PRIMARY KEY
);
-- Esta tabela serve apenas para criar uma tabela a dizer que determinado cromo está em falta,
-- apenas foi para mostrar a transaction 

-- 2
DROP PROCEDURE IF EXISTS povoarListaFalta;

DELIMITER $$ 
CREATE PROCEDURE povoarListaFalta(IN total INT)
BEGIN

	DECLARE adq char(1) DEFAULT 'N';
   
   test_loop: LOOP 
		
        IF total = 0 THEN 
			LEAVE test_loop;
		END IF;
        
        SET adq = 'N';
        
        SELECT Cromo.adquirido INTO adq FROM Cromo WHERE Cromo.Nr = total;
        
        IF(adq = 'N') THEN 
			INSERT INTO ListaFaltas VALUES (total);
		END IF;
        
        SET total = total -1;
        
        END LOOP;
        
END $$
DELIMITER ;
    
CALL povoarListaFalta(350);
    
SELECT * FROM CROMO;
    
SELECT * FROM LISTAFALTAS;
    
-- 3
DROP PROCEDURE IF EXISTS angariacao_cromo;
    
DELIMITER $$
CREATE PROCEDURE angariacao_cromo()
BEGIN
    
    SET AUTOCOMMIT = OFF;
    
    -- COMEÇA UMA NOVA TRANSAÇÃO
    START TRANSACTION;
	
	-- LÓGICA
        UPDATE Cromo
			SET adquirido = 'S' WHERE nr =70;
		DELETE FROM ListaFaltas WHERE ListaFaltas.NrCromo = 70;	-- qd o cromo passa a adquirido, temos que elimiar a tabela
    
    COMMIT;
    
END $$
DELIMITER ;
    
CALL angariacao_cromo();
    
-- 4
DROP PROCEDURE IF EXISTS  perda_cromo;

DELIMITER $$
CREATE PROCEDURE perda_cromo()
BEGIN
	
	SET AUTOCOMMIT = OFF;

	START TRANSACTION;
    
    UPDATE Cromo
		SET adquirido = 'N' WHERE nr = 70;
        INSERT INTO ListaFaltas (NrCromo) VALUES (70);
	
    COMMIT;
END $$
DELIMITER ;

CALL perda_cromo;

SELECT * FROM CROMO WHERE CROMO.Nr = 70;	-- verificar qd está adquirido
SELECT * FROM CROMO INNER JOIN LISTAFALTAS ON CROMO.Nr = LISTAFALTAS.NrCromo WHERE Cromo.Nr = 70; -- verificar qd n está adquirido

-- 5

DELIMITER $$
CREATE TRIGGER update_cromo_adquirido AFTER UPDATE ON Cromo
	FOR EACH ROW
		UPDATE Cromo
			SET adquirido = 'S' WHERE nr =70;
            
		DELETE FROM ListaFaltas WHERE ListaFaltas.NrCromo = 70
	END $$
DELIMITER ;


-- 6

DROP PROCEDURE IF EXISTS apresenta_equipa ;

DELIMITER $$
CREATE PROCEDURE apresenta_equipa (IN id CHAR(3), OUT res VARCHAR(2000)) 
BEGIN

	DECLARE v_finished integer default 0;
    DECLARE v_treinador VARCHAR(50);
    DECLARE v_nome_equipa VARCHAR(50);
    DECLARE v_nome_jogador VARCHAR(50);
    DECLARE v_posicao VARCHAR(50);

	DECLARE jogador_cursor CURSOR FOR 
    SELECT j.Nome, p.Designacao
		FROM Jogador j, Posicao p 
			WHERE j.posicao = p.id and j.Equipa = id;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_finished = 1;
    
    SELECT treinador, designacao INTO v_treinador, v_nome_equipa
		FROM Equipa WHERE Equipa.id = id;
        
	SET res = CONCAT(v_nome_equipa, ", ", v_treinador);
    
    OPEN jogador_cursor;
    
    get_jogador : LOOP
		FETCH jogador_cursor INTO v_nome_jogador, v_posicao;
		IF v_finished = 1 THEN
			LEAVE get_jogador;
		END IF;
        SET res = CONCAT(v_nome_jogador, ", ", v_posicao, ", ", res);
	END LOOP;
    CLOSE jogador_cursor;
END $$
DELIMITER ;

	
            