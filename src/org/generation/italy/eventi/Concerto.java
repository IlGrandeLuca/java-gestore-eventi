/**
 * 
 */
package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lucai
 *
 */
public class Concerto extends Evento {
	// Attributes
	LocalTime hours;
	BigDecimal price;

	/**
	 * @param title
	 * @param date
	 * @param totalSeats
	 * @throws IllegalArgumentException
	 */
	public Concerto(String title, LocalDate date, LocalTime hours, int totalSeats, BigDecimal price)
			throws IllegalArgumentException {
		super(title, date, totalSeats);
		// TODO Auto-generated constructor stub
		this.hours = hours;
		this.price = price;
	}

	/**
	 * @return the hours
	 */
	public LocalTime getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(LocalTime hours) {
		this.hours = hours;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	// Return formatted price
	public String formattedPrice() {
		return price.setScale(2, RoundingMode.UP) + "€";
	}

	// Return formatted hours
	public String formattedHours() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
		return df.format(hours);
	}

	@Override
	public String toString() {
		return "Date/hours: " + formattedDate() + "/" + formattedHours() + ", title: " + getTitle() + ", price: "
				+ formattedPrice() + ";";
	}
}
