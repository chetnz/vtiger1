package JDBCCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class UpdateQuery {
	@Test
	public void updateQueryTest() throws Throwable
	{
		Connection con=null;
		
		try {
			
		
	 Driver dref=new Driver();
	 DriverManager.registerDriver(dref);
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	 Statement stmt = con.createStatement();
	 int rowEffected = stmt.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('5', 'dam','mehta', 't');");
	 if(rowEffected==1)
	 {
		 System.out.println(rowEffected+" rows effected, insertion succesful");
	 }
	 else
	 {
		 System.out.println("insertion unsuccesful");
	 } 
	 
		}
		catch(Exception e)
		{
			//System.out.println("SQL Exception");
		}
		finally
		{
			con.close();
		}
	}

}
