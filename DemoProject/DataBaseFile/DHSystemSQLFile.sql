
-- create table Dormitory
create table Dormitory(
id int(11) unsigned not null  auto_increment,
dorId varchar(20) default null,
password varchar(20) default '123456',
address varchar(20) default null,
points int(11) unsigned not null,
student varchar(100) default null,
primary key (id))
engine = InnoDB
default charset =utf8;


-- insert test record
insert into Dormitory(dorId,password,address,points,student)
			values('01101','01101','梅苑1幢101',84,'Leon Paul Leo Harry Gorden'),  
('01102','01102','梅苑1幢102',98,'Chirs Blake Griffin Nash Leborn'),
('01103','01103','梅苑1幢103',77,'James Dog Curry Feiwu Green'),
('01104','01104','梅苑1幢104',45,'Steve Nash Bob Pepper Rogeos'),
('01201','01201','梅苑1幢201',87,'Austin Rivers Doc Redick Kevin'),
('01202','01202','梅苑1幢202',56,'Steve Ward Gasoul Rambo Jim');

insert into Dormitory(dorId,address,points,student)
			values('01203','梅苑1幢203',89,'Jenny '),
('01204','梅苑1幢204',94,'King '),
('01301','梅苑1幢301',85,'Jimmy '),
('01302','梅苑1幢302',87,'Rood '),
('01303','梅苑1幢303',48,'Rivers '),
('01304','梅苑1幢304',87,'Doc '),
('02101','梅苑2幢101',84,'Dom '),
('02102','梅苑2幢102',76,'Dan '),
('02103','梅苑2幢103',78,'Daniel '),
('02104','梅苑2幢104',98,'Denver '),
('02201','梅苑2幢201',85,'Duma '),
('02202','梅苑2幢202',91,'Forrst '),
('02203','梅苑2幢203',82,'Friday '),
('02204','梅苑2幢204',75,'God '),
('02301','梅苑2幢301',68,'Godlike '),
('02302','梅苑2幢302',87,'Gump '),
('02303','梅苑2幢303',88,'Jim '),
('02304','梅苑2幢304',84,'Jerry '),
('03101','梅苑3幢101',87,'Jellsy '),
('03102','梅苑3幢102',54,'Jan '),
('03103','梅苑3幢103',87,'Lin '),
('03104','梅苑3幢104',52,'Lincon '),
('03201','梅苑3幢201',87,'Lilly '),
('03202','梅苑3幢202',85,'David '),
('03203','梅苑3幢203',95,'Nancy '),
('03204','梅苑3幢204',78,'Tom '),
('03301','梅苑3幢301',87,'Leon '),
('03302','梅苑3幢302',56,'Leo '),
('03303','梅苑3幢303',99,'Harry '),
('03304','梅苑3幢304',74,'Cool '),
('04101','梅苑4幢101',85,'Harvey '),
('04102','梅苑4幢102',87,'Joyce '),
('04103','梅苑4幢103',56,'Jack '),
('04104','梅苑4幢104',77,'Jemma '),
('04201','梅苑4幢201',66,'Sky '),
('04202','梅苑4幢202',55,'Ward '),
('04203','梅苑4幢203',47,'Steven '),
('04204','梅苑4幢204',87,'Rojos '),
('04301','梅苑4幢301',85,'Tony '),
('04302','梅苑4幢302',80,'Stark '),
('04303','梅苑4幢303',90,'Banner '),
('04304','梅苑4幢304',70,'Wongda '),
('05101','梅苑5幢101',56,'Deed '),
('05102','梅苑5幢102',87,'Ameria '),
('05103','梅苑5幢103',60,'Amanda '),
('05104','梅苑5幢104',87,'Obama '),
('05201','梅苑5幢201',88,'Leborn '),
('05202','梅苑5幢202',58,'Kary '),
('05203','梅苑5幢203',97,'Irving '),
('05204','梅苑5幢204',77,'Durant '),
('05301','梅苑5幢301',79,'Jeremony '),
('05302','梅苑5幢302',92,'George '),
('05303','梅苑5幢303',92,'Harden '),
('05304','梅苑5幢304',92,'Howard '),
('06101','兰苑6幢101',84,'Pggy '),
('06102','兰苑6幢102',98,'Lee '),
('06103','兰苑6幢103',77,'Levis '),
('06104','兰苑6幢104',45,'JJ '),
('06201','兰苑6幢201',87,'Smith '),
('06202','兰苑6幢202',56,'Redick'),
('06203','兰苑6幢203',89,'King'),
('06204','兰苑6幢204',94,'Ben '),
('06301','兰苑6幢301',85,'Rood '),
('06302','兰苑6幢302',87,'Michael'),
('06303','兰苑6幢303',48,'Jordan '),
('06304','兰苑6幢304',87,'Kobe '),
('07101','兰苑7幢101',84,'Bryant '),
('07102','兰苑7幢102',76,'Anthony '),
('07103','兰苑7幢103',78,'Cram '),
('07104','兰苑7幢104',98,'Carl '),
('07201','兰苑7幢201',85,'Kitty '),
('07202','兰苑7幢202',91,'Brown '),
('07203','兰苑7幢203',82,'Green '),
('07204','兰苑7幢204',75,'Black '),
('07301','兰苑7幢301',68,'White '),
('07302','兰苑7幢302',87,'Whiteside '),
('07303','兰苑7幢303',99,'Wade '),
('07304','兰苑7幢304',84,'Bruce '),
('08101','兰苑8幢101',87,'Wayne '),
('08102','兰苑8幢102',54,'Cat '),
('08103','兰苑8幢103',87,'Dog '),
('08104','兰苑8幢104',52,'Pig '),
('08201','兰苑8幢201',87,'Apple '),
('08202','兰苑8幢202',85,'Banana '),
('08203','兰苑8幢203',95,'Pen '),
('08204','兰苑8幢204',78,'Penic '),
('08301','兰苑8幢301',87,'Joy '),
('08302','兰苑8幢302',56,'Holiday '),
('08303','兰苑8幢303',99,'Abby '),
('08304','兰苑8幢304',74,'Ailsa '),
('09101','兰苑9幢101',85,'Alice '),
('09102','兰苑9幢102',87,'Alina '),
('09103','兰苑9幢103',56,'Allison '),
('09104','兰苑9幢104',77,'Aamanda '),
('09201','兰苑9幢201',66,'Ann '),
('09202','兰苑9幢202',55,'Amber '),
('09203','兰苑9幢203',47,'Andrea '),
('09204','兰苑9幢204',87,'Angela '),
('09301','兰苑9幢301',85,'Anita '),
('09302','兰苑9幢302',80,'Jay '),
('09303','兰苑9幢303',90,'Ariel '),
('09304','兰苑9幢304',70,'Taylor '),
('10101','兰苑10幢101',70,'Swift '),
('10102','兰苑10幢102',70,'April '),
('10103','兰苑10幢103',60,'Aviva '),
('10104','兰苑10幢104',87,'Bonnie '),
('10201','兰苑10幢201',88,'Becky '),
('10202','兰苑10幢202',58,'Betty '),
('10203','兰苑10幢203',97,'Brenda '),
('10204','兰苑10幢204',77,'Candice '),
('10301','兰苑10幢301',79,'Carrie '),
('10302','兰苑10幢302',92,'Cathy '),
('10303','兰苑10幢303',92,'Demi '),
('10304','兰苑10幢304',92,'Doona '),
('11101','竹苑11幢101',70,'Swift '),
('11102','竹苑11幢102',70,'April '),
('11103','竹苑11幢103',60,'Aviva '),
('11104','竹苑11幢104',87,'Bonnie '),
('11201','竹苑11幢201',88,'Becky '),
('11202','竹苑11幢202',58,'Betty '),
('11203','竹苑11幢203',97,'Brenda '),
('11204','竹苑11幢204',77,'Candice '),
('11301','竹苑11幢301',79,'Carrie '),
('11302','竹苑11幢302',92,'Cathy '),
('11303','竹苑11幢303',92,'Demi '),
('11304','竹苑11幢304',92,'Doona '),
('12101','竹苑12幢101',70,'Swift '),
('12102','竹苑12幢102',70,'April '),
('12103','竹苑12幢103',60,'Aviva '),
('12104','竹苑12幢104',87,'Bonnie '),
('12201','竹苑12幢201',88,'Becky '),
('12202','竹苑12幢202',58,'Betty '),
('12203','竹苑12幢203',97,'Brenda '),
('12204','竹苑12幢204',77,'Candice '),
('12301','竹苑12幢301',79,'Carrie '),
('12302','竹苑12幢302',92,'Cathy '),
('12303','竹苑12幢303',92,'Demi '),
('12304','竹苑12幢304',92,'Doona '),
('13101','竹苑13幢101',70,'Swift '),
('13102','竹苑13幢102',70,'April '),
('13103','竹苑13幢103',60,'Aviva '),
('13104','竹苑13幢104',87,'Bonnie '),
('13201','竹苑13幢201',88,'Becky '),
('13202','竹苑13幢202',58,'Betty '),
('13203','竹苑13幢203',97,'Brenda '),
('13204','竹苑13幢204',77,'Candice '),
('13301','竹苑13幢301',79,'Carrie '),
('13302','竹苑13幢302',92,'Cathy '),
('13303','竹苑13幢303',92,'Demi '),
('13304','竹苑13幢304',92,'Doona '),
('14101','竹苑14幢101',70,'Swift '),
('14102','竹苑14幢102',70,'April '),
('14103','竹苑14幢103',60,'Aviva '),
('14104','竹苑14幢104',87,'Bonnie '),
('14201','竹苑14幢201',88,'Becky '),
('14202','竹苑14幢202',58,'Betty '),
('14203','竹苑14幢203',97,'Brenda '),
('14204','竹苑14幢204',77,'Candice '),
('14301','竹苑14幢301',79,'Carrie '),
('14302','竹苑14幢302',92,'Cathy '),
('14303','竹苑14幢303',92,'Demi '),
('14304','竹苑14幢304',92,'Doona '),
('15101','竹苑15幢101',56,'Deed '),
('15102','竹苑15幢102',87,'Ameria '),
('15103','竹苑15幢103',60,'Amanda '),
('15104','竹苑15幢104',87,'Obama '),
('15201','竹苑15幢201',88,'Leborn '),
('15202','竹苑15幢202',58,'Kary '),
('15203','竹苑15幢203',68,'Curry '),
('15204','竹苑15幢204',77,'Durant '),
('15301','竹苑15幢301',79,'Jeremony '),
('15302','竹苑15幢302',92,'George '),
('15303','竹苑15幢303',92,'Harden '),
('15304','竹苑15幢304',92,'Howard ');
             
    
-- test table
SELECT * FROM  Dormitory;
SELECT dorId, address, points FROM Dormitory WHERE points<60 order by points;
delete  from Dormitory  where dorId=07304     ;       











