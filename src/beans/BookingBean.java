package beans;

import java.util.Date;
import beans.Home;

public class BookingBean {
	private int bookingId;
	private Home home;
	private Date date_booking;
	private Date date_start;
	private Date date_end;
	private String card_number;
	
	public BookingBean(int bookingId,Home home,Date date_booking, Date date_start, Date date_end,String card_number) {
		super();
		this.bookingId = bookingId;
		this.home = home;
		this.date_booking = date_booking;
		this.date_start = date_start;
		this.date_end = date_end;
		this.card_number = card_number;
	}

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the home
	 */
	public Home getHome() {
		return home;
	}

	/**
	 * @param home the home to set
	 */
	public void setHome(Home home) {
		this.home = home;
	}

	/**
	 * @return the date_booking
	 */
	public Date getDate_booking() {
		return date_booking;
	}

	/**
	 * @param date_booking the date_booking to set
	 */
	public void setDate_booking(Date date_booking) {
		this.date_booking = date_booking;
	}

	/**
	 * @return the date_start
	 */
	public Date getDate_start() {
		return date_start;
	}

	/**
	 * @param date_start the date_start to set
	 */
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	/**
	 * @return the date_end
	 */
	public Date getDate_end() {
		return date_end;
	}

	/**
	 * @param date_end the date_end to set
	 */
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	/**
	 * @return the card_number
	 */
	public String getCard_number() {
		return card_number;
	}

	/**
	 * @param card_number the card_number to set
	 */
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
}
	