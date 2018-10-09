package datastore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.HomeBean;
import beans.UserBean;
import beans.BookingBean;
import beans.MessageBean;

public class Datastore {

	private static Datastore single_instance = null;

	public List<HomeBean> listOfHomes = new ArrayList<HomeBean>();
	public List<BookingBean> listOfBookings = new ArrayList<BookingBean>();
	public List<UserBean> listOfUsers = new ArrayList<UserBean>();
	public List<MessageBean> listOfMessages = new ArrayList<MessageBean>();

	private Datastore() {
		HomeBean home1 = new HomeBean(0, "Name1", "Long description", "Short description", 0, 5, null, 500, new Date(),
				new Date());
		HomeBean home2 = new HomeBean(1, "Name2", "Long description", "Short description", 0, 5, null, 1000, new Date(),
				new Date());
		HomeBean home3 = new HomeBean(2, "Name3", "Long description", "Short description", 0, 5, null, 1500, new Date(),
				new Date());
		HomeBean home4 = new HomeBean(3, "Name4", "Long description", "Short description", 0, 5, null, 2000, new Date(),
				new Date());
		HomeBean home5 = new HomeBean(4, "Name5", "Long description", "Short description", 0, 5, null, 2500, new Date(),
				new Date());

		listOfHomes.add(home1);
		listOfHomes.add(home2);
		listOfHomes.add(home3);
		listOfHomes.add(home4);
		listOfHomes.add(home5);
		
		BookingBean booking1 = new BookingBean(0, home1, new Date(), new Date(), new Date(), "123456");
		BookingBean booking2 = new BookingBean(1, home2, new Date(), new Date(), new Date(), "546548");
		
		listOfBookings.add(booking1);
		listOfBookings.add(booking2);
		
		UserBean user1 = new UserBean(0, "Morten", "Stulen", "stulenmorten@gmail.com", "password", new Date(), 1);
		UserBean user2 = new UserBean(1, "John", "Legend", "johnLegend@gmail.com", "password", new Date(), 0);
		UserBean user3 = new UserBean(2, "Peter", "Parker", "peterparker@gmail.com", "password", new Date(), 0);
		UserBean user4 = new UserBean(3, "John", "Cena", "johncena@gmail.com", "password", new Date(), 0);
		
		listOfUsers.add(user1);
		listOfUsers.add(user2);
		listOfUsers.add(user3);
		listOfUsers.add(user4);
		
		MessageBean message1 = new MessageBean(0, "Here is a message from user 1 to user 2", new Date(), 1, 2);
		MessageBean message2 = new MessageBean(1, "Here is a reply from user 2 to user 1", new Date(), 2, 1);
		MessageBean message3 = new MessageBean(2, "Here is a message from 1 to 2 that should be read.", new Date(), 1, 2);
		message3.setMessage_Read(true);
		
		listOfMessages.add(message1);
		listOfMessages.add(message2);
		listOfMessages.add(message3);

	}

	public static Datastore getInstance() {
		if (single_instance == null)
			single_instance = new Datastore();
		return single_instance;
	}

	public List<HomeBean> getHomes() {
		return (List<HomeBean>) listOfHomes;
	}
	
	public List<BookingBean> getBookings() {
		return (List<BookingBean>) listOfBookings;
	}
	
	public List<UserBean> getUsers() {
		return (List<UserBean>) listOfUsers;
	}
	
	public List<MessageBean> getMessages() {
		return (List<MessageBean>) listOfMessages;
	}
	
	public HomeBean getHome(int id) {
		return listOfHomes.get(id);
	}

	
}
