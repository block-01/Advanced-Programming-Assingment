package server.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerSideAPI {

	@GetMapping("/api/dashboard-status")
	public int DashboardStatus(){
		/*
		 * Dashboard Status Api.
		 *
		 * API URL: "/api/dashboard-status"
		 * API call type : GET
		 *
		 * Returns:
		 * 	That the dashboard is online.
		 */

		return 200;
	}
}
