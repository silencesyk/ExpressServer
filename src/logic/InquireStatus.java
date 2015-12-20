package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicservice.DataBaseService;
import data.Database;

public class InquireStatus {
	private String [] info;
	public InquireStatus(String[]  info){
		this.info=info;
	}
	public String handle(){
		String flag="";
		PreparedStatement pstmt;
	      DataBaseService dbs=new Database();
	      Connection connect=dbs.connect();
		try {
			pstmt = connect.prepareStatement("Select * from status where lid =  ?");
		
	      pstmt.setString(1, info[1]);
	      ResultSet rs = pstmt.executeQuery();
	      /*if(!rs.next()){
	    	  return "不存在此快递信息";
	      }*/
	      while(rs.next()){
	    	  flag+=rs.getString("status")+"/n";
	      }
	      
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	
	
}
