package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userid;

	private byte admin;

	private String email;

	private String name;

	private String password;

	private String surname;

	private List<Booking> bookings;

	private List<Home> homes;

	private List<Message> messages1;

	private List<Message> messages2;
	
	public String toString() {
		return this.name +" "+ this.surname;
	}

	public User() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public byte getAdmin() {
		return this.admin;
	}

	public void setAdmin(byte admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setGuest(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setGuest(null);

		return booking;
	}

	public List<Home> getHomes() {
		return this.homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	public Home addHome(Home home) {
		getHomes().add(home);
		home.setUser(this);

		return home;
	}

	public Home removeHome(Home home) {
		getHomes().remove(home);
		home.setUser(null);

		return home;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setSender(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setSender(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setReciever(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setReciever(null);

		return messages2;
	}

}