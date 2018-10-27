package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HOME database table.
 * 
 */
@Entity
@Table(name="HOME")
@NamedQuery(name="Home.findAll", query="SELECT h FROM Home h")
public class Home implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int homeid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_available_end")
	private Date dateAvailableEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_available_start")
	private Date dateAvailableStart;

	@Column(name="full_description")
	private String fullDescription;

	@Lob
	private byte[] image;

	private String name;

	@Column(name="number_of_guests")
	private int numberOfGuests;

	private int price;

	@Column(name="short_description")
	private String shortDescription;

	private int type;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="home1")
	private List<Booking> bookings1;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="home2")
	private List<Booking> bookings2;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Home() {
	}

	public int getHomeid() {
		return this.homeid;
	}

	public void setHomeid(int homeid) {
		this.homeid = homeid;
	}

	public Date getDateAvailableEnd() {
		return this.dateAvailableEnd;
	}

	public void setDateAvailableEnd(Date dateAvailableEnd) {
		this.dateAvailableEnd = dateAvailableEnd;
	}

	public Date getDateAvailableStart() {
		return this.dateAvailableStart;
	}

	public void setDateAvailableStart(Date dateAvailableStart) {
		this.dateAvailableStart = dateAvailableStart;
	}

	public String getFullDescription() {
		return this.fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfGuests() {
		return this.numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Booking> getBookings1() {
		return this.bookings1;
	}

	public void setBookings1(List<Booking> bookings1) {
		this.bookings1 = bookings1;
	}

	public Booking addBookings1(Booking bookings1) {
		getBookings1().add(bookings1);
		bookings1.setHome1(this);

		return bookings1;
	}

	public Booking removeBookings1(Booking bookings1) {
		getBookings1().remove(bookings1);
		bookings1.setHome1(null);

		return bookings1;
	}

	public List<Booking> getBookings2() {
		return this.bookings2;
	}

	public void setBookings2(List<Booking> bookings2) {
		this.bookings2 = bookings2;
	}

	public Booking addBookings2(Booking bookings2) {
		getBookings2().add(bookings2);
		bookings2.setHome2(this);

		return bookings2;
	}

	public Booking removeBookings2(Booking bookings2) {
		getBookings2().remove(bookings2);
		bookings2.setHome2(null);

		return bookings2;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}