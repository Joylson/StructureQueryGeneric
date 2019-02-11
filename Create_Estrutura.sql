
create sequence id_user_system 

drop sequence id_user_system 

create table user_system(
	id int primary key default nextval('id_user_system'),
	name_user varchar(50) not null unique,
	email varchar(80),
	pass varchar(30),
	date_cad date			
)

drop table user_system 	

insert into user_system(name_user, email, pass, date_cad)
	values('Joylson', 'joylsont@gmail.com', '91735129', '2019-02-10'),
	('Lucas', 'lucas@gmail.com', '123456', '2018-10-11'),
	('Victor', 'victor@gmail.com', '654321', '2019-04-05'),
	('Thiago', 'thiago@gmail.com', '987654', '2018-05-09'),
	('David', 'david@gmail.com', '654789', '2019-09-11')

select * from id_user_system 

select * from user_system 