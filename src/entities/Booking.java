package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	private int bookingid;

	private String card_number;

	private Date date_booking;

	private Date date_end;

	private Date date_start;

	private Home home;

	private User host;

	private User guest;
	
	private int confirmed;

	public Booking() {
	}

	public int getBookingid() {
		return this.bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	
	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public Date getDate_booking() {
		return date_booking;
	}

	public void setDate_booking(Date date_booking) {
		this.date_booking = date_booking;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public User getGuest() {
		return guest;
	}

	public void setGuest(User guest) {
		this.guest = guest;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}


	



}