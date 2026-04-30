package server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import server.database.ItemController;

/**
 * Web Controller Class for page mapping
 *
 * @author Lily Wilks
 * @since 1.0.0
 */
@Controller
public class WebController {

	/**
	 * Mapping for root page.
	 *
	 * @return index (root) page.
	 */
	@GetMapping("/")
	public String ShowRootPage(){
		return "index";
	}

	/**
	 * Error page mapping.
	 *
	 * @return Error page.
	 */
	@GetMapping("/error")
	public String Error() {
		return "error";
	}

	/**
	 * View Server page mapping.
	 *
	 * @param id The ID of the server being viewed.
	 * @param model The Model that server info gets added to.
	 * @return Server Info page.
	 */
	@GetMapping("/server/{id}")
	public String ViewServerPage(
		@PathVariable("id") long id,
		Model model
	) {
		ItemController.GetItem(id, model);
		return "view_server";
	}
}
