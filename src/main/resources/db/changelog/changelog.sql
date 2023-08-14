-- liquibase formatted sql
-- changeset azamat_komaev:1
create table posts (
    id serial primary key,
    title varchar(255) not null,
    description text not null,
    author_name varchar(255) not null
);