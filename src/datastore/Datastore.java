package datastore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import beans.Home;
import beans.UserBean;
import beans.BookingBean;
import beans.MessageBean;

public class Datastore {

//    @PersistenceContext(unitName = "fakebnb")
//	private EntityManager entityManager;
//    
//    @Resource
//    UserTransaction ut;

	private EntityManager entityManager;

	private static Datastore single_instance = null;

	public List<Home> listOfHomes = new ArrayList<Home>();
	public List<BookingBean> listOfBookings = new ArrayList<BookingBean>();
	public List<UserBean> listOfUsers = new ArrayList<UserBean>();
	public List<MessageBean> listOfMessages = new ArrayList<MessageBean>();

	private Datastore() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fakebnb");
		entityManager = factory.createEntityManager();

		Home home1 = new Home(0, "Name1", "Long description", "Short description", 0, 5, null, 500, new Date(),
				new Date());
		Home home2 = new Home(1, "Name2", "Long description", "Short description", 0, 5, null, 1000, new Date(),
				new Date());
		Home home3 = new Home(2, "Name3", "Long description", "Short description", 0, 5, null, 1500, new Date(),
				new Date());
		Home home4 = new Home(3, "Name4", "Long description", "Short description", 0, 5, null, 2000, new Date(),
				new Date());
		Home home5 = new Home(4, "Name5", "Long description", "Short description", 0, 5, null, 2500, new Date(),
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
		MessageBean message3 = new MessageBean(2, "Here is a message from 1 to 2 that should be read.", new Date(), 1,
				2);
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

	public List<Home> getHomes() {

//		Home home1 = new Home(0, "Name1", "Long description", "Short description", 0, 5, null, 500, new Date(),
//				new Date());
//		
//		ut.begin();
//		entityManager.persist(home1);
//		ut.commit();
//
//		entityManager.close();

		List<Home> homes = getAllHomes();
		for (Home home : homes) {
			System.out.println(home.getName());
		}

		return homes;
	}

	public List<Home> getAllHomes() {
		Query query = entityManager.createQuery("SELECT h FROM Home h");
		return query.getResultList();
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

	public Home getHome(int id) {
		return listOfHomes.get(id);
	}

}
