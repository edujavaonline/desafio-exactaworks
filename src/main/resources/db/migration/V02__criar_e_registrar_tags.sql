CREATE TABLE tb_tag
(
  id SERIAL      NOT NULL, 
  descricao_tag 	VARCHAR(150) NOT NULL,  

  CONSTRAINT pk_tag PRIMARY KEY (id)
);

INSERT INTO tb_tag (descricao_tag) VALUES ('Alimentação');
INSERT INTO tb_tag (descricao_tag) VALUES ('Lazer');
INSERT INTO tb_tag (descricao_tag) VALUES ('Farmácia');
INSERT INTO tb_tag (descricao_tag) VALUES ('Supermercado');
INSERT INTO tb_tag (descricao_tag) VALUES ('Açougue');

