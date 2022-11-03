package test;
import java.sql.*;
import java.util.*;
public class RetrieveDAO 
{
 public  ArrayList<EmployeeBean> al=new ArrayList<EmployeeBean>();
 public   ArrayList<EmployeeBean> view()
 {
	 try
	 {
        Connection con=DBConnection.getConn();
        PreparedStatement ps=con.prepareCall
        		("Select*from Employee48");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        	EmployeeBean eb=new EmployeeBean();
        	eb.setId(rs.getString(1));
        	eb.setName(rs.getString(2));
        	eb.setDesg(rs.getString(3));
        	eb.setbSal(rs.getInt(4));
        	eb.settSal(rs.getFloat(5));
        	al.add(eb);
        }
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return al;
 }
}
