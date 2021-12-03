package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Eventi {
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
	public Eventi(String title, LocalDate date, int totalSeats) throws IllegalArgumentException {
		if (isValidDate(date) || isValidTotalSeats(totalSeats)) {
			this.title = title;
			if (isValidDate(date))
				this.date = date;
			else
				throw new IllegalArgumentException("Invalid date");
			if (isValidTotalSeats(totalSeats))
				this.totalSeats = totalSeats;
			else
				throw new IllegalArgumentException("Invalid number of seats");
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
		if (!isValidDate(date) || reservedSeats > totalSeats)
			throw new UnsupportedOperationException("There is too much reservations");
		else
			return reservedSeats += 1;
	}

	public int cancel() throws UnsupportedOperationException {
		if (!isValidDate(date) || reservedSeats <= PREDEF_RESERVED)
			throw new UnsupportedOperationException("Not possible to do");
		else
			return reservedSeats -= 1;
	}

	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Eventi [title=" + title + ", date=" + df.format(date) + "]";
	}

	// Private methods
	private boolean isValidDate(LocalDate date) {
		int i = date.compareTo(LocalDate.now());
		return i > 0;
	}

	private boolean isValidTotalSeats(int totalSeats) {
		return totalSeats > 0;
	}
}
