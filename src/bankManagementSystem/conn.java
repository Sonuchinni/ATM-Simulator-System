package bankManagementSystem;

import java.sql.*;

public class conn {

	Connection c;
	Statement s;
	
	public conn() {
		
		try {
			
//			Class.forName("com.mysql.cj.jdbc.Driver");
			 c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root",""); //Enter your password
			 s = c.createStatement();
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
	}
	
}