drop index if exists actro_unq;
drop index if exists urro_unq;
drop index if exists actions_unq;
drop index if exists roles_unq;
drop index if exists users_unq;

drop table if exists actro;
drop table if exists urro;
drop table if exists users;
drop table if exists actions;
drop table if exists roles;
drop table if exists users;

create table users (
    id serial primary key,
    name varchar(30) NOT NULL,
    password varchar(20) NOT NULL,
    mail varchar(50),
    fio varchar(50),
    locked char(1) not null,
    created timestamp not null
);
create table roles (
    id serial primary key,
    code varchar(20) NOT NULL
);
create table actions (
    id serial primary key,
    code varchar(20) NOT NULL
);

create table urro (
    user_id integer not null references users(id),
    role_id integer not null references roles(id)
);
create table actro (
    role_id integer not null references roles(id),
    action_id integer not null references actions(id)
);

create unique index users_unq on users(name);
create unique index roles_unq on roles(code);
create unique index actions_unq on actions(code);
create unique index urro_unq on urro(user_id,role_id);
create unique index actro_unq on actro(role_id,action_id);