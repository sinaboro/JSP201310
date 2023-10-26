
 --------------------------
 MySQL
 --------------------------
 create table board(
    num int  auto_increment primary key,
    pass VARCHAR(30) not null,
    name VARCHAR(30) not null,
    email VARCHAR(30),
    title VARCHAR(50),
    content VARCHAR(1000),
    readcount int DEFAULT 0,
    writedate date default (current_date)
 );
 
 select * from board;
 
 insert into board(num, name, email, pass,title, content) 
 values(null, '성윤정', 'pink@name.com', '1234', '첫방문', '반갑습니다');
  
 insert into board(num, name, email, pass,title, content) 
 values(null, '조조', 'java@name.com', '1234', '삼국지', '반갑습니다');
 commit;
 
 
 # 커넥션 풀 : ezen는 본인 데이타베이스

Server.xml 등록
<Resource name="jdbc/TestDB" auth="Container" type="javax.sql.DataSource"
  maxTotal="100" maxIdle="30" maxWaitMillis="10000"
  username="test" password="1234" driverClassName="com.mysql.jdbc.Driver"
  url="jdbc:mysql://localhost:3306/ezen"/>
  

--connection 연결  
public static Connection getConnection() throws SQLException {
	Connection conn = null;
	try {
		Context initContext = new InitialContext();
		DataSource ds;
		ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/TestDB");
		conn = ds.getConnection();
	} catch (NamingException e) {
		e.printStackTrace();
	}
	return conn;
}
  
 