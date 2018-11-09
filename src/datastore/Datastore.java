package datastore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Home;
import entities.User;
import entities.Booking;
import entities.Message;

public class Datastore {

	public EntityManager entityManager;

	private static Datastore single_instance = null;

	public User currentUser;

	private Datastore() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fakebnb");
		entityManager = factory.createEntityManager();

		// This should be the actual current user, but for now we just use the first
		// user in DB
		// currentUser = entityManager.find(User.class, 1);

	}

	public static Datastore getInstance() {
		if (single_instance == null)
			single_instance = new Datastore();
		return single_instance;
	}

	// HOMES

	public List<Home> getHomes() {
		List<Home> homes = getAllHomes();
		return homes;
	}

	public List<Home> getAllHomes() {
		Query query = entityManager.createNamedQuery("Home.findAll", Home.class);
		return query.getResultList();
	}

	public void createNewHome(Home home) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(home);
		tx.commit();
	}

	public void updateHome(Home home) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(home);
		tx.commit();
	}

	public void deleteHome(int id) {
		Home home = entityManager.find(Home.class, id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(home);
		tx.commit();
	}

	public Home getHome(int id) {
		return entityManager.find(Home.class, id);
	}

	public List<Home> findHome(String name, Date start_date, Date end_date, int price, int type, int adults, int kids) {

		String queryString = "SELECT h FROM Home h WHERE LOWER(h.name) LIKE :pattern AND h.date_available_start<=:start_date AND h.date_available_end>=:end_date AND h.number_of_guests >= :number_of_guests";
		switch (price) {
		case 0:
			queryString = queryString;
			break;
		case 1:
			queryString = queryString + " AND h.price < 35";
			break;
		case 2:
			queryString = queryString + " AND h.price > 35 AND h.price < 69";
			break;
		case 3:
			queryString = queryString + " AND h.price > 70 AND h.price < 130";
			break;
		case 4:
			queryString = queryString + " AND h.price > 131";
			break;
		default:
			queryString = queryString;
			break;
		}

		Query query;
		String pattern = "%" + name.toLowerCase() + "%";
		int number_of_guests = adults + kids;

		if (type != 0) {
			queryString = queryString + " AND h.type LIKE :type";
			query = entityManager.createQuery(queryString).setParameter("pattern", pattern)
					.setParameter("start_date", start_date).setParameter("end_date", end_date)
					.setParameter("number_of_guests", number_of_guests).setParameter("type", type);
		} else {
			query = entityManager.createQuery(queryString).setParameter("pattern", pattern)
					.setParameter("start_date", start_date).setParameter("end_date", end_date)
					.setParameter("number_of_guests", number_of_guests);
		}

		return query.getResultList();
	}

	// MESSAGES

	public List<Message> getMessages() {
		List<Message> messages = getAllMessages();
		return messages;
	}

	public List<Message> getAllMessages() {
		Query query = entityManager.createNamedQuery("Message.findAll", Message.class);
		return query.getResultList();
	}

	public void createNewMessage(Message message) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(message);
		tx.commit();
	}

	public void updateMessage(Message message) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(message);
		tx.commit();
	}

	public void deleteMessage(int id) {
		Message message = entityManager.find(Message.class, id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(message);
		tx.commit();
	}

	public Message getMessage(int id) {
		return entityManager.find(Message.class, id);
	}

	// BOOKINGS

	public List<Booking> getBookings() {
		List<Booking> bookings = getAllBookings();
		return bookings;
	}

	public List<Booking> getAllBookings() {
		Query query = entityManager.createNamedQuery("Booking.findAll", Booking.class);
		return query.getResultList();
	}

	// TODO
//	public List<Booking> getBookingsFromUser(User user){
//		Query query = entityManager.createQuery(
//				"SELECT b FROM Booking b WHERE b.guest LIKE :user")
//				.setParameter("user", user);
//		List<User> users = query.getResultList();
//		return null;
//	}

	public void createNewBooking(Booking booking) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(booking);
		tx.commit();
	}

	public void updateBooking(Booking booking) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(booking);
		tx.commit();
	}

	public void deleteBooking(int id) {
		Booking booking = entityManager.find(Booking.class, id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(booking);
		tx.commit();
	}

	public Booking getBooking(int id) {
		return entityManager.find(Booking.class, id);
	}

	// USERS

	public User getUser(int id) {
		return entityManager.find(User.class, id);
	}

	public User findUser(String email, String password) {
		Query query = entityManager
				.createQuery("SELECT u FROM User u WHERE u.email LIKE :email AND u.password LIKE :password")
				.setParameter("email", email).setParameter("password", password);
		List<User> users = query.getResultList();

		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	public List<User> getUsers() {
		List<User> users = getAllUsers();
		return users;
	}

	public List<User> getAllUsers() {
		Query query = entityManager.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	public void createNewUser(User user) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(user);
		tx.commit();
	}

	public void updateUser(User user) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(user);
		tx.commit();
	}

	public void deleteUser(int id) {
		User user = entityManager.find(User.class, id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(user);
		tx.commit();
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return this.currentUser;
	}

}
