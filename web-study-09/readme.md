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