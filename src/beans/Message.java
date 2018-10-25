package beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "Message")
public class Message {
	@Id
	@GeneratedValue
	private int messageId;
	private String text;
	private Date time_stamp;
	private int user_senderid;
	private int user_recieverid;
	@Transient 
	private boolean message_read;
	
	public Message(){
		
	}

	public Message(int messageId, String text, Date time_Stamp, int user_SenderId, int user_ReceiverId) {
		this.messageId = messageId;
		this.text = text;
		this.time_stamp = time_Stamp;
		this.user_senderid = user_SenderId;
		this.user_recieverid = user_ReceiverId;
		this.message_read = false;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTime_Stamp() {
		return time_stamp;
	}

	public void setTime_Stamp(Date time_Stamp) {
		this.time_stamp = time_Stamp;
	}

	public int getUser_SenderId() {
		return user_senderid;
	}

	public void setUser_SenderId(int user_SenderId) {
		this.user_senderid = user_SenderId;
	}

	public int getUser_ReceiverId() {
		return user_recieverid;
	}

	public void setUser_ReceiverId(int user_ReceiverId) {
		this.user_recieverid = user_ReceiverId;
	}

	public boolean getMessage_Read() {
		return message_read;
	}

	public void setMessage_Read(boolean message_Read) {
		this.message_read = message_Read;
	}

}
