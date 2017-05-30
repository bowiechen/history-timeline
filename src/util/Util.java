package util;

import java.util.Calendar;

public class Util {
	public static void printMessage(String message) {
		Calendar cal = Calendar.getInstance();
		String datetime = "" + cal.get(Calendar.YEAR);
		if (cal.get(Calendar.MONTH) < 10) {
			datetime += "-0" + (cal.get(Calendar.MONTH) + 1);
		} else {
			datetime += "-" + (cal.get(Calendar.MONTH) + 1);
		}
		if (cal.get(Calendar.DATE) < 10) {
			datetime += "-0" + cal.get(Calendar.DATE);
		} else {
			datetime += "-" + cal.get(Calendar.DATE);
		}
		if (cal.get(Calendar.HOUR_OF_DAY) < 10) {
			datetime += " 0" + cal.get(Calendar.HOUR_OF_DAY);
		} else {
			datetime += " " + cal.get(Calendar.HOUR_OF_DAY);
		}
		if (cal.get(Calendar.MINUTE) < 10) {
			datetime += ":0" + cal.get(Calendar.MINUTE);
		} else {
			datetime += ":" + cal.get(Calendar.MINUTE);
		}
		if (cal.get(Calendar.SECOND) < 10) {
			datetime += ":0" + cal.get(Calendar.SECOND);
		} else {
			datetime += ":" + cal.get(Calendar.SECOND);
		}
		if (cal.get(Calendar.MILLISECOND) < 9) {
			datetime += ".00" + cal.get(Calendar.MILLISECOND);
		} else if (cal.get(Calendar.MILLISECOND) < 99) {
			datetime += ".0" + cal.get(Calendar.MILLISECOND);
		} else {
			datetime += "." + cal.get(Calendar.MILLISECOND);
		}
		System.out.println(datetime + " - " + message);
	}
}
