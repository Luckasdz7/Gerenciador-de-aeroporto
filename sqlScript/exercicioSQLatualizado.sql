
create database bancoaeroporto;

use bancoaeroporto;
select * from voos;
create table voos(
id int auto_increment primary key,
Embarque varchar(50),
Desembarque varchar(50),
numero_voo varchar(50),
companhia varchar(50),
status_voo varchar(50),
id_aeronaves int,

foreign key (id_aeronaves) references aeronaves (id_aeronaves)

);



create table passageiros(
id_passageiros int auto_increment primary key,
nome varchar(50),
cpf varchar(25),
email varchar(25),
telefone varchar(25)

);

create table reservas(
id_resevar int auto_increment primary key,
id_passageiros int,
id_voos int,
assento varchar(25),
data_reservar date,
foreign key (id_passageiros) references passageiros (id_passageiros),
foreign key (id_voos) references voos(id)

);
SELECT * FROM passageiros;


SELECT * FROM reservas;


create table aeronaves(
id_aeronaves int auto_increment primary key,
modelos varchar(25),
capacidade int

);

SELECT * FROM usuarios;

SELECT * FROM usuarios;
CREATE TABLE usuarios (
    id_usuarios INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfil varchar(25)
);
SELECT * FROM usuarios;

CREATE USER 'app_aeroporto'@'localhost' IDENTIFIED BY 'senha_segura_123';


GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON bancoaeroporto.* TO 'app_aeroporto'@'localhost';


FLUSH PRIVILEGES;


CREATE VIEW vw_detalhes_reservas AS
SELECT 
    r.id_resevar, 
    r.assento, 
    r.data_reservar,
    p.id_passageiros, 
    p.nome, 
    p.cpf,
    v.id AS id_voo, 
    v.numero_voo,
    v.companhia
FROM reservas r
JOIN passageiros p ON r.id_passageiros = p.id_passageiros
JOIN voos v ON r.id_voos = v.id;

CREATE TABLE log_reservas_excluidas (
    id_log INT AUTO_INCREMENT PRIMARY KEY,
    id_resevar_antigo INT,
    data_exclusao DATETIME,
    usuario_db VARCHAR(50)
);


DELIMITER //

CREATE TRIGGER trg_auditoria_exclusao_reserva
AFTER DELETE ON reservas
FOR EACH ROW
BEGIN
    -- Sempre que um DELETE ocorrer na tabela 'reservas', este bloco será executado
    INSERT INTO log_reservas_excluidas (id_resevar_antigo, data_exclusao, usuario_db)
    VALUES (OLD.id_resevar, NOW(), CURRENT_USER());
END //

DELIMITER ;
