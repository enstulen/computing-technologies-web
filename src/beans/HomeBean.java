package beans;

import java.util.Date;

public class HomeBean {
	private int id;
	private String name;
	private String full_description;
	private String short_description;
	private int type;
	private int number_of_guests;
	private String image_path;
	private int price;
	private Date date_available_start;
	private Date date_available_end;

	public HomeBean(int id, String name, String full_description, String short_description, int type,
			int number_of_guests, String image_path, int price, Date date_available_start, Date date_available_end) {
		super();
		this.id = id;
		this.name = name;
		this.full_description = full_description;
		this.short_description = short_description;
		this.type = type;
		this.number_of_guests = number_of_guests;
		this.image_path = image_path;
		this.price = price;
		this.date_available_start = date_available_start;
		this.date_available_end = date_available_end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
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
