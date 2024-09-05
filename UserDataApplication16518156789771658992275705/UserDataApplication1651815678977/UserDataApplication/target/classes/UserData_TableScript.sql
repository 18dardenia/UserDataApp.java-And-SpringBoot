drop schema if exits users_db;

create schema users_db;
use users_db;

drop table userdata;

create table userdata(
user_id int primary key auto_increment,
user_name varchar(10) not null,
password varchar(10) not null,
phone_no bigint not null,
city varchar(20)  not null
);

insert into userdata values(2000,'Chris','Chris12345',9034876756,'Bangalore');
insert into userdata values(2001,'Ricky','Ricky12345',9145367865,'Mumbai');
insert into userdata values(2002,'Nick','Nick123456',9034876756,'Delhi');
insert into userdata values(2003,'Chris','Chris98776',9864453498,'Chennai');


--commit;
select * from userdata;