-- create table deduction_record
create table deduction_record(
id int(11) unsigned not null auto_increment,
dorId varchar(20) default null,
time varchar(40) default null,
reason varchar(100) default null,
points int(11) default null ,
primary key (id))
engine = InnoDB
default charset =utf8;


-- insert test record
insert into deduction_record(dorId,time,reason,points)
			values('10304','The 3rd week','Ground is dity',5),
				  ('10201','The 4th week','other: dddd',5);
-- query table 
SELECT dorId,time,reason,points FROM  deduction_record order by time DESC;


















-- create table admin
create table admin(
id int(11) unsigned not null  auto_increment,
name varchar(20) default null,
password varchar(100) default null,
primary key (id))
engine = InnoDB
default charset =utf8;

-- insert test record
insert into admin(name,password)
			values('admin1','admin1'),
				  ('admin2','admin2');
-- query table 
SELECT * FROM  admin;
SELECT * FROM  admin WHERE name='admin1' AND password='admin1';


-- update tbale 
UPDATE admin SET password='admin12222' WHERE name='admin1';
UPDATE admin SET password=? WHERE name=?;








-- sql usage demo
alter table  Dormitory add  address varchar(20) default null;
alter table  Dormitory change points points varchar(20) default null;
UPDATE Dormitory SET points=points-10 WHERE dorId='uuu15304';
SELECT * FROM  Dormitory WHERE dorId='C15304';
SELECT dorId, time, reason, points FROM deduction_record WHERE dorId='C15304';
SELECT dorId, points FROM Dormitory ORDER BY points;
delete from  Dormitory where dorId='15304';
SELECT points FROM  Dormitory WHERE dorId='15304'
                  
