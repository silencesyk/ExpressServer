package logic;

import java.io.IOException;
import java.net.Socket;

import po.MessagePo;
import data.Database;
import logicservice.ServerService;

public class Driver {
		
		private static ServerService server;
		private Socket socket;
	
	
		public static void main(String args[]) throws IOException{
			server=new Server();
			Database db=new Database();
			db.connect();
			server.init();
			while(true){
				String msg=server.getMessage();
				MessagePo po=new MessagePo(msg);
				server.sendMessage(po.analyseMessage());
			}
		}
		

}
