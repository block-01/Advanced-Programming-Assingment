package server.services;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.models.Item;
import server.repository.ItemRepository;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public Item GetItem(Long id){

			Item item = this.itemRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
		return item;
	}

	public Item AddItem(Item item){
		return itemRepository.save(item);
	}

	public long GetItemTableLength(){
		return itemRepository.count();
	}
}
