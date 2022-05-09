drop table if exists "public".TMARCAS;
drop table if exists "public".TNOTAS;

create table "public".TMARCAS (
    USUARIO VARCHAR(100) primary key,
    CO_HOMBRO VARCHAR(5) not null,
    CO_ESPALDA1 VARCHAR(5) not null,
    CO_ESPALDA2 VARCHAR(5) not null,
    PESO_MUERTO INTEGER not null,
    PRESS_BANCA INTEGER not null,
    SENTADILLA INTEGER not null,
    FECHA_INICIO DATE not null
);

create table "public".TNOTAS (
    ID serial primary key,
    USUARIO varchar(100) not null,
    NOTA text
);

insert into "public".TNOTAS
(ID, USUARIO, NOTA)
values (11, 'USER1', 'Esta es la 1 nota de prueba para el usuario 2');

SELECT * FROM "public".TNOTAS;

CREATE SEQUENCE "public".notas_id_seq START 1 INCREMENT 1;

drop sequence "public".notas_id_seq;

