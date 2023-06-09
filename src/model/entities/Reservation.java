package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public int duration() {
		Period p = Period.between(checkIn, checkOut);
		return p.getDays();
	}

	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if (checkOut.isBefore(this.checkOut) || checkIn.isBefore(this.checkIn))
			throw new DomainException("Reservation dates for update must be future dates.");

		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	@Override
	public String toString() {
		return "Room: " + roomNumber + ", check-in: " + checkIn.format(fmt1) + ", check-out: " + checkOut.format(fmt1)
				+ ", " + duration() + " nights.";
	}

}
