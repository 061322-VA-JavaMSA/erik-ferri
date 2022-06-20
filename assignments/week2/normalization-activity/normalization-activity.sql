drop table if exists SalesStaff;
create table if not exists SalesStaff (
	Employee_ID SERIAL primary KEY,
	Sales_Person VARCHAR(30),
	SO_Street VARCHAR(30),
	SO_City VARCHAR(30),
	SO_State VARCHAR(30),
	SO_Zip INTEGER,
	Age INTEGER,
	DoB DATE
);

drop table if exists Customers;
create table if not exists Customers (
	Customer_ID SERIAL primary KEY,
	Customer_Name VARCHAR(30)
);