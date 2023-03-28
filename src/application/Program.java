package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			System.out.print("Room: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), fmt1);
	
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
	
			System.out.println("Enter data to update reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn1 = LocalDate.parse(sc.next(), fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut1 = LocalDate.parse(sc.next(), fmt1);
	
			reservation.updateDates(checkIn1, checkOut1);
	
			System.out.println(reservation);
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}

}
