 package datastore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;

import entities.Home;
import entities.User;
import entities.Booking;
import entities.Message;

public class Datastore {

	public EntityManagerFactory factory;

	private static Datastore single_instance = null;

	public User currentUser;

	private Datastore() {

		factory = Persistence.createEntityManagerFactory("fakebnb");

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
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8100/homes");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<Home> list = response.readEntity(new GenericType<List<Home>>(){});
		return list;
	}

	public List<Home> getHomesForHost(User user) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8100/homes/find/user/" + String.valueOf(user.getUserid()));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<Home> list = response.readEntity(new GenericType<List<Home>>(){});
		return list;
	}

	public void createNewHome(Home home) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8100/homes");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(home, MediaType.APPLICATION_JSON));
	}

	public void updateHome(Home home) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8100/homes/" + String.valueOf(home.getHomeid()));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(home, MediaType.APPLICATION_JSON));
	}

	public void deleteHome(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8100/homes/" + String.valueOf(id));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();
	}

	public Home getHome(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8100/homes/" + String.valueOf(id));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		Home home = response.readEntity(new GenericType<Home>(){});
		return home;

	}

	public List<Home> findHome(String name, Date start_date, Date end_date, int price, int type, int adults, int kids) {
//		EntityManager entityManager = factory.createEntityManager();
//
//		String queryString = "SELECT h FROM Home h WHERE LOWER(h.name) LIKE :pattern AND h.date_available_start<=:start_date AND h.date_available_end>=:end_date AND h.number_of_guests >= :number_of_guests";
//		switch (price) {
//		case 0:
//			queryString = queryString;
//			break;
//		case 1:
//			queryString = queryString + " AND h.price < 35";
//			break;
//		case 2:
//			queryString = queryString + " AND h.price > 35 AND h.price < 69";
//			break;
//		case 3:
//			queryString = queryString + " AND h.price > 70 AND h.price < 130";
//			break;
//		case 4:
//			queryString = queryString + " AND h.price > 131";
//			break;
//		default:
//			queryString = queryString;
//			break;
//		}
//
//		Query query;
//		String pattern = "%" + name.toLowerCase() + "%";
//		int number_of_guests = adults + kids;
//
//		if (type != 0) {
//			queryString = queryString + " AND h.type LIKE :type";
//			query = entityManager.createQuery(queryString).setParameter("pattern", pattern)
//					.setParameter("start_date", start_date).setParameter("end_date", end_date)
//					.setParameter("number_of_guests", number_of_guests).setParameter("type", type);
//		} else {
//			query = entityManager.createQuery(queryString).setParameter("pattern", pattern)
//					.setParameter("start_date", start_date).setParameter("end_date", end_date)
//					.setParameter("number_of_guests", number_of_guests);
//		}
//
//		return query.getResultList();
		return null;

	}

	// MESSAGES
	
	public Message getMessage(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8110/messages/" + String.valueOf(id));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		Message message = response.readEntity(new GenericType<Message>(){});
		return message;
	}

	public List<Message> getMessages() {
		return getAllMessages();
	}

	public List<Message> getMessagesForUser(User user) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8110/messages/" + String.valueOf(user.getUserid()));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<Message> messages = response.readEntity(new GenericType<List<Message>>(){});
		return messages;

	}

	public List<Message> getAllMessages() {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8110/messages");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<Message> messages = response.readEntity(new GenericType<List<Message>>(){});
		return messages;

	}

	public void createNewMessage(Message message) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8110/messages");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(message, MediaType.APPLICATION_JSON));
	}

	public void updateMessage(Message message) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8110/messages");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(message, MediaType.APPLICATION_JSON));
	}

	public void deleteMessage(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8110/messages/"+String.valueOf(id));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();
	}

	

	// BOOKINGS

	public List<Booking> getBookingsForGuestUser(User user) {
//		EntityManager entityManager = factory.createEntityManager();
//		Query query = entityManager
//				.createQuery("SELECT b FROM Booking b JOIN b.guest u WHERE u.userid = :userid")
//				.setParameter("userid", user.getUserid());
//		List<Booking> bookings = query.getResultList();
//		return bookings;
		return null;

	}

	public List<Booking> getBookingsForHostUser(User user) {
//		EntityManager entityManager = factory.createEntityManager();
//		Query query = entityManager
//				.createQuery("SELECT b FROM Booking b JOIN b.host u WHERE u.userid = :userid")
//				.setParameter("userid", user.getUserid());
//		List<Booking> bookings = query.getResultList();
//		return bookings;
		return null;

	}

	public List<Booking> getBookingsForGuest() {
//		if (currentUser != null) {
//			List<Booking> bookings = getBookingsForGuestUser(currentUser);
//			return bookings;
//		}
		return null;
	}

	public List<Booking> getBookingsForHost() {
//		if (currentUser != null) {
//			List<Booking> bookings = getBookingsForHostUser(currentUser);
//			return bookings;
//		}
		return null;
	}

	public List<Booking> getBookings() {
		List<Booking> bookings = getAllBookings();
		return bookings;
	}

	public List<Booking> getAllBookings() {
//		EntityManager entityManager = factory.createEntityManager();
//		Query query = entityManager.createNamedQuery("Booking.findAll", Booking.class);
//		return query.getResultList();
		return null;
	}

	public void setBookingConfirmed(int bookingid) {
//		EntityManager entityManager = factory.createEntityManager();
//		Booking booking = getBooking(bookingid);
//		booking.setConfirmed(true);
//		EntityTransaction tx = entityManager.getTransaction();
//		tx.begin();
//		entityManager.merge(booking);
//		tx.commit();
//		entityManager.close();
	}

	public void createNewBooking(Booking booking) {
//		EntityManager entityManager = factory.createEntityManager();
//		EntityTransaction tx = entityManager.getTransaction();
//		tx.begin();
//		entityManager.persist(booking);
//		tx.commit();
//		entityManager.close();
	}

	public void updateBooking(Booking booking) {
//		EntityManager entityManager = factory.createEntityManager();
//		EntityTransaction tx = entityManager.getTransaction();
//		tx.begin();
//		entityManager.merge(booking);
//		tx.commit();
//		entityManager.close();
	}

	public void deleteBooking(int id) {
//		EntityManager entityManager = factory.createEntityManager();
//		Booking booking = entityManager.find(Booking.class, id);
//		EntityTransaction tx = entityManager.getTransaction();
//		tx.begin();
//		entityManager.remove(booking);
//		tx.commit();
//		entityManager.close();

	}

	public Booking getBooking(int id) {
//		EntityManager entityManager = factory.createEntityManager();
//		return entityManager.find(Booking.class, id);
		return null;

	}

	// USERS

	public User getUser(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8090/users/" + String.valueOf(id));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		User user = response.readEntity(new GenericType<User>(){});
		return user;

	}

	public User findUser(String email) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8090/users/find/" + email);
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		User user = response.readEntity(new GenericType<User>(){});
		return user;
	}

	public User findUser(String email, String password) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8090/users/find");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		System.out.println(String.format("{'email':'%s', 'password': '%s'}", email, password));
		Response response = invocationBuilder.post(Entity.entity(String.format("{'email':'%s', 'password': '%s'}", email, password), MediaType.APPLICATION_JSON_TYPE));
		User user = response.readEntity(new GenericType<User>(){});
		return user;
	}

	public List<User> getUsers() {
		List<User> users = getAllUsers();
		return users;
	}

	public List<User> getAllUsers() {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8090/users");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<User> list = response.readEntity(new GenericType<List<User>>(){});
		return list;
	}

	public void createNewUser(User user) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8090/users");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
	}

	public void updateUser(User user) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8090/users");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON));
	}

	public void deleteUser(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8090/users/" + String.valueOf(id));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return this.currentUser;
	}

}
