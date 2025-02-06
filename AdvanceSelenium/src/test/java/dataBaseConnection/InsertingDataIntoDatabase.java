package dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertingDataIntoDatabase {
	public static void main(String[] args) throws Throwable {

		//step1:- Register/load 
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		//step2:- connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_bookings", "root", "root");

		//step3:- create SQL statement
		Statement statement = conn.createStatement();
		String Query = "insert into booking(first_name,last_name,address)values('Ganesh','Chelpuri','Warangal')";
		
		//step4:- execute query
		int result = statement.executeUpdate(Query);
		

		if(result == 1) {
			System.out.println("Data created successfully");
		}
		else {
			System.out.println("Data not created");
		}
		
		// step5:- close DataBAse
		conn.close();

	}
}
