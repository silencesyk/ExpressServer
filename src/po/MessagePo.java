package po;

import logic.Login;

public class MessagePo {
	
	
	    private String message;
	    
	    public MessagePo(){
	    	
	    }
	    
		public MessagePo(String msg){
			this.message=msg;
		}
		
		public void setMessage(String msg){
			this.message=msg;
		}
		
		public String analyseMessage(){
			if(message!=null){
				String[] temp=message.split(" ");
				if(temp[0].equals("login")){
						Login login=new Login(temp[1],temp[2],temp[3]);
						if(login.isLogin())
							return "login true";
						else 
							return "login false";
				}
				else if(temp[0].equals("inquire")){
						
				}
				
				
			}
			return null;
		}
}
