package server.api;


import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import requests.requests;

@RestController
public class ClientRequests {

	@GetMapping("/api/client/status")
	public JSONObject ClientServerStatus(
		@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * client status Api.
		 *
		 * API URL: "/api/client/status"
		 * API call type : GET
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 *
		 * Returns:
		 * 		If the client is online.
		 */

		String url = ClientIP + "/api/serverstatus";
		JSONObject api = requests.GET(url);

		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;
	}

	@GetMapping("/api/client/info")
	public JSONObject ClientFullInfo(
			@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * Info Api.
		 *
		 * API URL: "/api/client/info"
		 * API call type : GET
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 *
		 * Returns:
		 * 		All info about the system.
		 */

		String url = ClientIP + "/api/info/full";
		JSONObject api = requests.GET(url);

		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;
	}

	@GetMapping("/api/client/info/os")
	public JSONObject ClientOsInfo(
			@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * OS info Api.
		 *
		 * API URL: "/api/client/info/os"
		 * API call type : GET
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 *
		 * Returns:
		 * 		OS info.
		 */

		String url = ClientIP + "/api/info/os";
		JSONObject api = requests.GET(url);

		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;
	}

	@GetMapping("/api/client/info/os/usage")
	public JSONObject ClientOsUsageInfo(
			@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * OS usage Api.
		 *
		 * API URL: "/api/client/info/os/usage"
		 * API call type : GET
		 *
		 * Returns:
		 * 		OS usage statistics.
		 */

		String url = ClientIP + "/api/info/os/usage";
		JSONObject api = requests.GET(url);

		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;
	}

	@GetMapping("/api/client/info/os/network")
	public JSONObject ClientOsNetworkInfo(
			@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * Network info Api.
		 *
		 * API URL: "/api/client/info/os/network"
		 * API call type : GET
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 *
		 * Returns:
		 * 		Networking info.
		 */

		String url = ClientIP + "/api/info/os/network";
		JSONObject api = requests.GET(url);

		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;
	}

	@GetMapping("/api/client/info/hardware")
	public JSONObject ClientHardwareInfo(
			@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * Hardware info Api.
		 *
		 * API URL: "/api/client/info/hardware"
		 * API call type : GET
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 *
		 * Returns:
		 * 		Info about the hardware.
		 */

		String url = ClientIP + "/api/info/hardware";
		JSONObject api = requests.GET(url);

		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;
	}

	@GetMapping("/api/client/info/hardware/cpu")
	public JSONObject ClientHardwareCpuInfo(
			@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * CPU info Api.
		 *
		 * API URL: "/api/client/info/hardware/cpu"
		 * API call type : GET
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 *
		 * Returns:
		 * 		Info about the CPU.
		 */

		String url = ClientIP + "/api/info/hardware/cpu";
		JSONObject api = requests.GET(url);

		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;
	}

	@GetMapping("/api/client/info/hardware/cpu/usage")
	public JSONObject ClientHardwareCpuUsageInfo(
			@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * CPU usage Api.
		 *
		 * API URL: "/api/client/info/hardware/cpu/usage"
		 * API call type : GET
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 *
		 * Returns:
		 * 		CPU usage statistics.
		 */

		String url = ClientIP + "/api/info/hardware/cpu/usage";
		JSONObject api = requests.GET(url);

		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;

	}

	@GetMapping("/api/client/info/hardware/ram")
	public JSONObject ClientHardwareRamInfo(
			@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * RAM Info Api.
		 *
		 * API URL: "/api/client/info/hardware/ram"
		 * API call type : GET
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 *
		 * Returns:
		 * 		Info about the RAM.
		 */

		String url = ClientIP + "/api/info/hardware/ram";
		JSONObject api = requests.GET(url);

		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;
	}

	@GetMapping("/api/client/info/hardware/ram/usage")
	public JSONObject ClientHardwareRamUsageInfo(
			@RequestParam("TargetIP") String ClientIP
		){
		/*
		 * RAM usage Api.
		 *
		 * API URL: "/api/client/info/hardware/ram/usage"
		 * API call type : GET
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 *
		 * Returns:
		 * 		The RAM usage statistics.
		 */

		String url = ClientIP + "/api/info/hardware/ram/usage";
		JSONObject api = requests.GET(url);

		if ((int)api.get("statuscode") == 200){
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error","Unable to fetch: '"+url+"'");
		return error;
	}

	@PostMapping("/api/client/reserve_server")
	public JSONObject ClientReserveServer(
			@RequestParam("TargetIP") String ClientIP,
			@RequestParam("Username") String Username,
			@RequestParam("Duration") int Duration
	){
		/*
		 * Server reservation Api.
		 *
		 * API URL: "/api/client"
		 * API call type : POST
		 *
		 * Args:
		 * 		TargetIP: The URL or IP with the port of the target system.
		 * 		Username: The name of the user who wants to book the server.
		 * 		Duration: How long the user wants to reserve the server for.
		 *
		 * Returns:
		 * 		The status of the reservation.
		 */

		HashMap<String,String> ApiInput = new HashMap<String,String>();
		ApiInput.put("username", Username);
		ApiInput.put("duration", "" + Duration);

		String url = ClientIP + "/api/reserve-server";
		JSONObject api = requests.POST(url, ApiInput);
		if ((int) api.get("statuscode") == 200) {
			api.remove("statuscode");
			return api;
		}

		JSONObject error = new JSONObject();
		error.put("error", "Unable to fetch: '" + url + "'");
		return error;
	}
}
