package datastore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.HomeBean;
import beans.BookingBean;

public class Datastore {

	private static List<HomeBean> listOfHomes = new ArrayList<HomeBean>();
	private static List<BookingBean> listOfBookings = new ArrayList<BookingBean>();
	
	public Datastore() {
		HomeBean home1 = new HomeBean(0, "Name1", "Long description", "Short description", 0, 5, null, 500, new Date(), new Date());
		HomeBean home2 = new HomeBean(1, "Name2", "Long description", "Short description", 0, 5, null, 1000, new Date(), new Date());
		HomeBean home3 = new HomeBean(2, "Name3", "Long description", "Short description", 0, 5, null, 1500, new Date(), new Date());
		HomeBean home4 = new HomeBean(3, "Name4", "Long description", "Short description", 0, 5, null, 2000, new Date(), new Date());
		HomeBean home5 = new HomeBean(4, "Name5", "Long description", "Short description", 0, 5, null, 2500, new Date(), new Date());
		
		listOfHomes.add(home1);
		listOfHomes.add(home2);
		listOfHomes.add(home3);
		listOfHomes.add(home4);
		listOfHomes.add(home5);
		
		BookingBean booking1 = new BookingBean(0, home1, new Date(), new Date(), new Date(), "123456");
		BookingBean booking2 = new BookingBean(0, home2, new Date(), new Date(), new Date(), "546548");
		
		listOfBookings.add(booking1);
		listOfBookings.add(booking2);
	}

	public List<HomeBean> getHomes() {
		return (List<HomeBean>) listOfHomes;
	}
	
	public List<BookingBean> getBookings() {
		return (List<BookingBean>) listOfBookings;
	}

}
