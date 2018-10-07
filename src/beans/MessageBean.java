package beans;

import java.util.Date;

public class MessageBean {
	private int messageId;
	private String text;
	private Date time_Stamp;
	private int user_SenderId;
	private int user_ReceiverId;
	private boolean message_Read;

	public MessageBean(int messageId, String text, Date time_Stamp, int user_SenderId, int user_ReceiverId){
		this.messageId = messageId;
		this.text = text;
		this.time_Stamp = time_Stamp;
		this.user_SenderId = user_SenderId;
		this.user_ReceiverId = user_ReceiverId;
		this.message_Read = false;
	}
	
	public int getMessageId(){
		return messageId;
	}
	
	public void setMessageId(int messageId){
		this.messageId = messageId;
	}
	
	public String getText(){
		return text;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public Date getTime_Stamp(){
		return time_Stamp;
	}
	
	public void setTime_Stamp(Date time_Stamp){
		this.time_Stamp = time_Stamp;
	}
	
	public int getUser_SenderId(){
		return user_SenderId;
	}
	
	public void setUser_SenderId(int user_SenderId){
		this.user_SenderId = user_SenderId;
	}
	
	public int getUser_ReceiverId(){
		return user_ReceiverId;
	}
	
	public void setUser_ReceiverId(int user_ReceiverId){
		this.user_ReceiverId = user_ReceiverId;
	}
	
	public boolean getMessage_Read(){
		return message_Read;
	}
	
	public void setMessage_Read(boolean message_Read){
		this.message_Read = message_Read;
	}
	
	
}
