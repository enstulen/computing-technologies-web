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

import entities.Home;
import entities.User;
import beans.UserBean;
import entities.Booking;
import beans.Message;

public class Datastore {

	public EntityManager entityManager;

	private static Datastore single_instance = null;

	public static User currentUser;

	private Datastore() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fakebnb");
		entityManager = factory.createEntityManager();

		// This should be the actual current user, but for now we just use the first
		// user in DB
		currentUser = entityManager.find(User.class, 1);

	}

	public static Datastore getInstance() {
		if (single_instance == null)
			single_instance = new Datastore();
		return single_instance;
	}

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

	public List<Home> findHome(String name, Date start_date, Date end_date, int price, int type, int adults, int kids) {
//		Query query = entityManager.createQuery(
//				"SELECT h FROM Home h WHERE h.name LIKE :name AND :start_date BETWEEN h.date_available_start AND h.date_available_end")
//				.setParameter("name", name).setParameter("start_date", start_date);
		
		Query query = entityManager.createQuery(
				"SELECT h FROM Home h WHERE h.name LIKE :name")
				.setParameter("name", name);
		System.out.println("HALLA");
		System.out.println(name);

		System.out.println(query.getResultList());

		return query.getResultList();
	}

	public List<Message> getMessages() {
		List<Message> messages = getAllMessages();
		return messages;
	}

	public List<Message> getAllMessages() {
		Query query = entityManager.createQuery("SELECT m FROM MESSAGE m");
		return query.getResultList();
	}

	public ArrayList<UserBean> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Booking> getBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	public Home getHome(int id) {
		return entityManager.find(Home.class, id);
	}

	public User getUser(int id) {
		return entityManager.find(User.class, id);
	}


}
