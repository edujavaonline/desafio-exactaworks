CREATE TABLE tb_gasto_tag
(  
  id_gasto  INTEGER NOT NULL,
  id_tag  INTEGER NOT NULL  
);

ALTER TABLE tb_gasto_tag ADD PRIMARY KEY (id_gasto, id_tag);
ALTER TABLE tb_gasto_tag ADD FOREIGN KEY (id_gasto) REFERENCES tb_gasto(id);
ALTER TABLE tb_gasto_tag ADD FOREIGN KEY (id_tag) REFERENCES tb_tag(id);