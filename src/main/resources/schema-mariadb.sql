drop table if exists user;

create table user (
    id int primary key auto_increment,
    email varchar(250) not null,
    password varchar(250) not null,
    created_at date not null,
    updated_at date not null
);

