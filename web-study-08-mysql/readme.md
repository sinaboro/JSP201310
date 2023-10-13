create table member(
    name varchar2(20) ,
    userid VARCHAR2(10),
    pwd VARCHAR2(10),
    email VARCHAR2(20),
    phone char(13),
    admin NUMBER(1) default 0, -- 0:사용자, 1:관리자
    primary key(userid)
);

insert into member(name, userid, pwd, email, phone, admin) 
values('이소미', 'somi2', '1234', 'gmd@naver.com', '010-111-2222', 0);

insert into member values('하상우', 'sang12', '1234', 'aaa@naver.com', '010-222-3333', 1);

insert into member values('김윤승', 'light', '1234', 'bbb@naver.com', '010-3333-4444', 0);

select * from member;