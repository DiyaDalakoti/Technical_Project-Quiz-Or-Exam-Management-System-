/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectivity;

/**
 *
 * @author HP
 */
//use for creating connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CommonDAO {         //not class since we have to make its object everytime when we want to use CommomDAO
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		// Step-1 Load a driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step-2 Making a connection
		final String CONNECTION_STRING="jdbc:mysql://localhost:3306/chatdb";
		Connection con=DriverManager.getConnection(CONNECTION_STRING,"root","dlucky7");
		if(con!=null) {
			System.out.println("Connection Created...");
			//con.close();
		}
		return con;
	}

}
