import java.sql.*;

public class Connect{
	public static void main(String[] args){
		Connection conn = null;
		try{
			String userName="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/test";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection(url,userName,password);
			
			System.out.println("Database Connected estabilished");
		}
		catch(Exception e){
			System.err.println("Cannot connected to database Server ");
		}
		finally{
			if(conn!=null){
				try{
					conn.close();
					System.out.println("Database Connection Terminated ");
				}catch(Exception e){} //ignore close error
			}
		}
	}
}