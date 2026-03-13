package server.dashboard;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import server.services.ItemService;
import server.api.ClientRequests;
import server.models.Item;

@Controller
public class Dashboard {

	private ItemService itemService;

	public Dashboard(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping("/dashboard/add_server")
	public String AddServer(
		@RequestParam("ServerName") String ServerName,
		@RequestParam("ServerIP") String ServerIP
	){
		JSONObject status_check = ClientRequests.ClientServerStatus(ServerIP);
		System.out.println("status check: \n" +status_check+"\n" + status_check.get("status") + "\n");
		if (status_check.get("status").equals("online")){
			System.out.println("Server Exists");
			JSONObject data = ClientRequests.ClientFullInfo(ServerIP);
			Item item = new Item();

			item.SetServerName("" + ServerName);
			item.SetOsHostname("" + data.get("os_hostname"));
			item.SetOsShell("" + data.get("os_shell"));
			item.SetOsVersion("" + data.get("os_version"));
			item.SetNetIP("" + data.get("net_ip"));
			item.SetNetMacAddress("" + data.get("net_mac_address"));
			item.SetCpuArch("" + data.get("os_cpu_arch"));
			item.SetCpuCores("" + data.get("os_cpu_cores"));
			item.SetCpuCoreClockMax("" + data.get("os_cpu_core_clock_max"));
			item.SetCpuCoreClockMin("" + data.get("os_cpu_core_clock_min"));
			item.SetCpuThreads("" + data.get("os_cpu_threads"));
			item.SetRam("" + data.get("os_hard_ram"));
			System.out.println("data\n" + data + "\n");
			System.out.println("os_hostname\n" + data.get("os_hostname") + "\n");
			System.out.println("os_shell\n" + data.get("os_shell") + "\n");
			System.out.println("os_version\n" + data.get("os_version") + "\n");
			System.out.println("net_ip\n" + data.get("net_ip") + "\n");
			System.out.println("net_mac_address\n" + data.get("net_mac_address") + "\n");
			System.out.println("os_cpu_arch\n" + data.get("os_cpu_arch") + "\n");
			System.out.println("os_cpu_cores\n" + data.get("os_cpu_cores") + "\n");
			System.out.println("os_cpu_core_clock_max\n" + data.get("os_cpu_core_clock_max") + "\n");
			System.out.println("os_cpu_core_clock_min\n" + data.get("os_cpu_core_clock_min") + "\n");
			System.out.println("os_cpu_threads\n" + data.get("os_cpu_threads") + "\n");
			System.out.println("os_hard_ram\n" + data.get("os_hard_ram") + "\n");

			System.out.println("item: \n" + item + "\n");
			itemService.AddItem(item);
		}
		else{
			System.err.println("unable to find Server");
		}
		return "index";
	}
}
