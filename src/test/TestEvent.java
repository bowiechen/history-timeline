package test;

import unit.Event;

import java.util.ArrayList;

public class TestEvent {
	private static ArrayList<Boolean> testCases = new ArrayList<Boolean>();


	public static void main(String[] args) {
		try {
			Event e1 = new Event("e1", 2016, 6, 2017, 7, false);
			Event e2 = new Event("e2", 2016, 2017, false);
			if (e1.getEventName() == "e1") {
				testCases.add(true);
				System.out.println("[PASS] e1.getEventName()");
			} else {
				testCases.add(false);
				System.out.println("[FAIL] e1.getEventName()");
			}

			if (e1.getStartYear() == 2016) {
				testCases.add(true);
				System.out.println("[PASS] e1.getStartYear()");
			} else {
				testCases.add(false);
				System.out.println("[FAIL] e1.getStartYear()");
			}

			if (e1.getOngoing() == false) {
				testCases.add(true);
				System.out.println("[PASS] e1.getOngoing()");
			} else {
				testCases.add(false);
				System.out.println("[FAIL] e1.getOngoing()");
			}

			if (e1.compare(e2) < 0) {
				testCases.add(true);
				System.out.println("[PASS] e1 < e2");
			} else {
				testCases.add(false);
				System.out.println("[FAIL] e1 >= e2");
				e1.printAllFields();
				e2.printAllFields();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Utils.checkAllTestCases(testCases);
	}
}
