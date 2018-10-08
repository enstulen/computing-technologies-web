package datastore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.HomeBean;

public class Datastore {

	private static Datastore single_instance = null;

	public List<HomeBean> listOfHomes = new ArrayList<HomeBean>();

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

	}

	public static Datastore getInstance() {
		if (single_instance == null)
			single_instance = new Datastore();
		return single_instance;
	}

	public List<HomeBean> getHomes() {
		return (List<HomeBean>) listOfHomes;
	}

}
