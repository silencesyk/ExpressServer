package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicservice.DataBaseService;
import data.Database;

public class Get {
	private String info[];
	public Get(String info[]){
		this.info=info;
	}
	public boolean handle(){
		boolean flag=false;
		PreparedStatement pstmt;
	    DataBaseService dbs=new Database();
	    Connection connect=dbs.connect();
		try {
			pstmt = connect.prepareStatement("Select * from list where lid =  ?");
	      pstmt.setString(1, info[2]);
	      ResultSet rs =  pstmt.executeQuery();
	      if(!rs.next()){
	    	  return flag;
	      }
	      else {
	    	  pstmt = connect.prepareStatement("insert into status(lid,status)values(?,?)");
	    	  pstmt.setString(1, info[2]);
	    	  pstmt.setString(2, "get on "+info[4]+" at "+info[3]+" by "+info[1]);
	    	  if(pstmt.executeUpdate()>0){
	    		  pstmt = connect.prepareStatement("delete  from list where lid =  ?");
	    		  pstmt.setString(1, info[2]);
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
