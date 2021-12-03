/**
 * 
 */
package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author lucai
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int totSeats = 0;
		String title = null;
		LocalDate date = null;

		System.out.println("Create a new event...");

		// Starting input
		try {
			System.out.print("Enter number of total seats: ");
			try {
				totSeats = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("Enter title: ");
			title = in.nextLine();

			System.out.println("Enter date of reservation (yyyy/MM/dd). ");
			int day = 0, month = 0, year = 0;
			System.out.print("Enter day: ");
			try {
				day = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.print("Enter month: ");
			try {
				month = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.print("Enter year: ");
			try {
				year = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			date = LocalDate.of(year, month, day);

		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Instance of Eventi
		try {
			Eventi myEvent = new Eventi(title, date, totSeats);
			int numRes = 0;
			boolean toDo = false;

			System.out.print("Do you want to book? Enter ('s'/'n'):");
			String check = in.nextLine();

			// Input control
			switch (check) {
			case "s":
				toDo = true;
				break;
			case "n":
				toDo = false;
				break;
			default:
				toDo = false;
			}

			// Add reservation
			if (toDo) {
				System.out.println("how many reservations do you want to make?");
				try {
					numRes = Integer.parseInt(in.nextLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < numRes; i++) {
					myEvent.reserve();
				}

				System.out.println("Reserved seats: " + myEvent.getReservedSeats());
				System.out.println("Free seats: " + (myEvent.getTotalSeats() - myEvent.getReservedSeats()));
			}

			System.out.print("Do you want to cancel a reservation? Enter ('s'/'n'):");
			check = in.nextLine();

			// Input control
			switch (check) {
			case "s":
				toDo = true;
				break;
			case "n":
				toDo = false;
				break;
			default:
				toDo = false;
			}

			// Subtract reservation
			if (toDo) {
				System.out.println("how many reservations do you want to cancel?");
				try {
					numRes = Integer.parseInt(in.nextLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < numRes; i++) {
					myEvent.cancel();
				}

				System.out.println("Reserved seats: " + myEvent.getReservedSeats());
				System.out.println("Free seats: " + (myEvent.getTotalSeats() - myEvent.getReservedSeats()));
			}

		} catch (IllegalArgumentException iae) {
			System.out.println("Exception: " + iae.getMessage());
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedOperationException uoe) {
			System.out.println("Exception: " + uoe.getMessage());
		}

		in.close();
	}

}
