package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DBTest {
	@Test
	public void databaseTest() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		String ename = sc.nextLine();
		boolean name=false;
        Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
				
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");		
		Statement state = con.createStatement();
		
		ResultSet result=state.executeQuery("select * from empinfo");
		
		while(result.next())
		
			
		   if(result.getString("empName").equals(ename)) {
				System.out.println("already present");
				name=false;
			}

         if(!name){
			String query="insert into empinfo value"+"('" +ename+ "')";
            int res=state.executeUpdate(query);     
            if(res!=0) {
        	 System.out.println("data inserted");
        }		
		
	}
		con.close();
}
		

}
