package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;



public class DataBaseConnection {
	
	@Test
	public void dbConnection() throws Exception{
		
		String dbURL = "jdbc:mysql://localhost:3306/sakila";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "ApoloGP9508";
		
		//Class.forName(driver);
		Connection con = DriverManager.getConnection(dbURL, userName, password);
		
		Statement  st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from address limit 10");
		while(rs.next()) {
			System.out.println("Address = " + rs.getString("address"));
		}
		//st.executeUpdate("update address set address = 'Transvesal 28 # 53b -42 apto 201' where address_id = 1");
		st.executeUpdate("update address set phone = 3228856119 where address_id = 1");
		st.close();
		
		
	}

}
