package test;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class AdminDAO implements Serializable
{
 public AdminBean ab=null;
 public AdminBean adminCheck(HttpServletRequest req)
 {
	 try
	 {
		 Connection con=DBConnection.getConn();
		 PreparedStatement ps=con.prepareStatement
				 ("Select * From Admin48 where username=? and password=?");
		 ps.setString(1, req.getParameter("uname"));
		 ps.setString(2, req.getParameter("pword"));
		 ResultSet rs=ps.executeQuery();
		 if(rs.next())
		 {
			 ab=new AdminBean();
			 ab.setuName(rs.getString(1));
			 ab.setpWord(rs.getString(2));
			 ab.setfName(rs.getString(3));
			 ab.setlName(rs.getString(4));
			 ab.setAddr(rs.getString(5));
			 ab.setMailId(rs.getString(6));
			 ab.setPhNO(rs.getLong(7));
		 }
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return ab;
 }
}
