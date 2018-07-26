package makemyportfolio.util.db;


import java.sql.*;

public class DataBaseUtil{ 
	private static boolean isLoaded =false;

	static {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded succefully");
			isLoaded=true;
		}catch(ClassNotFoundException e){
			isLoaded =false;
		}
	}


	private static String  url   = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String  user   = "system";
	private static String  password   = "root";


	public static Connection  getConnection() throws SQLException{
		if(!isLoaded){
			return null;
		}

		Connection con  = null;
		con  = DriverManager.getConnection(url,user,password);
		return  con;

	}

	public static void  closeConnection( Connection con) throws SQLException{
		if(con!=null){
			con.close();
		}

	}




}//End of class 
