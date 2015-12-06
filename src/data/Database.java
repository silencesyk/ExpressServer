package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
		private Connection  connect;
	
	
		public void connect(){
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
				          "jdbc:mysql://localhost:3306/expresssystem","root","123456");
				System.out.println("connect ExpressSystem success");
			} catch (SQLException e) {
				System.out.println("connect ExpressSystem error");
				e.printStackTrace();
			}
			 
			 
			 
		}
		public boolean isLogin(String uname,String password,String identity){
		      PreparedStatement pstmt;
			try {
				pstmt = connect.prepareStatement("Select * from user where name =  ?");
			
		      pstmt.setString(1, uname);
		      ResultSet rs = pstmt.executeQuery();
		      if(rs == null){
		    	  return false;
		      }
		      while(rs.next()){
		    	  
		    	  if(rs.getString("password").equals(password)&&rs.getString("identity").equals(identity)){
		    		  return true;
		    	  }
		      }
		      return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
}
