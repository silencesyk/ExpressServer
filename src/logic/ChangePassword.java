package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicservice.DataBaseService;
import data.Database;


public class ChangePassword {
	private String info[];
	public ChangePassword(String info[]){
		this.info=info;
	}
	public boolean handle(){
		boolean flag=false;
		PreparedStatement pstmt;
		DataBaseService dbs=new Database();
	    Connection connect=dbs.connect();
	    try {
			pstmt = connect.prepareStatement("Select * from user where uname =  ?");
		
	      pstmt.setString(1, info[1]);
	      ResultSet rs = pstmt.executeQuery();
	      if(rs == null){
	    	  return false;
	      }
	      while(rs.next()){
	    	  
	    	  if(rs.getString("password").equals(info[2])){
	    		  pstmt = connect.prepareStatement("update user set password=?  where uname=?");
	    		  pstmt.setString(1, info[3]);
	    		  pstmt.setString(2, info[1]);
	    		  if(pstmt.executeUpdate()>0)
	    			  flag=true;
	    	  }
	    	  
	      }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		
		return flag;
	}
	
	
	
}
