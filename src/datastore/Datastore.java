package datastore;

import java.util.ArrayList;
import java.util.List;

import beans.HomeBean;

public class Datastore {

	private static List<HomeBean> listOfHomes = new ArrayList<HomeBean>();

	public List<HomeBean> getHomes() {
		return (List<HomeBean>) listOfHomes;
	}

}
