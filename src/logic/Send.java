package logic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import logicservice.DataBaseService;
import data.Database;

public class Send {
	String info[];
	public Send(String [] info){
		this.info=info;
	}
	public boolean hanle(){
		boolean flag=false;
		PreparedStatement pstmt;
		DataBaseService dbs=new Database();
	    Connection connect=dbs.connect();
	    try {
			pstmt = connect.prepareStatement("insert into list(sname,scity,scityadd,sphone,type,gname,"
					+ "gcity,gcityadd,gphone,number,weight,volume,goodsname,wrap,lid,price) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
	      for(int i=1;i<=16;i++)
	    	  pstmt.setString(i, info[i]);
	      if(pstmt.executeUpdate()>0){
	    	  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	  pstmt = connect.prepareStatement("insert into status(lid,status)values(?,?)");
	    	  pstmt.setString(1, info[15]);
	    	  pstmt.setString(2, "send from "+info[2]+info[3]+" at "+df.format(new java.util.Date())+" by "+info[1]);
	    	  if(pstmt.executeUpdate()>0)
	    		  flag=true;
	      }
	      return flag;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
}
