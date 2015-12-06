package logic;

import java.io.IOException;

import data.Database;
import logicservice.ServerService;

public class Driver {
		
		private static Server server;
	
	
	
		public static void main(String args[]) throws IOException{
			server=new ServerService();
			Database db=new Database();
			db.connect();
			server.init();
		}
		
		public static void handleMessage(){
			String msg=server.getMessage();
		}
}
