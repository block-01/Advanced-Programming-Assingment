package server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/")
	public String ShowRootPage(){
		// Mapping for root page.
		return "index";
	}

	@GetMapping("/settings")
	public String Settings() {
		// Settings page mapping.
		return "settings";
	}

	@GetMapping("/error")
	public String Error() {
		// error page mapping.
		return "error";
	}

	@GetMapping("/servers")
	public String ServersHomePage() {
		// error page mapping.
		return "servers/servers_homepage";
	}

	@GetMapping("/servers/add")
	public String AddServerPage() {
		// error page mapping.
		return "servers/add_server";
	}

	@GetMapping("/servers/remove")
	public String RemoveServersPage() {
		// error page mapping.
		return "servers/remove_server";
	}

	@GetMapping("/servers/view")
	public String ViewServersPage() {
		// error page mapping.
		return "servers/view_server";
	}
}
