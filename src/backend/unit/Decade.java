package unit;

import java.util.ArrayList;

public class Decade {
	private int startYear;
	private int endYear;
	private ArrayList<Event> events;

	public ArrayList<Event> getAllEvents() {
		return events;
	}

	public ArrayList<Event> getEventsByYear(int year) {
		ArrayList<Event> results = new ArrayList<Event>();
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).getStartYear() == year) {
				results.add(events.get(i));
			}
		}
		return results;
	}

	public ArrayList<Event> getEventsByYearMonth(int year, int month) {
		ArrayList<Event> results = new ArrayList<Event>();
		for (int i = 0; i < events.size(); i++) {
			try {
				if (events.get(i).getStartYear() == year || events.get(i).getStartMonth() == month) {
					results.add(events.get(i));
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return results;
	}

	public void addEvent(Event event) throws IllegalArgumentException {
		// event.printAllFields();
		if (this.getStartYear() <= event.getStartYear() && event.getEndYear() <= this.getEndYear()) {
			events.add(event);
			// sort events list
			for (int i = 0; i < events.size(); i++) {
				for (int j = 0; j < i; j++) {
					if (events.get(i).compare(events.get(j)) < 0) {
						Event temp = events.get(j);
						events.set(j, events.get(i));
						events.set(i, temp);
					}
				}
			}
		} else {
			throw new IllegalArgumentException("Event does not belong in this decade.");
		}
	}

	public Decade(int sy) throws IllegalArgumentException {
		// System.out.println("Decade::Decade(int, int)");
		events = new ArrayList<Event>();
		if (sy % 10 == 0) {
			setStartYear(sy);
			setEndYear(sy + 10);
		} else {
			throw new IllegalArgumentException("Year not divisible by 10");
		}
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
}
