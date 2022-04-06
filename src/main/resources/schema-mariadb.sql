drop table if exists USUARIO;
drop table if exists TMARCAS;

create table USUARIO (
    id serial primary key,
    email varchar(250) not null,
    password varchar(250) not null,
    created_at date not null,
    updated_at date not null
);

create table TMARCAS (
    USUARIO varchar(200) primary key,
    CO_HOMBRO CHAR(1) not null,
    CO_ESPALDA1 CHAR(1) not null,
    CO_ESPALDA2 CHAR(1) not null,
    PESO_MUERTO INTEGER not null,
    PRESS_BANCA INTEGER not null,
    SENTADILLA INTEGER not null,
    FECHA_INICIO date not null
);

insert into TMARCAS
(USUARIO, CO_HOMBRO, CO_ESPALDA1, CO_ESPALDA2, PESO_MUERTO, PRESS_BANCA, SENTADILLA, FECHA_INICIO)
values ('USER3', 'E', 'D', 'R', 160, 110, 130, '07/04/2022');

SELECT * FROM TMARCAS;