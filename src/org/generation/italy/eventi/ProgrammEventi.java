/**
 * 
 */
package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author lucai
 *
 */
public class ProgrammEventi {
	// Attributes
	private String title;
	private List<Evento> events;

	/**
	 * @param title
	 */
	public ProgrammEventi(String title) {
		this.title = title;
		events = new ArrayList<Evento>();
	}

	// Add event
	public void addEvento(Evento events) {
		this.events.add(events);
	}

	// Return string of all events in a specific day
	public String dateOf(LocalDate date) {
		String dateListString = null;
		for (Evento item : events) {
			if (item.getDate() == date) {
				String space = events.size() == 1 ? "" : " - ";
				dateListString += item.getTitle() + space;
			}
		}
		return dateListString;
	}

	// Return size of List<Evento>
	public int sizeOf() {
		return events.size();
	}

	// Remove all events
	public boolean removeAll(List<Evento> events) {
		boolean isMod = false;
		Iterator<Evento> iterator = events.iterator();
		while (iterator.hasNext()) {
			if (events.contains(iterator.next())) {
				iterator.remove();
				isMod = true;
			}
		}
		return isMod;
	}

	@Override
	public String toString() {
		String dateListString = null;
		Collections.sort(events);
		for (Evento item : events) {
			String space = events.size() == 1 ? "" : "\n";
			dateListString += item.getDate() + " - " + item.getTitle() + space;
		}
		return "ProgrammEventi " + title + "\n" + "events= " + dateListString + "]";
	}
}
