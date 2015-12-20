package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicservice.DataBaseService;

public class Database implements DataBaseService{
	
	
	
		public Connection connect(){
			Connection connect = null;
			 try {
			      Class.forName("com.mysql.jdbc.Driver");     
			     System.out.println("Success loading Mysql Driver!");
			    }
			    catch (Exception e) {
			      System.out.println("Error loading Mysql Driver!");
			      e.printStackTrace();
			    }
			 try {
				 connect = DriverManager.getConnection(
				          "jdbc:mysql://localhost:3306/expresssystem?useUnicode=true&characterEncoding=utf-8","root","123456");
				System.out.println("connect ExpressSystem success");
			} catch (SQLException e) {
				System.out.println("connect ExpressSystem error");
				e.printStackTrace();
			}
			 
			 return connect;
			 
		}

}
