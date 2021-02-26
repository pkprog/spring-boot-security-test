create table USER (
    id integer not null,
    email varchar2(255),
    first_name varchar2(50),
    last_name varchar2(100),
    password varchar2(255),
    role varchar2(30) default 'USER',
    status varchar2(20) default 'ACTIVE'
);

alter table USER add constraint PK_USER primary key (id);
