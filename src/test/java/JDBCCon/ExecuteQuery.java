package JDBCCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuery {
	@Test
	public void executeQueryTest() throws Throwable
	{
		//Register Database
		Driver dref = new Driver();
		//register driver
		DriverManager.registerDriver(dref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		//get the statement 
		Statement stmt = con.createStatement();
		//execute query
		ResultSet res = stmt.executeQuery("Select * from students_info;");
		while(res.next())
		{
			System.out.println(res.getInt(1)+"  "+res.getString(2)+"  "+res.getString(3));
		}
	}

}
