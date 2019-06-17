create database back_end_dao;
create user victor@'%' identified by '123';
grant all on back_end_dao.* to victor@'%';

use back_end_dao;
create table papel(id long, descricao varchar(100));
insert into papel values(1,"CHEFE_DE_SECAO");
insert into papel values(2,"USUARIO_COMUM");
insert into papel values(3,"MESARIO");

create table candidato(id long,nome varchar(100), numero varchar(100), qtdvotos int(100));
insert into candidato values(0,"Nulo","0",0);
insert into candidato values(1,"Joao","12",0);
insert into candidato values(2,"Marcelo","13",0);
insert into candidato values(3,"Carlos","14",0);


create table usuario(id long, nomeusuario varchar(100), senha varchar(100), 
nome varchar(100), 
autorizacao varchar(100),
 voto varchar(100));
insert into usuario values(1, "fabricio", "12345", "Fabricio G. M. de Carvalho", "nao autorizado","");
insert into usuario values(2, "thales", "xtz", "Thales Carvalho","nao autorizado", "");
insert into usuario values(3, "victor", "1234", "Victor Machado","nao autorizado", "");

create table usuario_papel(id_usuario long, id_papel long);
insert into usuario_papel values(1,1);
insert into usuario_papel values(2,2);
insert into usuario_papel values(3,3);
use back_end_dao;
CREATE TABLE `back_end_dao`.`usuario_candidato` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `id_usuario` INT(10) NOT NULL,
  `id_candidato` INT(10) NOT NULL,
  PRIMARY KEY (`id`));



