package server.services;

import org.springframework.stereotype.Service;

import server.models.Reservation;
import server.repository.ReservationRepository;

/**
 * Functions for interacting with the Reservations table within the database.
 *
 * @author Lily Wilks
 */
@Service
public class ReservationService {

	public static ReservationService reservationService;
	private final ReservationRepository reservationRepository;

	public ReservationService(ReservationRepository reservationRepository) {

		this.reservationRepository = reservationRepository;
	}

	/**
	 * Save Server Reservation to the database
	 *
	 * @param reservation The Reservation variable to be saved to the database.
	 *
	 * @return The Reservation that has been added to the database.
	 */
	public Reservation AddReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	/**
	 * Fetch the length of the reservation table in the database.
	 *
	 * @return The length of the Reservation table.
	 */
	public long GetReservationTableLength(){
		try{
			return reservationRepository.count();
		}
		catch (Exception e) {
			return (Long) null;
		}
	}
}
