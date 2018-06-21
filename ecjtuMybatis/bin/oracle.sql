create table books(
		  id number(7) constraint books_id_pk primary key,
		  bookName varchar2(20) not null,
		  author varchar2(20) not null,
		  publishDate date,
		  bookPrice number(7)
		);
insert into address values(1,'北京','海淀',100000,'中国');
insert into address values(2,'上海','徐汇',200030,'中国');
insert into address values(3,'江西','南昌',215300,'中国');
insert into address values(4,'山西','太原',030001,'中国');
insert into address values(5,'江苏','昆山',030001,'中国');
<!-- 左外连接 -->
select name,city from students s right join address a on s.addr_id = a.addr_id;
select name,city from students s,address a where s.addr_id =+ a.addr_id;