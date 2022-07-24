package demo;
import java.sql.*;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con=null;
	public static	Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			System.out.println("Driver class loaded");
con=DriverManager.getConnection("jdbc:mysql://localhost:3307/epproject?useSSL=false","root","sanDeep1@N");
			System.out.println("Connection Established Succesfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static void main(String [] args) {
		DBConnection dbconnection=new DBConnection();
		dbconnection.getConnection();
	}

}
