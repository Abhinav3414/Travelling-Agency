connect 'jdbc:derby://localhost:1527/team01;create=true;user=me;password=mine';

create table ATA_TBL_USER_credentials
(
userid varchar(6) primary key,
password varchar(20) not null,
usertype varchar(1),
loginstatus int
);

create table ATA_TBL_USER_PROFILE
(
userid varchar(6) primary key references ata_tbl_user_credentials(userid),
firstname varchar(15) not null,
lastname varchar(15) not null,
dateofbirth date not null,
gender varchar(7) not null,
street varchar(30) not null,
location varchar(15) not null,
city varchar(15) not null,
state varchar(15) not null,
pincode varchar(10) not null,
mobileno varchar(10),
emailid varchar(30)
);

create table ATA_TBL_CREDITCARD
(
creditcardnumber varchar(16) primary key,
validfrom varchar(7) not null,
validto varchar(7) not null,
creditbalance double not null,
userid varchar(6) references ata_tbl_user_credentials(userid)
);

create table ATA_TBL_vehicle
(
vehicleid varchar(6) primary key,
name varchar(20) not null,
type varchar(8) not null,
registrationnumber varchar(20) not null,
seatingcapacity int not null,
fareperkm double
);

create table ATA_TBL_route
(
routeid varchar(8) primary key ,
source varchar(20) not null,
destination varchar(20) not null,
distance double not null,
travelduration double not null
);

create table ATA_TBL_RESERVATION
(
reservationid varchar(6) primary key ,
userid varchar(6) references ata_tbl_user_credentials(userid),
vehicleid varchar(6) references ATA_TBL_vehicle(vehicleid),
routeid varchar(8) references ATA_TBL_route(routeid),
bookingdate date not null,
journeydate date not null,
driverid varchar(6) references ATA_TBL_driver(driverid),
bookingstatus varchar(20) not null,
totalfare double not null,
boardingpoint varchar(30) not null,
droppoint varchar(30) not null
);

alter table ATA_TBL_USER_credentials add column qus()varchar(20));

insert into ATA_TBL_CREDITCARD values('abc1234567890def','02/2001','02/2015',1000000,'de1002');
alter table ATA_TBL_USER_credentials add column qus varchar(20);
alter table ATA_TBL_USER_credentials add column ans varchar(20);

insert into ATA_TBL_CREDITCARD values('abcdef1234567890','02/2000','02/2015',1000000,'as1001');

insert into ATA_TBL_USER_credentials values('abhi', 'abhi', 'A',0);
insert into ATA_TBL_Vehicle values('AB2345','MARUTI','AC','123456',5,25);

insert into ATA_TBL_CREDITCARD values ('1020304050607080','06/2010','05/2015',20000,'Ab1000');
insert into ATA_TBL_CREDITCARD values ('2030405060708090','01/2010','12/2014',20000,'Ab1001');
insert into ATA_TBL_CREDITCARD values ('3040506070809010','03/2009','02/2014',20000,'Ja1002');
insert into ATA_TBL_CREDITCARD values ('4050607080901020','06/2012','05/2016',20000,'Ki1003');

insert into ATA_TBL_ROUTE values('AB786','ASD','',21,2);

insert into ATA_TBL_driver values('Du1006','dummy','dummy','dummy','dummy','dummy','123456','1234567890','Du-Ls01');

update ATA_TBL_CREDITCARD set creditbalance=1000000 where userid='as1001'

update ATA_TBL_RESERVATION set bookingstatus='pending' where reservationid='Gh1024'; 

update ATA_TBL_RESERVATION set bookingstatus='pending' where reservationid='Gh1011'; 
update ATA_TBL_USER_credentials set qus='favourite color';
update ATA_TBL_USER_credentials set ans='red' where userid='as1000';
update ATA_TBL_USER_credentials set ans='red' where userid='as1001';
update ATA_TBL_USER_credentials set ans='red' where userid='De1002';


select * from ATA_TBL_reservation where journeydate='2014-11-11' and boardingpoint='abc' and droppoint='def';

select * from ATA_TBL_USER_credentials;
select * from ATA_TBL_USER_PROFILE;
select * from ATA_TBL_driver;
select * from ATA_TBL_vehicle;
select * from ATA_TBL_route;
select * from ATA_TBL_RESERVATION;
select * from ATA_TBL_CREDITCARD;

desc ATA_TBL_CREDITCARD;

select totalfare from ATA_TBL_RESERVATION where userid='as1001';

Default Driver = Du1006

update ATA_TBL_USER_credentials set usertype='A';
update ATA_TBL_USER_credentials set password='password123' where userid='Ab1001';
update ATA_TBL_USER_credentials set loginstatus=0;
update ATA_TBL_CREDITCARD set creditbalance=100000;

delete from ATA_TBL_CREDITCARD where validfrom='2/1991';
delete from ATA_TBL_CREDITCARD where validfrom='06/2010';
delete from ATA_TBL_RESERVATION;

create sequence ata_seq_userId as integer start with 1000;
create sequence ata_seq_routeId as integer start with 1000;
create sequence ata_seq_driverId as integer start with 1000;
create sequence ata_seq_vehicleId as integer start with 1000;
create sequence ata_seq_reservationId as integer start with 1000;

values(next value for ata_seq_driverId);

delete from ATA_TBL_USER_PROFILE;
delete from ATA_TBL_USER_credentials;
delete from ATA_TBL_driver;
delete from ATA_TBL_vehicle;
delete from ATA_TBL_route;
delete from ATA_TBL_CREDITCARD;
delete from ATA_TBL_RESERVATION;