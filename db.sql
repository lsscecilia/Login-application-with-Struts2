create database if not exists UserPasswordTable;

use UserPasswordTable;

create table users (
	userName varchar (50),
	password varchar (50));

insert into users values('john', 'test123');
insert into users values('marry', 'test123');
insert into users values('tom', 'test123');
insert into users values('eric', 'test123');
