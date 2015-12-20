package po;

import java.io.ObjectInputStream.GetField;

import javax.swing.text.ChangedCharSetException;

import logic.ChangePassword;
import logic.Create;
import logic.Get;
import logic.InquireStatus;
import logic.Login;
import logic.Send;

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
				if(temp[0].equals("login")){//登录
						Login login=new Login(temp[1],temp[2],temp[3]);
						if(login.isLogin())
							return "login true";
						else 
							return "login false";
				}
				else if(temp[0].equals("inquire")){//查询快递状态
						InquireStatus inquire=new InquireStatus(temp);
						return inquire.handle();
				}
				else if(temp[0].equals("send")){//完成发件
						Send send=new Send(temp);
						if(send.hanle())
							return "发件成功";
						else 
							return "发件失败";
				}
				else if(temp[0].equals("create")){//创建用户
						Create create=new Create(temp);
						if(create.handle())
							return "创建成功";
						else 
							return "创建失败";
				}
				else if(temp[0].equals("change")){//修改密码
						ChangePassword cp=new ChangePassword(temp);
						if(cp.handle())
							return "修改成功";
						else 
							return "修改失败";
				}
				else if(temp[0].equals("get")){//完成收件
						Get get=new Get(temp);
						if(get.handle())
							return "完成收件";
						else 
							return "信息错误收件失败";
				}
				
				
			}
			return null;
		}
}
