package Services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import ProjFrames.setIPform;

public class DBconn {
	
	private Connection conn;
	
	public Connection getDBconnection() {
		if(conn==null) {
			try {
				InputStream input = getClass().getClassLoader().getResourceAsStream("dbconfig.properties");
			      
			    Properties p=new Properties();  
			    p.load(input);
			    String usern = p.getProperty("username");
			    String passw = p.getProperty("password");
			    String portnum = p.getProperty("portnum");
			    String databn = p.getProperty("dbname");
				conn=(Connection) DriverManager.getConnection("jdbc:mysql://" + setIPform.ipadd + ":" + portnum + "/" + databn,usern,passw);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}

}
