package dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchingDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		
		//step1:- Register/load 
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2:- connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_bookings", "root", "root");
		
		//step3:- create SQL statement
		Statement statement = conn.createStatement();
		String Query = "select *from booking";
		//step4:- execute query
		ResultSet result = statement.executeQuery(Query);
		while(result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4));
		}

		// step5:- close DataBAse
		conn.close();
		
	}

}
