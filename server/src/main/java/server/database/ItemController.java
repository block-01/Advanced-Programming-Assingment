package server.database;

import server.models.Item;
import server.repository.ItemRepository;
import server.services.ItemService;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


/**
 * Item controller class for interacting with the database.
 *
 * @author Lily Wilks
 */
@RestController
public class ItemController {

	@Autowired
	ItemRepository ItemRepo;

	private static ItemService itemService;

	public ItemController(ItemService itemService) {
		ItemController.itemService = itemService;
	}

	/**
	 * Fetches server info from the database and adds it to the model for rendering in the dashboard.
	 *
	 * @param id The ID of the item within the database to fetch.
	 * @param model The Model that the server info is added to.
	 *
	 */
	@GetMapping("/database/{id}")
	public static void GetItem(
		@PathVariable("id") long id,
		Model model
	){
		try{
			Item item = itemService.GetItem(id);
			model.addAttribute("ServerName", item.GetServerName());
			model.addAttribute("Hostname", item.GetOsHostname());
			model.addAttribute("OsVersion", item.GetOsVersion());
			model.addAttribute("OsShell", item.GetOsShell());
			model.addAttribute("NetIP", item.GetNetIP());
			model.addAttribute("NetMacAddress", item.GetNetMacAddress());
			model.addAttribute("CpuArch", item.GetCpuArch());
			model.addAttribute("CpuCores", item.GetCpuCores());
			model.addAttribute("CpuCoreClockMax", item.GetCpuCoreClockMax());
			model.addAttribute("CpuCoreClockMin", item.GetCpuCoreClockMin());
			model.addAttribute("CpuThreads", item.GetCpuThreads());
			model.addAttribute("Ram", item.GetRam());

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * FetchServer
	 *
	 * Fetches data from the database.
	 *
	 * @url /dashboard/fetch_server/{id}
	 * @method GET
	 *
	 * @param id The ID of the row in the Item table.
	 *
	 * @return The contents of the row from the Item table
	 */
	@GetMapping("/dashboard/fetch_server/{id}")
	public JSONObject FetchServer(@PathVariable("id") long id){
		try{
			Item item = itemService.GetItem(id);

			JSONObject response_json = new JSONObject();

			response_json.put("server_name", item.GetServerName());
			response_json.put("os_version", item.GetOsVersion());
			response_json.put("os_hostname", item.GetOsHostname());
			response_json.put("os_shell", item.GetOsShell());
			response_json.put("net_ip", item.GetNetIP());
			response_json.put("net_mac_address", item.GetNetMacAddress());
			response_json.put("os_cpu_arch", item.GetCpuArch());
			response_json.put("os_cpu_cores", item.GetCpuCores());
			response_json.put("os_cpu_core_clock_max", item.GetCpuCoreClockMax());
			response_json.put("os_cpu_core_clock_min", item.GetCpuCoreClockMin());
			response_json.put("os_cpu_threads", item.GetCpuThreads());
			response_json.put("os_hard_ram", item.GetRam());
			return response_json;

		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	/**
	 * GetItemLength
	 *
	 * @url /dashboard/fetch_item_table_length
	 * @method GET
	 *
	 * @return The length of the Item table within the database.
	 */
	@GetMapping("/dashboard/fetch_item_table_length")
	public long GetItemLength(){
		try{
			return itemService.GetItemTableLength();

		} catch (Exception e) {
			System.err.println(e);
			return (Long) null;
		}
	}

	/**
	 * Deletes an Item from the table based off of the items ID.
	 *
	 * @param id The ID of the Item within the database to be deleted.
	 *
	 * @return If the operation was successfully completed.
	 */
	@DeleteMapping("/database/delete/{id}")
	public ResponseEntity<HttpStatus> DeleteItem(@PathVariable("id") long id){
		try{
			if (ItemRepo.existsById(id)){
				System.out.println("\nDeleted item " + id + " rom the database\n");
				ItemRepo.deleteById(id);
				if (ItemRepo.existsById(id) == false)
				{
					return new ResponseEntity<HttpStatus>(HttpStatus.OK);
				}
			}
			else {
				return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Fetches a list of all of the item IDs within the ITEM database table.
	 *
	 * @return A list of item IDs.
	 */
	@GetMapping("/database/ListIDs")
	public ArrayList<Long> ListItemIDs(){
		try{

			ArrayList<Long> ItemIDs = new ArrayList<Long>();
			List<Item> ItemList = ItemRepo.findAll();
			for (int size = 0; size < ItemList.size(); size++){
				ItemIDs.add(ItemList.get(size).GetID());
			}

			return ItemIDs;
		} catch (Exception e) {
			return null;
		}

	}
}
