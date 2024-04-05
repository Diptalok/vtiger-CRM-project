package vtiger_CRM_GenUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl", "root", "Mikumiku@1234");
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("select * from champions");
		while(result.next()) {
			System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getInt(3)+"-"+result.getInt(4)+"-"+result.getInt(5));
		}
		
		con.close();
		
	}

}
