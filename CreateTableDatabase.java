//Creating a Table
import java.sql.*;

public class CreateTableDatabase{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String TableName;
		try{
			String userName = "root";
			String password = "root";
			String  url ="jdbc:mysql://localhost:3306/test";
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,userName,password);
			
			stmt=conn.createStatement();
			stmt.execute("show tables");
			rs=stmt.getResultSet();
			System.out.println("Result before creating the Table ");
			while(rs.next()){
				TableName=rs.getString("javacource"); //To create Table having name JavaCource
				
				System.out.println("Tabale name: ="+TableName+"\n");
			}
			stmt.execute("create table javacource(RollName Integer primary key,Name Varchar(30),Marks Integer not null,Grade Varchar(2))");
			
			stmt.execute("show tables");
			rs=stmt.getResultSet();
			System.out.println("Result after in the Table \n");
			while(rs.next()){
				TableName=rs.getString("MyTable");
				System.out.println("Table Name: "+TableName+"\n");
			}
		}catch(SQLException ex){
			System.out.println("SQLException: "+ex.getMessage());
			System.out.println("SQLState: "+ex.getSQLState());
			System.out.println("VenderError: "+ex.getErrorCode());
		}
		catch(Exception e){
			System.err.println("cannot connect to database server ");
		}
		finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException sqlEx){
				}
				rs=null;
			}
			if(stmt!=null){
				try{
					stmt.close();
				}catch(SQLException sqlEx){
				}
				stmt=null;
			}
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
				}
			}
		}
	}
}