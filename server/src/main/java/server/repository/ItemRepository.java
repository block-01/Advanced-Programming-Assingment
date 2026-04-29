package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import server.models.Item;

/**
 * Interface for interacting with the Database.
 *
 * @author Lily Wilks
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

	/**
	 * Searches the Item table for a record with the matching IP address.
	 *
	 * @param net_ip The IP address of the server being searched for within the Item Table.
	 *
	 * @return If a record with the IP address is present the record is returned.
	 */
	@Query(value = "SELECT * FROM item WHERE net_ip=?", nativeQuery = true)
	Item findbynet_ip(String net_ip);
}
