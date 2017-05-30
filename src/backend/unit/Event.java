package unit;

import java.util.Comparator;

public class Event implements Comparator<Object> {
	private final int defaultValue = 400;
	private final int noValue = 0;

	private String name;

	// Variables are initialized with defaultValue, for comparison purposes.
	// Initialization avoid garbage value comparisons, if there is such problem
	// in Java at all
	private int startYear = defaultValue;
	private int startMonth = defaultValue;
	private int startDay = defaultValue;

	private int endYear = defaultValue;
	private int endMonth = defaultValue;
	private int endDay = defaultValue;

	private boolean ongoing;

	public String getEventName() {
		return name;
	}

	public int getStartYear() {
		return startYear;
	}

	public int getStartMonth() throws IllegalArgumentException {
		if (startMonth == noValue)
			throw new IllegalArgumentException("No start month set.");
		else
			return startMonth;
	}

	public int getStartDay() throws IllegalArgumentException {
		if (startDay == noValue)
			throw new IllegalArgumentException("No start day set.");
		else
			return startDay;
	}

	public int getEndYear() throws IllegalArgumentException {
		if (ongoing)
			throw new IllegalArgumentException("Ongoing event.");
		return endYear;
	}

	public int getEndMonth() throws IllegalArgumentException {
		if (ongoing)
			throw new IllegalArgumentException("Ongoing event.");
		if (endMonth == noValue)
			throw new IllegalArgumentException("No end month set.");
		else
			return endMonth;
	}

	public int getEndDay() throws IllegalArgumentException {
		if (ongoing)
			throw new IllegalArgumentException("Ongoing event.");
		if (endDay == noValue)
			throw new IllegalArgumentException("No end day set.");
		else
			return endDay;
	}

	public boolean getOngoing() {
		return ongoing;
	}

	public void setEventName(String val) {
		name = val;
	}

	public void setStartYear(int val) throws IllegalArgumentException {
		if (getEndYear() == defaultValue || val <= getEndYear()) {
			startYear = val;
		} else {
			if (val > getEndYear()) {
				throw new IllegalArgumentException("Start year > end year");
			}
		}
	}

	public void setStartMonth(int val) throws IllegalArgumentException {
		if (getEndMonth() == defaultValue || val <= getEndMonth()) {
			startMonth = val;
		} else {
			if (val > getEndMonth()) {
				throw new IllegalArgumentException("Start month > end month");
			}
		}
	}

	public void setStartDay(int val) throws IllegalArgumentException {
		if (getEndDay() == defaultValue || val <= getEndDay()) {
			startDay = val;
		} else {
			if (val > getEndDay()) {
				throw new IllegalArgumentException("Start day > end day");
			}
		}
	}

	public void setEndYear(int val) throws IllegalArgumentException {
		if (getStartYear() == defaultValue || getStartYear() <= val) {
			endYear = val;
		} else {
			if (val < getStartYear()) {
				throw new IllegalArgumentException("End year < start year");
			}
		}
	}

	public void setEndMonth(int val) {
		if (getStartMonth() == defaultValue || getStartMonth() <= val) {
			endMonth = val;
		} else {
			if (val < getStartMonth()) {
				throw new IllegalArgumentException("End month < start month");
			}
		}
	}

	public void setEndDay(int val) {
		if (getStartDay() == defaultValue || getStartDay() <= val) {
			endDay = val;
		} else {
			if (val < getStartDay()) {
				throw new IllegalArgumentException("End day < start day");
			}
		}
	}

	public void setOngoing(boolean val) throws IllegalArgumentException {
		if (val == true) {
			setEndYear(-1);
			setEndMonth(-1);
			setEndDay(-1);
		}
		ongoing = val;
	}

	public Event(String name, int ys, int ye, boolean ongoing) throws IllegalArgumentException {
		// System.out.println("Event::Event(String, int, int, boolean)");
		if (ys > ye) {
			throw new IllegalArgumentException("Date inconsistent.");
		} else {
			setEventName(name);
			setStartYear(ys);
			setEndYear(ye);
			setOngoing(ongoing);
		}
	}

	public Event(String name, int ys, int ms, int ye, int me, boolean ongoing) throws IllegalArgumentException {
		// System.out.println("Event::Event(String, int, int, int, int,
		// boolean)");
		if (ys > ye || (ys == ye && ms > me)) {
			throw new IllegalArgumentException("Date inconsistent.");
		} else {
			setEventName(name);
			setStartYear(ys);
			setEndYear(ye);
			setStartMonth(ms);
			setEndMonth(me);
			setOngoing(ongoing);
		}
	}

	public Event(String name, int ys, int ms, int ds, int ye, int me, int de, boolean ongoing)
			throws IllegalArgumentException {
		// System.out.println("Event::Event(String, int, int, int, int, int,
		// int, boolean)");
		if (ys > ye || (ys == ye && ms > me) || (ys == ye && ms == me && ds > de)) {
			throw new IllegalArgumentException("Date inconsistent.");
		} else {
			setEventName(name);
			setStartYear(ys);
			setEndYear(ye);
			setStartMonth(ms);
			setEndMonth(me);
			setStartDay(ds);
			setEndDay(de);
			setOngoing(ongoing);
		}
	}

	public int compare(Object rhs) {
		return compare(this, rhs);
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		Event e1 = (Event) arg0;
		Event e2 = (Event) arg1;
		if (e1.getStartYear() > e2.getStartYear()) {
			return 1;
		} else if (e1.getStartYear() < e2.getStartYear()) {
			return -1;
		} else {
			try {
				if (e1.getStartMonth() > e2.getStartMonth()) {
					return 1;
				} else if (e1.getStartMonth() < e2.getStartMonth()) {
					return -1;
				} else {
					try {
						if (e1.getStartDay() > e2.getStartDay()) {
							return 1;
						} else if (e1.getStartDay() < e2.getStartDay()) {
							return -1;
						} else {
							return 0;
						}
					} catch (IllegalArgumentException e) {
						return 0;
					}
				}
			} catch (IllegalArgumentException e) {
				return 0;
			}
		}
	}

	public void printAllFields() {
		System.out.println("----------------");
		System.out.println("| name = " + name);
		System.out.println("| startYear = " + startYear);
		System.out.println("| startMonth = " + startMonth);
		System.out.println("| startDay = " + startDay);
		System.out.println("| endYear = " + endYear);
		System.out.println("| endMonth = " + endMonth);
		System.out.println("| endDay = " + endDay);
		System.out.println("----------------");
	}
}
