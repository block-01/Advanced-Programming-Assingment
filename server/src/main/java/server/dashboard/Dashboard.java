package server.dashboard;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import server.services.ItemService;
import server.api.ClientRequests;
import server.models.Item;
import server.repository.ItemRepository;

/**
 * Functions and API calls used by the frontend dashboard.
 *
 * @author Lily Wilks
 * @since 1.0.0
 */
@Controller
public class Dashboard {

	@Autowired
	ItemRepository ItemRepo;
	private ItemService itemService;

	public Dashboard(ItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * Add a server to the list
	 *
	 * @url /dashboard/add_server
	 * @method POST
	 *
	 * @param ServerName The name of the target server.
	 * @param ServerIP The DNS name or IP address of the server.
	 *
	 * @return The next page to load.
	 */
	@PostMapping("/dashboard/add_server")
	public String AddServer(
		@RequestParam("ServerName") String ServerName,
		@RequestParam("ServerIP") String ServerIP,
		Model model
	){
		try{
			JSONObject status_check = ClientRequests.ClientServerStatus(ServerIP);
			if (ServerIP.equals("localhost:5000")){
				model.addAttribute("add_server_status_localhost", true);

				return "index";
			}
			if (status_check.get("status").equals("online")){
				if (ItemRepo.findbynet_ip(ServerIP) != null){
					model.addAttribute("add_server_status_exists", true);
					model.addAttribute("server_name", ServerName);

					return "index";
				}
					JSONObject data = ClientRequests.ClientFullInfo(ServerIP);
					Item item = new Item();

					item.SetServerName("" + ServerName);
					item.SetOsHostname("" + data.get("os_hostname"));
					item.SetOsShell("" + data.get("os_shell"));
					item.SetOsVersion("" + data.get("os_version"));
					item.SetNetIP(ServerIP);
					item.SetNetMacAddress("" + data.get("net_mac_address"));
					item.SetCpuArch("" + data.get("os_cpu_arch"));
					item.SetCpuCores("" + data.get("os_cpu_cores"));
					item.SetCpuCoreClockMax("" + data.get("os_cpu_core_clock_max"));
					item.SetCpuCoreClockMin("" + data.get("os_cpu_core_clock_min"));
					item.SetCpuThreads("" + data.get("os_cpu_threads"));
					item.SetRam("" + data.get("os_hard_ram"));
					itemService.AddItem(item);

					return "redirect:/";
			}
			model.addAttribute("add_server_status_not_found", true);
			model.addAttribute("server_name", ServerName);
			System.err.println("ERROR: Unable to find Server");

			return "index";
		}
		catch(Exception e){
			System.err.println("ERROR: Failed to add server\n" + e);
			model.addAttribute("add_server_status_error", true);
			model.addAttribute("server_name", ServerName);

			return "index";
		}
	}
}
