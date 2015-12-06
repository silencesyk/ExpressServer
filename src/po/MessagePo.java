package po;

public class MessagePo {
	
	
	    private String message;
	    
	    public MessagePo(){
	    	
	    }
		public MessagePo(String msg){
			this.message=msg;
		}
		
		
		
		public String setLoginMessage(String uname,String password,String identity){
			message="login"+" "+uname+" "+password+" "+identity;
			return message;
		}
}
