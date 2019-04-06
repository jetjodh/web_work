import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class BasicServlet extends HttpServlet {

static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/TEST";
static final String USER = "root";
static final String PASS = "root";
Statement stmt;
Connection conn;

public void init() throws ServletException {}
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.addHeader("Access-Control-Allow-Origin", "*");
response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
response.addHeader("Access-Control-Allow-Headers",
"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
response.addHeader("Access-Control-Max-Age", "1728000");
response.setContentType("application/json");
String name = null ,description=null ;
try {
Class.forName("com.mysql.jdbc.Driver");

conn = DriverManager.getConnection(DB_URL, USER, PASS);
stmt = conn.createStatement();
String sql;
sql = "SELECT id, name, description FROM Ngos";
ResultSet rs = stmt.executeQuery(sql);

while (rs.next()) {
int id = rs.getInt("id");
name = rs.getString("name");
description = rs.getString("description");
}
rs.close();
stmt.close();
conn.close();
} catch (SQLException se) {
se.printStackTrace();
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
if (stmt != null)
stmt.close();
} catch (SQLException se2) {
} 
try {
if (conn != null)
conn.close();
} catch (SQLException se) {
se.printStackTrace();
} 
}

PrintWriter out = response.getWriter();
String jsonResponse = "{" + "\"name\":" + "\"" + name +"\","+"\"description\":"+"\""+description+"\""+  "}";
System.out.println(jsonResponse);
out.println(jsonResponse);
}

public void destroy() {
/*
* leaving empty for now this can be used when we want to do something at the
* end of Servlet life cycle
*/
}
}