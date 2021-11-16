package JDBCCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class VerifyDataFromDb {
	@Test
	public void verifyDataFromDBTest() throws Throwable
	{
		Connection con = null;
		try {
		String expectedData = "ram";
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		Statement stmt = con.createStatement();
		 ResultSet res = stmt.executeQuery("select * from students_info;");
		
		boolean flag=false;
		while(res.next())
		{
			String actualData = res.getString(2);
		if(actualData.equals(expectedData))	
		{
		System.out.println(actualData+" is available.");
		flag=true;
		break;
		
		}
		Assert.assertEquals(flag, true);
		}}
		catch(Exception e)
		{
			System.out.println("SQL Exception");
		}
		finally
		{
			con.close();
			System.out.println("===========Connection Closed===============");
		}
	}

	
}
