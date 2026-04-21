package server.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import server.repository.ReservationRepository;
import server.services.ReservationService;
import server.models.Reservation;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Reservation controller class for interacting with the database.
 *
 * @author Lily Wilks
 */
@RestController
public class ReservationController {

	@Autowired
	ReservationRepository ReservationRepo;

	public ReservationController(ReservationService reservationService) {
		ReservationService.reservationService = reservationService;
	}

		/**
		 * Fetches the whole table of the reservations table within the database.
		 *
		 * @url /reservation/all
		 * @method GET
		 *
		 * @return The reservations database table.
		 */
		@GetMapping("/reservation/all")
		public List<Reservation> GetAllReservations() {
			try {
				return ReservationRepo.findAll();
			} catch (Exception e) {
				return null;
			}
		}

		/**
		 * Fetches data from the database.
		 *
		 * @url /reservation/{name}
		 * @method GET
		 *
		 * @param name The name of the server that has been reserved.
		 *
		 * @return The reserved server.
		 */
		@GetMapping("/reservation/{name}")
		public JSONObject FetchServerReservation(@PathVariable("name") String name) {
		try{
			Reservation reservation = ReservationRepo.findbyserver_name(name);

			JSONObject response_json = new JSONObject();
			response_json.put("reservation_server_name", reservation.GetServerName());
			response_json.put("reservation_username", reservation.GetUsername());
			response_json.put("reservation_duration", reservation.GetDuration());
			response_json.put("reservation_date_time", reservation.GetReservationDateTime());
			response_json.put("reservation_end_date_time", reservation.GetExpectedEndDateTime());

			return response_json;
		}
		catch(Exception e) {
			return null;
		}
	}
}
