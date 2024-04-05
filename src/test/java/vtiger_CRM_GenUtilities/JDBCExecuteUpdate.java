package vtiger_CRM_GenUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl", "root", "Mikumiku@1234");
		Statement state = con.createStatement();
		//int result = state.executeUpdate("create table champions(name varchar(100),trophy int,iplTrophy int,final int,playoffs int,winpercent int)");
		state.executeUpdate(" insert into champions(name,trophy,iplTrophy,final,playoffs,winpercent) values ('KKR',2,0,3,6,50);");
		System.out.println("Data added");
		/*if(result==1) {
			System.out.println("Data added");
		}
		
		con.close();*/

	}

}
