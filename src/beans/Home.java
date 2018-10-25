package beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Home {
	@Id
	@GeneratedValue
	private int homeid;
	private String name;
	private String full_description;
	private String short_description;
	private int type;
	private int number_of_guests;
	private String image;
	private int price;
	private Date date_available_start;
	private Date date_available_end;

	public Home() {

	}

	public Home(int homeid, String name, String full_description, String short_description, int type,
			int number_of_guests, String image, int price, Date date_available_start, Date date_available_end) {
		super();
		this.homeid = homeid;
		this.name = name;
		this.full_description = full_description;
		this.short_description = short_description;
		this.type = type;
		this.number_of_guests = number_of_guests;
		this.image = image;
		this.price = price;
		this.date_available_start = date_available_start;
		this.date_available_end = date_available_end;
	}

	public String toString() {
		return this.name;
	}

	public int getHomeid() {
		return homeid;
	}

	public void setHomeid(int homeid) {
		this.homeid = homeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_description() {
		return full_description;
	}

	public void setFull_description(String full_description) {
		this.full_description = full_description;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getNumber_of_guests() {
		return number_of_guests;
	}

	public void setNumber_of_guests(int number_of_guests) {
		this.number_of_guests = number_of_guests;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate_available_start() {
		return date_available_start;
	}

	public void setDate_available_start(Date date_available_start) {
		this.date_available_start = date_available_start;
	}

	public Date getDate_available_end() {
		return date_available_end;
	}

	public void setDate_available_end(Date date_available_end) {
		this.date_available_end = date_available_end;
	}

}
