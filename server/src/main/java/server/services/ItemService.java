package server.services;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.models.Item;
import server.repository.ItemRepository;

/**
 * Functions for interacting with the Database.
 *
 * @author TODO
 */
@Service
public class ItemService {

	private final ItemRepository itemRepository;

	/**
	 * @param itemRepository
	 */
	public ItemService(ItemRepository itemRepository) {

		this.itemRepository = itemRepository;
	}

	/**
	 * Fetch an item from the database.
	 *
	 * @param id The ID of the Item to be fetched from the database.
	 *
	 * @return The Item that was fetched from the database.
	 */
	public Item GetItem(Long id){

			Item item = this.itemRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
		return item;
	}

	/**
	 * Save Item to the database
	 *
	 * @param item The Item variable to be saved to the database.
	 *
	 * @return The Item that has been added to the database.
	 */
	public Item AddItem(Item item){
		return itemRepository.save(item);
	}

	/**
	 * Fetch the length of the item table in the database.
	 *
	 * @return The length of the Item table.
	 */
	public long GetItemTableLength(){
		return itemRepository.count();
	}
}
