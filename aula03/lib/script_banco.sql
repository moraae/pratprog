create database aula03;

use aula03;

create table if not exists pais
(
	id int auto_increment,
	nome varchar(100),
	populacao bigint,
	area decimal(15,2),
	primary key(id)
);

insert into pais values(default, 'Rússia', 140300000, 17.07);
insert into pais values(default, 'Canadá', 33800000, 9.97);
insert into pais values(default, 'China', 1300000000, 9.59);
insert into pais values(default, 'Estados Unidos', 317600000, 9.36);
insert into pais values(default, 'Austrália', 21500000, 7.71);
insert into pais values(default, 'Índia', 1200000000, 3.28);
insert into pais values(default, 'Argentina', 40600000, 2.27);
insert into pais values(default, 'Cazaquistão', 15700000, 2.71);
insert into pais values(default, 'Sudão', 43100000, 2.50);