package logic;

import java.io.IOException;

public interface Server {
		public void init() throws IOException;
		public void sendMessage(String msg) ;
		public String getMessage();
}
