package server.database;

import server.models.Item;
import server.repository.ItemRepository;
import server.services.ItemService;

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
}
