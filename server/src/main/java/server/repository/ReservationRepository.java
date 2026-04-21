package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import server.models.Reservation;

/**
 * Interface for interacting with the Reservations Database.
 *
 * @author Lily Wilks
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	/**
	 * Searching the reservation table by the server name.
	 *
	 * @param server_name The name of the server being searched for.
	 * @return The row in the table if found in the table.
	 */
	@Query(value = "SELECT * FROM reservation WHERE server_name=?", nativeQuery = true)
	Reservation findbyserver_name(String server_name);

	@Query(value = "SELECT * FROM reservation", nativeQuery = true)
	Reservation findbyservers();
}
