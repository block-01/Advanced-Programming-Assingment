package server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import server.database.ItemController;

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

	@GetMapping("/server/{id}")
	public String ViewServerPage(
		@PathVariable("id") long id,
		Model model
	) {
		ItemController.GetItem(id, model);
		return "view_server";
	}
}
