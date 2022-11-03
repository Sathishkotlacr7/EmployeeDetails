package test;
import java.sql.*;
public class UpdateDAO
{
 public int k=0;
 public int update(EmployeeBean eb)
 {
	 try
	 {
		 Connection con=DBConnection.getConn();
		 PreparedStatement ps=con.prepareStatement
				 ("update employee48 set empname=?,empdesg=?,empbsal=?,emptsal=? where empid=?");
		 ps.setString(1, eb.getName());
		 ps.setString(2, eb.getDesg());
		 ps.setInt(3, eb.getbSal());
		 ps.setFloat(4, eb.gettSal());
		 ps.setString(5, eb.getId());
		 k=ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return k;
 }
}
