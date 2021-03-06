 package datastore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
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

	private static Datastore single_instance = null;

	public User currentUser;

	private Datastore() {
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
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start = sdf.format(start_date);
		String end = sdf.format(end_date);
		
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8100/homes/search");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		System.out.println(String.format("{'name':'%s', 'start':'%s', 'end':'%s', 'price':'%s', 'type':'%s', 'adults':'%s', 'kids':'%s'}",
											name, start, end, price, type, adults, kids));
		Response response = invocationBuilder.post(Entity.entity(String.format("{'name':'%s', 'start':'%s', 'end':'%s', 'price':'%s', 'type':'%s', 'adults':'%s', 'kids':'%s'}",
											name, start, end, price, type, adults, kids), MediaType.APPLICATION_JSON_TYPE));
		List<Home> listHomes = response.readEntity(new GenericType<List<Home>>(){});
		return listHomes;		
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
		WebTarget webResource = client.target("http://localhost:8110/messages/find/" + String.valueOf(user.getUserid()));
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
		WebTarget webResource = client.target("http://localhost:8110/messages/"+String.valueOf(message.getMessageid()));
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
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8104/bookings/guest/" + String.valueOf(user.getUserid()));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response=null;
		try {
			response = invocationBuilder.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Booking> list = response.readEntity(new GenericType<List<Booking>>(){});
		return list;
	}

	public List<Booking> getBookingsForHostUser(User user) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8104/bookings/host/" + String.valueOf(user.getUserid()));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<Booking> list = response.readEntity(new GenericType<List<Booking>>(){});
		return list;
	}

	public List<Booking> getBookingsForGuest() {
		if (currentUser != null) {
			List<Booking> bookings = getBookingsForGuestUser(currentUser);
			return bookings;
		}
		return null;
	}

	public List<Booking> getBookingsForHost() {
		if (currentUser != null) {
			List<Booking> bookings = getBookingsForHostUser(currentUser);
			return bookings;
		}
		return null;
	}

	public List<Booking> getBookings() {
		List<Booking> bookings = getAllBookings();
		return bookings;
	}

	public List<Booking> getAllBookings() {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8104/bookings");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		List<Booking> list = response.readEntity(new GenericType<List<Booking>>(){});
		return list;
	}

	public void setBookingConfirmed(int bookingid) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8104/bookings/" + String.valueOf(bookingid)+"/confirmation");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Booking booking = new Booking();
		Response response = invocationBuilder.put(Entity.entity(booking, MediaType.APPLICATION_JSON));
	}

	public void createNewBooking(Booking booking) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8104/bookings");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(booking, MediaType.APPLICATION_JSON));
	}

	public void updateBooking(Booking booking) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8104/bookings");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(booking, MediaType.APPLICATION_JSON));
	}

	public void deleteBooking(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8104/bookings/" + String.valueOf(id)+"/cancelation");
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Booking booking = new Booking();
		Response response = invocationBuilder.put(Entity.entity(booking, MediaType.APPLICATION_JSON));
	}

	public Booking getBooking(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8104/bookings/" + String.valueOf(id));
		Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		Booking booking = response.readEntity(new GenericType<Booking>(){});
		return booking;
	}
	
	//USERS

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
