USE `Mercearia` ;
-- c)

-- 1
SELECT * 
	FROM Cliente;

-- 2
SELECT Cliente.nome FROM Cliente
	WHERE Cliente.Localidade = 'Aguada do Queixo';

-- 3
SELECT Cliente.Profissao FROM Cliente;
-- ou
SELECT DISTINCT Cliente.Profissao FROM Cliente;
-- DISTINCT REMOVE REPETIDOS

-- 4
SELECT  Produto.Designacao as Nome, Produto.preco FROM Produto order by Nome;

-- 5
SELECT SUM(Total) from Venda where data='2017/10/05';

-- d)

-- 1
INSERT INTO Cliente VALUES (99, 'Nuno Pereira', 	'1983/12/31',	'Médico', 'Rua das Adegas Felizes, 12, 1ª Cave', 'Aguada do Queixo', 
			'9999-99-99 Queijadas', 	123456789, 'np@acacia.pt', 0, NULL);

-- 2
UPDATE Cliente SET Cliente.Rua = 'Passeio Alegre'
	WHERE Cliente.Numero = 99;
    
-- 3
UPDATE Produto SET Produto.Preco= Produto.Preco*1.1
	WHERE Produto.tipo = 'Peixe';
    
-- 4
INSERT INTO Venda VALUES(199,'2018/10/29','S', 69, 79034);

INSERT INTO VendaProduto VALUES(10,1,1,(SELECT Preco FROM Produto WHERE Numero = 1), (SELECT Preco FROM Produto WHERE Numero = 1)*1);
INSERT INTO VendaProduto VALUES(10,2,2,(SELECT Preco FROM Produto WHERE Numero = 2), (SELECT Preco FROM Produto WHERE Numero = 2)*2);
INSERT INTO VendaProduto VALUES(10,3,1,(SELECT Preco FROM Produto WHERE Numero = 3), (SELECT Preco FROM Produto WHERE Numero = 3)*1);
INSERT INTO VendaProduto VALUES(10,4,1,(SELECT Preco FROM Produto WHERE Numero = 4), (SELECT Preco FROM Produto WHERE Numero = 4)*1);

SELECT * FROM Venda
	WHERE Numero = 199;

UPDATE Venda SET Total = (SELECT SUM(Valor) FROM VendaProduto WHERE Venda = 199);

SELECT * FROM Venda
	WHERE Numero = 199;
    
DELETE FROM VendaProduto WHERE VENDA = 199;

