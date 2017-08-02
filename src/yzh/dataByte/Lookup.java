package yzh.dataByte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Lookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbUrl = "jdbc:odbc:people";
		String user = "";
		String password = "";
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connection =(Connection) DriverManager.getConnection(dbUrl,user,password);
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT FIRST,LAST,EMAIL"
					+ "FROM people.csv people"
					+ "WHERE"
					+ "(LAST ='"+args[0]+"')"
					+ "AND(EMAIL Is Not Null)"
					+ "ORDER BY FIRST");
			while(resultSet.next()){
				System.out.println(resultSet.getString("Last")+ ","
						+resultSet.getString("first")+":"
						+resultSet.getString("EMAIL"));
			}
			statement.close();
		}catch(Exception e){
			e.printStackTrace();
			
			
		}
	}

}
