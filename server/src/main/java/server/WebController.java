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
}
