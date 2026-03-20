package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.models.Item;

/**
 * Interface for interacting with the Database.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
}
