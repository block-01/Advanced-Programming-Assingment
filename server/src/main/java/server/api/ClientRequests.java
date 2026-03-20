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
/**
 * API calls to make requests to the server clients.
 *
 * @author TODO
 */
public class ClientRequests {

	/**
	 * client status Api.
	 *
	 * @url /api/client/status
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return If the client is online.
	 */
	@GetMapping("/api/client/status")
	public static JSONObject ClientServerStatus(
		@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * Info Api.
	 *
	 * @url /api/client/info
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return All info about the system.
	 */
	@GetMapping("/api/client/info")
	public static JSONObject ClientFullInfo(
			@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * OS info Api.
	 *
	 * @url /api/client/info/os
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return OS info.
	 */
	@GetMapping("/api/client/info/os")
	public JSONObject ClientOsInfo(
			@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * OS usage Api.
	 *
	 * @url /api/client/info/os/usage
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return OS usage statistics.
	 */
	@GetMapping("/api/client/info/os/usage")
	public JSONObject ClientOsUsageInfo(
			@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * Network info Api.
	 *
	 * @url /api/client/info/os/network
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return Networking info.
	 */
	@GetMapping("/api/client/info/os/network")
	public JSONObject ClientOsNetworkInfo(
			@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * Hardware info Api.
	 *
	 * @url /api/client/info/hardware
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return Info about the hardware.
	 */
	@GetMapping("/api/client/info/hardware")
	public JSONObject ClientHardwareInfo(
			@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * CPU info Api.
	 *
	 * @url /api/client/info/hardware/cpu
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return Info about the CPU.
	 */
	@GetMapping("/api/client/info/hardware/cpu")
	public JSONObject ClientHardwareCpuInfo(
			@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * CPU usage Api.
	 *
	 * @url /api/client/info/hardware/cpu/usage
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return CPU usage statistics.
	 */
	@GetMapping("/api/client/info/hardware/cpu/usage")
	public JSONObject ClientHardwareCpuUsageInfo(
			@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * RAM Info Api.
	 *
	 * @url /api/client/info/hardware/ram
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return Info about the RAM.
	 */
	@GetMapping("/api/client/info/hardware/ram")
	public JSONObject ClientHardwareRamInfo(
			@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * RAM usage Api.
	 *
	 * @url /api/client/info/hardware/ram/usage
	 * @method GET
	 *
	 * @param ClientIP The URL or IP with the port of the target system.
	 *
	 * @return The RAM usage statistics.
	 */
	@GetMapping("/api/client/info/hardware/ram/usage")
	public JSONObject ClientHardwareRamUsageInfo(
			@RequestParam("TargetIP") String ClientIP
		){

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

	/**
	 * Server reservation Api.
	 *
	 * @url /api/client/reserve_server
	 * @method POST

	 *
	 * @param ClientIP  The URL or IP with the port of the target system.
	 * @param Username: The name of the user who wants to book the server.
	 * @param Duration: How long the user wants to reserve the server for.
	 *
	 * @return The status of the reservation.
	 */
	@PostMapping("/api/client/reserve_server")
	public JSONObject ClientReserveServer(
			@RequestParam("TargetIP") String ClientIP,
			@RequestParam("Username") String Username,
			@RequestParam("Duration") int Duration
	){

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
