package server.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Reservation datatype
 *
 * The Datatype and related functions for the Reservation table within the
 * database.
 *
 * @author Lily Wilks
 * @since 1.0.0
 */
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String server_name;
	private String username;
	private Long reservation_duration;
	private LocalDateTime reservation_date_time;
	private LocalDateTime expected_end_date_time;

	/**
	 * The Reservation datatype
	 */
	public Reservation(){}

	/**
	 * @param server_name The name of the server being reservation.
	 * @param username The name of the user reserving the server.
	 * @param reservation_duration The duration of the server reservation.
	 * @param reservation_date_time The time at which the server was reserved.
	 * @param expected_end_date_time The time at which the servers reservation is due to expire.
	 */
	public Reservation(
		String server_name,
		String username,
		Long reservation_duration,
		LocalDateTime reservation_date_time,
		LocalDateTime expected_end_date_time
	){
		this.server_name = server_name;
		this.username = username;
		this.reservation_duration = reservation_duration;
		this.reservation_date_time = reservation_date_time;
		this.expected_end_date_time = expected_end_date_time;
	}


	/**
	 * Setting an items ID.
	 *
	 * @param id The id that is being set.
	 */
	public void SetID(Long id) {
		this.id = id;
	}

	/**
	 * Fetches the ID of the Item.
	 *
	 * @return The id of the item in the database.
	 */
	public Long GetID() {
		return id;
	}


	/**
	 * Set the name of the server being reserved.
	 *
	 * @param ServerName The name of the server being reserved.
	 */
	public void SetServerName(String ServerName) {
		this.server_name = ServerName;
	}

	/**
	 * Fetch the name of the server that was reserved.
	 *
	 * @return The name of the server that was reserved.
	 */
	public String GetServerName() {
		return server_name;
	}


	/**
	 * Set the username of the user reserving the server.
	 *
	 * @param Username The username of the user reserving the server.
	 */
	public void SetUsername(String Username) {
		this.username = Username;
	}

	/**
	 * Fetch the username of the user reserving server.
	 *
	 * @return The name of the user that reserved the server.
	 */
	public String GetUsername() {
		return username;
	}


	/**
	 * Set the Duration of the server reservation.
	 *
	 * @param reservation_duration The duration of the server reservation.
	 */
	public void SetDuration(Long reservation_duration) {
		this.reservation_duration = reservation_duration;
	}

	/**
	 * Fetch the duration of server reservation.
	 *
	 * @return The duration of the server reservation.
	 */
	public Long GetDuration() {
		return reservation_duration;
	}

	/**
	 * Set the date and time at which the reservation of the server was made.
	 *
	 * @param reservation_date_time The duration of the server reservation.
	 */
	public void SetReservationDateTime(LocalDateTime reservation_date_time) {
		this.reservation_date_time = reservation_date_time;
	}

	/**
	 * Fetch the date and time at which the server reservation was made.
	 *
	 * @return The date and time the server reservation was made.
	 */
	public LocalDateTime GetReservationDateTime() {
		return reservation_date_time;
	}

	/**
	 * Set the date and time at which the reservation of the server is expected to
	 * end.
	 *
	 * @param expected_end_date_time The Time at which the server was reserved.
	 */
	public void SetExpectedEndDateTime(LocalDateTime expected_end_date_time) {
		this.expected_end_date_time = expected_end_date_time;
	}

	/**
	 * Fetch the date and time at which the server reservation is expected to end.
	 *
	 * @return The date and time the server reservation expects to end.
	 */
	public LocalDateTime GetExpectedEndDateTime() {
		return expected_end_date_time;
	}
}
