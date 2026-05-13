package server.reservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import server.models.Reservation;
import server.repository.ReservationRepository;
import server.services.ReservationService;

/**
 * Functions for server reservation.
 *
 * @author Lily Wilks
 * @since 1.0.0
 */
@RestController
public class ReservationFuncs {

	@Autowired
	ReservationRepository ReservationRepo;

	private ReservationService reservationService;

	public ReservationFuncs(ReservationService reservationService) {
		this.reservationService = reservationService;
	}


	/**
	 * Reserves the target server.
	 *
	 * @url /reservation/add
	 * @method POST
	 *
	 * @param Username The name of the user reserving the server.
	 * @param Duration The Duration the user is reserving the server for.
	 * @param Hostname The name of the server being reserved.
	 *
	 * @return If the reservation was successful or not.
	 */
	@PostMapping("/reservation/add")
	public ResponseEntity<HttpStatus> ReserveServer(
		@RequestParam("Username") String Username,
		@RequestParam("Duration") Long Duration,
		@RequestParam("Hostname") String Hostname
	){
		try{
			LocalDateTime ReservationDateTime = LocalDateTime.now();
			if (ReservationRepo.findbyserver_name(Hostname) == null){
				if (ReserverServerFunc(Username,Duration,Hostname,ReservationDateTime)){
					return new ResponseEntity<HttpStatus>(HttpStatus.OK);
				}
				return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			else if (CheckServerReservation(Hostname)){
				if (ReserverServerFunc(Username, Duration, Hostname, ReservationDateTime)){
					return new ResponseEntity<HttpStatus>(HttpStatus.OK);
				}
				return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			else{
				return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch(Exception e) {
			System.err.println("Failed to reserve server: " + e);
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * Reserve Server function handles all of the saving of the reservation to the database.
	 *
	 * @param Username The name of the user reserving the server.
	 * @param Duration The Duration the user is reserving the server for.
	 * @param Hostname The name of the server being reserved.
	 * @param ReservationDateTime The date and time the server was reserved.
	 *
	 * @return If the server was reserved correctly.
	 */
	private boolean ReserverServerFunc(
			String Username,
			Long Duration,
			String Hostname,
			LocalDateTime ReservationDateTime
		){
		try {
			Reservation reservation = new Reservation();

			reservation.SetUsername(Username);
			reservation.SetDuration(Duration);
			reservation.SetServerName(Hostname);
			reservation.SetReservationDateTime(ReservationDateTime);
			reservation.SetExpectedEndDateTime(ReservationDateTime.plusHours(Duration));

			reservationService.AddReservation(reservation);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Checks to see if a server is already reserved or not.
	 *
	 * @param Hostname The name of the server reservation being checked.
	 *
	 * @return If the reservation had expired or not.
	 */
	public boolean CheckServerReservation(String Hostname){
		try {
			Reservation record = ReservationRepo.findbyserver_name(Hostname);

			if (LocalDateTime.now().isBefore(record.GetExpectedEndDateTime())){
				return false;
			}
			else{
				ReservationRepo.deleteById(record.GetID());
				return true;
			}
		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			return (Boolean) null;
		}
	}

	/**
	 * Fetches the reservation of a desired server if present.
	 * If the reservation has expired then the reservation is removed.
	 *
	 * @url /reservation/{Hostname}
	 * @method GET
	 *
	 * @param Hostname The name of the server reservation being fetched.
	 *
	 * @return The server reservation that was fetched.
	 */
	@GetMapping("/reservations/{Hostname}")
	public HashMap<String, String> FetchServerReservation(@PathVariable("Hostname") String Hostname) {
		try {
			HashMap<String, String> reservation = new HashMap<String, String>();
			Reservation record = ReservationRepo.findbyserver_name(Hostname);

			if (LocalDateTime.now().isBefore(record.GetExpectedEndDateTime())) {
				reservation.put("Hostname", "" + record.GetServerName());
				reservation.put("Username", "" + record.GetUsername());
				reservation.put("ReservationStart", "" + record.GetReservationDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
				reservation.put("ReservationEnd", "" + record.GetExpectedEndDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
				reservation.put("Duration", "" + record.GetDuration());

				return reservation;

			} else {
				ReservationRepo.deleteById(record.GetID());

				return null;
			}
		} catch (Exception e) {
			System.err.println("ERROR: " + e);

			return null;
		}
	}

	/**
	 * Checks to see if a server is already reserved or not.
	 *
	 * @url /reservation/delete/{Hostname}
	 * @method DELETE
	 *
	 * @param Hostname The name of the server that the reservation is being removed.
	 *
	 * @return If the reservation had expired or not.
	 */
	@DeleteMapping("/reservations/delete/{Hostname}")
	public boolean DeleteServerReservation(@PathVariable("Hostname") String Hostname) {
		try {
			Reservation record = ReservationRepo.findbyserver_name(Hostname);

			if (record != null) {
				ReservationRepo.deleteById(record.GetID());
				return true;
			}
			return false;

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			return false;
		}
	}

	/**
	 * Fetches all servers that have been reserved.
	 *
	 * @url /reservation/all
	 * @method GET
	 *
	 * @return A List of Hashmaps containing all Servers that have been reserved.
	 */
	@GetMapping("/reservations/all")
	public ArrayList<HashMap<String, String>> FetchAllServers(){
		try {
			List<Reservation> reservations = ReservationRepo.findAll();
			ArrayList<HashMap<String, String>> returns = new ArrayList<HashMap<String, String>>();
			for (int i = 0; i < reservations.size(); i++){
				Reservation item = reservations.get(i);
				HashMap<String, String> reservation_item = new HashMap<String, String>();
				reservation_item.put("", ""+i);
				reservation_item.put("Hostname", "" + item.GetServerName());
				reservation_item.put("Username", "" + item.GetUsername());
				reservation_item.put("Reservation Start", "" + item.GetReservationDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
				reservation_item.put("Reservation End", "" + item.GetExpectedEndDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
				reservation_item.put("Duration(hours)", "" + item.GetDuration());
				returns.add(reservation_item);
			}
			return returns;
		} catch (Exception e) {
			return null;
		}

	}
}
