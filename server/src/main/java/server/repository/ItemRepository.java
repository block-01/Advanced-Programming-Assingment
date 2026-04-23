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

	@Query(value = "SELECT * FROM item WHERE net_ip=?", nativeQuery = true)
	Item findbynet_ip(String net_ip);
}
