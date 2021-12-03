package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento implements Comparable<Evento> {
	// Constants
	private final static int PREDEF_RESERVED = 0;

	// Attributes
	private String title;
	private LocalDate date;
	private int totalSeats;
	private int reservedSeats;

	/**
	 * @param title
	 * @param date
	 * @param totalSeats
	 */
	public Evento(String title, LocalDate date, int totalSeats) throws IllegalArgumentException {
		if (isValidDate(date) || isValidTotalSeats(totalSeats)) {
			if (isValidDate(date))
				this.date = date;
			else
				throw new IllegalArgumentException("Invalid date");
			if (isValidTotalSeats(totalSeats))
				this.totalSeats = totalSeats;
			else
				throw new IllegalArgumentException("Invalid number of seats");
			this.title = title;
			this.reservedSeats = PREDEF_RESERVED;
		} else
			throw new IllegalArgumentException("Invalid values");
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the totalSeats
	 */
	public int getTotalSeats() {
		return totalSeats;
	}

	/**
	 * @return the reservedSeats
	 */
	public int getReservedSeats() {
		return reservedSeats;
	}

	// Public methods
	public int reserve() throws UnsupportedOperationException {
		int r = reservedSeats += 1;
		if (!isValidDate(date) || reservedSeats > totalSeats)
			throw new UnsupportedOperationException("There is too much reservations");
		else
			return r;
	}

	public int cancel() throws UnsupportedOperationException {
		int r = reservedSeats -= 1;
		if (!isValidDate(date) || reservedSeats <= PREDEF_RESERVED)
			throw new UnsupportedOperationException("Not possible to do");
		else
			return r;
	}

	@Override
	public String toString() {
		return "Evento [title= " + title + ", date= " + formattedDate() + "]";
	}

	@Override
	public int compareTo(Evento e) {
		// TODO Auto-generated method stub
		return getDate().compareTo(e.getDate());
	}

	// Private methods
	private boolean isValidDate(LocalDate date) {
		int i = date.compareTo(LocalDate.now());
		return i > 0;
	}

	private boolean isValidTotalSeats(int totalSeats) {
		return totalSeats > 0;
	}

	// Return formatted date
	protected String formattedDate() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return df.format(date);
	}

}
