package test;

import java.util.ArrayList;

public class Utils {
	public static void checkAllTestCases(ArrayList<Boolean> testCases) {
		if (testCases.size() == 0) {
			System.out.println("No tests performed.");
		} else {
			for (int i = 0; i < testCases.size(); i++) {
				if (testCases.get(i).booleanValue() != true) {
					System.out.println("Test case " + (i + 1) + " failed.");
					System.out.println(" --- Unit test failed. --- ");
					return;
				}
			}
			System.out.println(" --- Unit test passed! --- ");
		}
	}
}
