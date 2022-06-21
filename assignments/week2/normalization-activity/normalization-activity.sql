drop table if exists sales_offices;
drop table if exists sales_staff;
drop table if exists customers;

create table if not exists sales_offices (
	office_id serial primary key,
	office_name varchar(30),
	street varchar(30),
	city varchar(30),
	state varchar(30),
	zip integer
);

create table if not exists sales_staff (
	employee_id serial primary key,
	sales_person_name varchar(30),
	DoB date,
	sales_office integer references sales_offices(office_id)
);

create table if not exists customers (
	customer_id serial primary key,
	customer_name varchar(30),
	sales_person integer references sales_staff(employee_id)
);