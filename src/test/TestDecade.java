package test;

import unit.Decade;
import unit.Event;

import java.util.ArrayList;

public class TestDecade {
	private static ArrayList<Boolean> testCases = new ArrayList<Boolean>();
	
	
	public static void main(String[] args) {
		try {
			Event e1 = new Event("event1", 2017, 4, 2017, 5, false);
			Event e2 = new Event("event2", 2016, 2017, false);
			Event e3 = new Event("event3", 2015, 2016, false);
			Decade d = new Decade(2010);
			d.addEvent(e1);
			d.addEvent(e2);
			d.addEvent(e3);
			ArrayList<Event> list = d.getAllEvents();
			for (int i = 0; i < list.size(); i++) {
				list.get(i).printAllFields();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utils.checkAllTestCases(testCases);
	}
}
