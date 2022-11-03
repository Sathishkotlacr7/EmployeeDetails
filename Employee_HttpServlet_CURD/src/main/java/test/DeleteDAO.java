package test;
import java.sql.*;
public class DeleteDAO
{
 public int k=0;
 public int delete(EmployeeBean eb)
 {
	 try
	 {
		 Connection con=DBConnection.getConn();
		 PreparedStatement ps=con.prepareStatement
				 ("delete from employee48 where empid=?");
		 ps.setString(1, eb.getId());
		 k=ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return k;
 }
}
