package server.database;

import server.models.Item;
import server.repository.ItemRepository;
import server.services.ItemService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


@RestController
public class ItemController {

	private ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping("/database/{id}")
	public void GetItem(
		@PathVariable("id") long id,
		Model model
	){
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
	}

	@PostMapping("/database/add")
	public void AddItem(){}

	@GetMapping("/dashboard/fetch_server/{id}")
	public JSONObject FetchServer(@PathVariable("id") long id){
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
	}

	@GetMapping("/dashboard/fetch_item_table_length")
	public long GetItemLength(){
		return itemService.GetItemTableLength();
	}
}
