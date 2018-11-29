package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	private int messageid;

	private String text;

	private Date time_stamp;

	private User sender;

	private User reciever;
	 
	private boolean message_read;

	public Message() {
		this.message_read = false;
	}
	
	public String toString() {
		return this.text;
	}

	public int getMessageid() {
		return this.messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Date getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}


	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReciever() {
		return reciever;
	}

	public void setReciever(User reciever) {
		this.reciever = reciever;
	}

	public boolean isMessage_read() {
		return message_read;
	}

	public void setMessage_read(boolean message_read) {
		this.message_read = message_read;
	}
	
	

}