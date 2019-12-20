USE SAKILA;


SELECT * FROM ACTOR;

SELECT actor_id, first_name FROM ACTOR;

INSERT INTO ACTOR 
	VALUES(1000,'José', 'Pereira', '2006-02-15 04:34:33');
    
SELECT * FROM ACTOR
	WHERE actor_id = 1000;
    
UPDATE ACTOR
	SET last_name = 'Pereira'
		WHERE actor_id = 1000;
        
SELECT * FROM CUSTOMER
	WHERE email IS NOT NULL;
    
SELECT * FROM ACTOR
	WHERE last_name = 'Wood';
    
DELETE FROM ACTOR
	WHERE actor_id = 1000;
    
SELECT * FROM ACTOR
	WHERE actor_id = 1000;