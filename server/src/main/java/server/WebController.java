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

	@GetMapping("/error")
	public String Error() {
		// error page mapping.
		return "error";
	}

	@GetMapping("/servers/view/{id}")
	public String ViewServerPage() {
		// error page mapping.
		return "servers/view_server";
	}
}
