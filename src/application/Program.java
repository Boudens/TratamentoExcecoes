package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Room: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), fmt1);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), fmt1);

		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		} 
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println("Enter data to update reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn1 = LocalDate.parse(sc.next(), fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut1 = LocalDate.parse(sc.next(), fmt1);

			String error  = reservation.updateDates(checkIn1, checkOut1);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else
				System.out.println(reservation);
		}

		sc.close();
	}

}
