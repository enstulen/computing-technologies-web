package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BOOKING database table.
 * 
 */
@Entity
@Table(name="BOOKING")
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int bookingid;

	@Column(name="card_number")
	private String cardNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_booking")
	private Date dateBooking;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_end")
	private Date dateEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_start")
	private Date dateStart;

	//bi-directional many-to-one association to Home
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="home_homeid", referencedColumnName="homeid"),
		@JoinColumn(name="user_hostid", referencedColumnName="user_userid")
		})
	private Home home1;

	//bi-directional many-to-one association to Home
	@ManyToOne
	@JoinColumn(name="home_homeid")
	private Home home2;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_guestid")
	private User user;

	public Booking() {
	}

	public int getBookingid() {
		return this.bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getDateBooking() {
		return this.dateBooking;
	}

	public void setDateBooking(Date dateBooking) {
		this.dateBooking = dateBooking;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Home getHome1() {
		return this.home1;
	}

	public void setHome1(Home home1) {
		this.home1 = home1;
	}

	public Home getHome2() {
		return this.home2;
	}

	public void setHome2(Home home2) {
		this.home2 = home2;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}