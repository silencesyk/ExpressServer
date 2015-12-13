package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Database;
import logicservice.DataBaseService;

public class Login {
	String uname,password,identity;
	
	public Login(String uname,String password,String identity){
		this.uname=uname;
		this.password=password;
		this.identity=identity;
	}
	
	public boolean isLogin(){
	      PreparedStatement pstmt;
	      DataBaseService dbs=new Database();
	      Connection connect=dbs.connect();
		try {
			pstmt = connect.prepareStatement("Select * from user where uname =  ?");
		
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
