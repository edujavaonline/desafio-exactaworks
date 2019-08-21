CREATE TABLE tb_gasto
(
  id SERIAL      NOT NULL,
  nome_pessoa   VARCHAR(100) NOT NULL,
  descricao_gasto 	VARCHAR(150) NOT NULL,
  data_hora     TIMESTAMP,
  valor 		DECIMAL(10, 2) NOT NULL,  

  CONSTRAINT pk_gasto PRIMARY KEY (id)
);




