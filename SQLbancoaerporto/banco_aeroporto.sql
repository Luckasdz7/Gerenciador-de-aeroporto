create database bancoaeroporto;

use bancoaeroporto;

create table voos(
id int auto_increment primary key,
Embarque varchar(50),
Desembarque varchar(50),
numero_voo varchar(50),
companhia varchar(50),
status_voo varchar(50)
);