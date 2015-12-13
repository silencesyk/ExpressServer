package logicservice;

import java.io.IOException;

public interface ServerService {
		public void init() throws IOException;
		public void sendMessage(String msg) ;
		public String getMessage();
}
