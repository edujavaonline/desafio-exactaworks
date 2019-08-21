CREATE TABLE tb_usuario
(
  id SERIAL                 NOT NULL,
  nome   CHARACTER VARYING(50)  NOT NULL,
  email  CHARACTER VARYING(50)  NOT NULL,
  senha  CHARACTER VARYING(150) NOT NULL,

  CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE TABLE tb_permissao
(
  id    SERIAL                NOT NULL,
  descricao CHARACTER VARYING(50) NOT NULL,

  CONSTRAINT pk_permissao PRIMARY KEY (id)
);

CREATE TABLE tb_usuario_permissao
(
  id_usuario   INTEGER NOT NULL,
  id_permissao INTEGER NOT NULL
);
ALTER TABLE tb_usuario_permissao ADD PRIMARY KEY (id_usuario, id_permissao);
ALTER TABLE tb_usuario_permissao ADD FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id);
ALTER TABLE tb_usuario_permissao ADD FOREIGN KEY (id_permissao) REFERENCES tb_permissao(id);

-- INSERTS
INSERT INTO tb_usuario (id, nome, email, senha) VALUES (1, 'Administrador', 'admin@exactaworks.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO tb_usuario (id, nome, email, senha) VALUES (2, 'Eduardo Santos', 'edu@exactaworks.com', '$2a$10$jESP1A6aA0ghpgVEXc1mNe8Ne753oTAwJDt5CvEMJ9vvqL1qXKQ42');

INSERT INTO tb_permissao (id, descricao) VALUES (1, 'ROLE_CADASTRAR_GASTO');
INSERT INTO tb_permissao (id, descricao) VALUES (2, 'ROLE_PESQUISAR_GASTO');
INSERT INTO tb_permissao (id, descricao) VALUES (3, 'ROLE_REMOVER_GASTO');

INSERT INTO tb_permissao (id, descricao) VALUES (4, 'ROLE_CADASTRAR_TAG');
INSERT INTO tb_permissao (id, descricao) VALUES (5, 'ROLE_REMOVER_TAG');
INSERT INTO tb_permissao (id, descricao) VALUES (6, 'ROLE_PESQUISAR_TAG');


-- admin
INSERT INTO tb_usuario_permissao (id_usuario, id_permissao) VALUES (1, 1);
INSERT INTO tb_usuario_permissao (id_usuario, id_permissao) VALUES (1, 2);
INSERT INTO tb_usuario_permissao (id_usuario, id_permissao) VALUES (1, 3);
INSERT INTO tb_usuario_permissao (id_usuario, id_permissao) VALUES (1, 4);
INSERT INTO tb_usuario_permissao (id_usuario, id_permissao) VALUES (1, 5);
INSERT INTO tb_usuario_permissao (id_usuario, id_permissao) VALUES (1, 6);


-- eduardo
INSERT INTO tb_usuario_permissao (id_usuario, id_permissao) VALUES (2, 1);
INSERT INTO tb_usuario_permissao (id_usuario, id_permissao) VALUES (2, 2);
INSERT INTO tb_usuario_permissao (id_usuario, id_permissao) VALUES (2, 3);