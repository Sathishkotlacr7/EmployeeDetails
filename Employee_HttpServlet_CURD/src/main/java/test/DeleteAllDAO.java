package test;
import java.sql.*;
public class DeleteAllDAO 
{
 public int k=0;
 public int deleteAll()
 {
	 try
	 {
		Connection con=DBConnection.getConn();
		PreparedStatement ps=con.prepareStatement
				("delete from  EMPLOYEE48");
		k=ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return k;
 }
}
