package server.api;


import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import requests.requests;

@RestController
public class ClientRequests {

	@GetMapping("/api/clientstatus")
	public JSONObject ClientServerStatus(
		@RequestParam("TargetIP") String ClientIP
	){
		return requests.GET(ClientIP + "/api/serverstatus");
	}

	@GetMapping("/api/client/info")
	public JSONObject ClientFullInfo(
			@RequestParam("TargetIP") String ClientIP) {
		return requests.GET(ClientIP + "/api/info/full");
	}

	@GetMapping("/api/client/info/os")
	public JSONObject ClientOsInfo(
			@RequestParam("TargetIP") String ClientIP) {
		return requests.GET(ClientIP + "/api/info/os");
	}

	@GetMapping("/api/client/info/os/usage")
	public JSONObject ClientOsUsageInfo(
			@RequestParam("TargetIP") String ClientIP) {
		return requests.GET(ClientIP + "/api/info/os/usage");
	}

	@GetMapping("/api/client/info/os/network")
	public JSONObject ClientOsNetworkInfo(
			@RequestParam("TargetIP") String ClientIP) {
		return requests.GET(ClientIP + "/api/info/os/network");
	}

	@GetMapping("/api/client/info/hardware")
	public JSONObject ClientHardwareInfo(
			@RequestParam("TargetIP") String ClientIP) {
		return requests.GET(ClientIP + "/api/info/hardware");
	}

	@GetMapping("/api/client/info/hardware/cpu")
	public JSONObject ClientHardwareCpuInfo(
			@RequestParam("TargetIP") String ClientIP) {
		return requests.GET(ClientIP + "/api/info/hardware/cpu");
	}

	@GetMapping("/api/client/info/hardware/cpu/usage")
	public JSONObject ClientHardwareCpuUsageInfo(
			@RequestParam("TargetIP") String ClientIP) {
		return requests.GET(ClientIP + "/api/info/hardware/cpu/usage");
	}

	@GetMapping("/api/client/info/hardware/ram")
	public JSONObject ClientHardwareRamInfo(
			@RequestParam("TargetIP") String ClientIP) {
		return requests.GET(ClientIP + "/api/info/hardware/ram");
	}

	@GetMapping("/api/client/info/hardware/ram/usage")
	public JSONObject ClientHardwareRamUsageInfo(
			@RequestParam("TargetIP") String ClientIP
		) {
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
}
