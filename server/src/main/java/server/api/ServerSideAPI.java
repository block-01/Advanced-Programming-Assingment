package server.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Server Side API functions for dashboard interactions.
 *
 * @author Lily Wilks
 */
@RestController
public class ServerSideAPI {

	/**
	 * Dashboard Status Api.
	 *
	 * @url /api/dashboard-status
	 * @method GET
	 *
	 * @return That the dashboard is online.
	 */
	@GetMapping("/api/dashboard-status")
	public int DashboardStatus(){
		return 200;
	}
}
