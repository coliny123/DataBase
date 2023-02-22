create database malldb;

use malldb;

#Primary key는 1개 or 여러 개의 col로 행들을 구별한다. 
#자체만으로 Unique 하며 만약 여러 개의 Column이 PK로 묶여 있다면, 해당 값들의 조합이 반드시 Unique 해지게 된다.
#NULL 값을 갖을 수 없고, Unique key. => NOT NULL & UNIQUE == PK 라고 생각하면 편하다. 

create table userTbl  						#mysql은 대소문자 구별 x 
( userID char(8) not null primary key,  	
name varchar(10) not null, 					#가변적으로 최대 10자리까지 넣을 수 있다
birthYear int not null,  
addr char(2) not null,
mobile1 char(3) not null,
mobile2 char(8) not null,
height smallint,  							#smallint는 2byte짜리 정수
mDate date);

select * 
from userTbl;

select name, userID 
from userTbl;   # select 뒤에 (col이름,~,~)이 아니라 바로 쓰면됨

# userTbl에 다 넣으려면 테이블이름(~~,~~) 괄호 생략가능
insert into userTbl values('LSG',   		#sql에서 문자열은 무조건 ''ㅇ, ""x
'이승기', 1957, '서울', '010', 
'12345678', 182, '2008-8-8');

insert into userTbl values('KBS',
'김범수', 1979, '경남', '010', 
'87654321', 170, '2011-7-12');

insert into userTbl values('KDH',
'김도환', 1999, '인천', '010', 
'95239895', 174, '2022-11-11');

select * from userTbl;

DROP TABLE buyTbl;
commit;

create table buyTbl
( num int auto_increment not null primary key,
	userID char(8) not null,
    prodName char(6) not null,
    groupName char(4),
    price int not null,
    amount smallint not null,
    foreign key(userID)  					# 두 table간에 공통된 키; userTbl에서는 primary key, buTbl에서는 foreign key
		REFERENCES userTbl(userID)
    );
    
insert into userTbl  values('JYP', '조용필', 1950, '경기', '011', '44444444', 166, '2009-4-4');
insert into userTbl  values('SSK', '성시경', 1979, '서울', '010', '12345678', 186, '2013-12-12');
insert into userTbl  values('LJB', '임재범', 1963, '서울', '016', '66666666', 182, '2009-9-9');
insert into userTbl  values('YJS', '윤종신', 1969, '경남', '010', '12345678', 170, '2005-5-5');
insert into userTbl  values('EJW', '은지원', 1972, '경북', '011', '88888888', 174, '2014-3-3');
insert into userTbl  values('JKW', '조관우', 1965, '경기', '018', '99999999', 172, '2010-10-10');
insert into userTbl  values('BBK', '비비킴', 1973, '서울', '010', '00000000', 176, '2013-5-5');

commit;

select * from userTbl;

insert into buyTbl  values(NULL, 'KBS', '운동화', NULL, 30, 2);
insert into buyTbl  values(NULL, 'KBS', '노트북', '전자', 1000, 1);
insert into buyTbl  values(NULL, 'JYP', '모니터', '전자', 200, 1);
insert into buyTbl  values(NULL, 'BBK', '모니터', '전자', 200, 5);
insert into buyTbl  values(NULL, 'KBS', '청바지', '의류', 50, 3);
insert into buyTbl  values(NULL, 'BBK', '메모리', '전자', 80, 10);
insert into buyTbl  values(NULL, 'SSK', '책', '서적', 15, 5);
insert into buyTbl  values(NULL, 'EJW', '책', '서적', 15, 2);
insert into buyTbl  values(NULL, 'EJW', '청바지', '의류', 50, 1);
insert into buyTbl  values(NULL, 'BBK', '운동화', NULL, 30, 2);
insert into buyTbl  values(NULL, 'EJW', '책', '서적', 15, 1);
insert into buyTbl  values(NULL, 'BBK', '운동화', NULL, 30, 2);

commit;

select * from buyTbl;