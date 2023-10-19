#테이블 
drop table employees;
create table employees(
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(30) ,
    lev char(1) default 'A',
    enter date default sysdate,
    gener char(1) default '1',
    phone varchar2(30),
    primary key(id)
);

insert into employees values('pinksung','1234','성윤정', 'A',sysdate,'2', '010-2222-3333');   
insert into employees values('subin','1234','전원지', 'B',sysdate,'2', '010-3333-2222');   
insert into employees values('admin','1234','정운영', 'A',sysdate,'1', '010-9999-8888'); 

commit;

select * from employees;


#커넥션 풀 설정

-server 적용
<Resource name="jdbc/myoracle" auth="Container"
type="javax.sql.DataSource"
driverClassName="oracle.jdbc.OracleDriver"
url="jdbc:oracle:thin:@127.0.0.1:1521:xe" username="scott"
password="tiger" maxTotal="20" maxIdle="10" maxWaitMillis="-1" />

-01_dbcp.jsp 적용
Context initContext = new InitialContext();
Context envContext  = (Context)initContext.lookup("java:/comp/env");
DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
Connection conn = ds.getConnection();
System.out.println("conn : " + conn);
//out.println("conn : " + conn);