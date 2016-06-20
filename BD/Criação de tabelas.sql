-- Table: usuario

-- DROP TABLE usuario;

CREATE TABLE usuario
(
  usu_nm character varying,
  usu_id serial NOT NULL,
  usu_email character varying,
  usu_senha character varying,
  usu_nivel_acesso character varying,
  CONSTRAINT pk_usuario_usu_id PRIMARY KEY (usu_id),
  CONSTRAINT uk_usuario_usu_nm UNIQUE (usu_nm)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario
  OWNER TO postgres;

  
--  insert into usuario(usu_nm, usu_email, usu_senha, usu_nivel_acesso)
--  	values ('Marcos', 'marcos@gmail.com', '12345', 'ROLE_ADMINISTRADOR');
--  	values ('Patrick', 'patrick@gmail.com', '12345', 'ROLE_ADMINISTRADOR');
--  	values ('Denise', 'denise@gmail.com', '12345', 'ROLE_DIRETORIA');
--  	values ('Isael', 'isael@gmail.com', '12345', 'ROLE_DIRETORIA');