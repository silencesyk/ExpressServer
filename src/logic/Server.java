package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import logicservice.ServerService;

public class Server implements ServerService{

	private int port=4700;
	private ServerSocket server=null;
	private static Socket socket=null;
	private String message=null;
	
	
	@Override
	public void init() throws IOException {
		//服务器初始化
		server=new ServerSocket(port);
		System.out.println("-------------Server run----------------");
		socket=server.accept();
	}

	@Override
	public void sendMessage(String msg) {
		// 服务器发送信息
		if(socket!=null){
			
			try {
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				out.println(msg);
				out.flush();
				socket=server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getMessage() {
		// 服务器接受信息
		if(socket!=null){
			try {
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				message=in.readLine();
				System.out.println("get message: "+message);
				return message;
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return null;
	}
	

}
