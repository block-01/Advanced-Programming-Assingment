package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
