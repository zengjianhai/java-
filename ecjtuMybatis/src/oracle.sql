create table books(
		  id number(7) constraint books_id_pk primary key,
		  bookName varchar2(20) not null,
		  author varchar2(20) not null,
		  publishDate date,
		  bookPrice number(7)
		);
insert into address values(1,'����','����',100000,'�й�');
insert into address values(2,'�Ϻ�','���',200030,'�й�');
insert into address values(3,'����','�ϲ�',215300,'�й�');
insert into address values(4,'ɽ��','̫ԭ',030001,'�й�');
insert into address values(5,'����','��ɽ',030001,'�й�');
<!-- �������� -->
select name,city from students s right join address a on s.addr_id = a.addr_id;
select name,city from students s,address a where s.addr_id =+ a.addr_id;