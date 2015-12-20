package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import logicservice.DataBaseService;
import data.Database;

public class Create {
	String info[];
	public Create(String [] info){
		this.info=info;
	}
	public boolean handle(){
		boolean flag=false;
		PreparedStatement pstmt;
		DataBaseService dbs=new Database();
	    Connection connect=dbs.connect();
	    try {
			pstmt = connect.prepareStatement("insert into user(uname,password,identity) values(?,?,?)");
		
	      for(int i=1;i<=3;i++)
	    	  pstmt.setString(i, info[i]);
	      if(pstmt.executeUpdate()>0)
	    		  flag=true;
	      return flag;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	
}
