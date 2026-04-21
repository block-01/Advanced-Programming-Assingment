package server.dashboard;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import server.services.ItemService;
import server.api.ClientRequests;
import server.models.Item;

/**
 * Functions and API calls used by the frontend dashboard.
 *
 * @author Lily Wilks
 */
@Controller
public class Dashboard {

	private ItemService itemService;

	/**
	 *
	 */
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
		@RequestParam("ServerIP") String ServerIP
	){
		try{
			JSONObject status_check = ClientRequests.ClientServerStatus(ServerIP);
			if (status_check.get("status").equals("online")){
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
			}
			else{
				System.err.println("unable to find Server");
			}
			return "redirect:/";
		}
		catch(Exception e){
			System.err.println("ERROR: Failed to add server\n" + e);
			return null;
		}
	}
}
