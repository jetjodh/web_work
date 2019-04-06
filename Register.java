import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("review"); 
String p="hello"; 

          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:3306:xe","system","oracle");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into jodh_review values(?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  

          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  