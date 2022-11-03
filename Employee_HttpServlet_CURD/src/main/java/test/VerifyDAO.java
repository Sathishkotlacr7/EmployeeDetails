package test;
import java.sql.*;
import  javax.servlet.http.*;
public class VerifyDAO 
{
 public EmployeeBean eb=null;
 public EmployeeBean verify(HttpServletRequest req)
 {
	 try
	 {
		 Connection con=DBConnection.getConn();
		 PreparedStatement ps=con.prepareStatement
				 ("Select *from Employee48 where EMPid=?");
		ps.setString(1, req.getParameter("id"));
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			eb=new EmployeeBean();
			eb.setId(rs.getString(1));
			eb.setName(rs.getString(2));
			eb.setDesg(rs.getString(3));
			eb.setbSal(rs.getInt(4));
			eb.settSal(rs.getFloat(5));
		}
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return eb;
 }
}
