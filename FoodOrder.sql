create database foodordering;
use foodordering;

select *from Customer;
select *from Address;
select *from Restaurant;
select *from fooditem;

insert into customer values(1,'Reddy','hemanth@email.com','Hemanth','hemanth1234',1);
insert into address values(1,'kuppam','india','Andhra Pradesh','stp',517423);

insert into Restaurant values(2,'kuppam',64723,'Udupi');
insert into Restaurant values(1,'Bangalore',6472336,'Biriyani palace');
insert into Restaurant values(3,'Bangalore',6475336,'HotelShabari');

insert into fooditem values(6,'https://images.unsplash.com/photo-1476224203421-9ac39bcb3327?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1950&q=80','Cream Role',100,3);
insert into fooditem values(2,'https://tse3.mm.bing.net/th?id=OIP.v69sze5oVNYYQXMWgPgM_AHaDt&pid=Api&P=0&w=344&h=173','HuffPost',200,2);
insert into fooditem values(3,'https://www.goatsontheroad.com/wp-content/uploads/2015/05/india-food.jpg','Dosa',40,2);
insert into fooditem values(5,'https://tse3.mm.bing.net/th?id=OIP.XhBvmWRpWeb7fvZf9oTuDAHaFj&pid=Api&P=0&w=231&h=174','Biriyani',100,1);
insert into fooditem values(7,'https://images.unsplash.com/photo-1529042410759-befb1204b468?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=333&q=80
','Manchurian Balls',250,3);

insert into cart values(1,1);

Desc Customer;
Desc orders;
Desc Restaurant

Desc cart_order;


show tables;
drop tables address;
drop tables orders;
drop tables restaurant;
drop tables cart;
drop tables customer;
drop tables fooditem;
drop tables hibernate_sequence;