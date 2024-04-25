/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectivity;

/**
 *
 * @author HP
 */
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL="select userid from login_info where userid=? and password=?";
		try {
			con=CommonDAO.createConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,userDTO.getUserid()); //1st placeholder i.e. '?' will be the userid
			String encryptedPwd=Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setString(2, encryptedPwd);
			rs=pstmt.executeQuery();
			return rs.next();
//			if(rs.next()) {     //we didn't use this because rs.next() itself gives a boolean value
//				return true;
//			}
//			else {
//				return false;
//			}
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Connection connection=null;
		Statement stmt=null; //interface which is used for query
		
		try {    //Guarded Region
		connection=CommonDAO.createConnection(); //Step-1: Connection Created  //we made interface so we dont have to make object as made in classes
		//Step-2: we do a query
		stmt=connection.createStatement();
		// insert into users(userid,password) values('ram','ram123');
		int record=stmt.executeUpdate(" insert into login_info(userid,password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"')");  // Insert,Delete,Update
		System.out.print("Rec "+userDTO.getUserid()+" "+userDTO.getPassword());
		return record;
		}
		
		finally {  //always runs even when exception is raised and return is written before it....but not runs when System.exit() is used i.e. we will terminate the program/application
			if(stmt!=null) {
				stmt.close();
			}
			if(connection!=null) {
				connection.close();
			}
		}
	}

}
