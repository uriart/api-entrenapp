drop table if exists usuario;

create table usuario (
    id int primary key auto_increment,
    email varchar(250) not null,
    password varchar(250) not null,
    created_at date not null,
    updated_at date not null
);

insert into usuario
(id, email, password, created_at, updated_at) values
(1, 'loiro_8@hotmail.com', 'paswordddd', '2020-01-01', '2020-03-19'),
(2, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19'),
(3, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19'),
(4, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19'),
(5, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19'),
(6, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19'),
(7, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19'),
(8, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19'),
(9, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19'),
(10, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19'),
(11, 'mar@gmail.com', 'paswordddd2', '2020-01-01', '2020-03-19');