drop table if exists user;

create table user (
    id int primary key auto_increment,
    email varchar(250) not null,
    password varchar(250) not null,
    created_at date not null,
    updated_at date not null
);

insert into user
(id, email, password, created_at, updated_at) values
(1, 'loiro_8@hotmail.com', 'paswordddd', '2020-01-01', '2020-03-19'),
(2, 'mar@gmail.ocm', 'paswordddd2', '2020-01-01', '2020-03-19');