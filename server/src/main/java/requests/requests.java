package requests;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class requests {

	static HttpClient client = HttpClient.newHttpClient();

	public static JSONObject  GET(String url){//, HashMap<String, String> args){
		// if (args)
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://"+url)).GET().build();
		try{

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			Object response_json = JSONValue.parse(response.body());

			JSONObject return_json = (JSONObject) response_json;
			return_json.put("statuscode", response.statusCode());
			return return_json;

	} catch (IOException | InterruptedException e){

		return null;
	}
	}

	// public HttpResponse<String> POST(String url, HashMap<String, String> args) {
	// 	HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).POST().build();
	// 	try {

	// 		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	// 		return response;

	// 	} catch (IOException | InterruptedException e) {

	// 		return null;
	// 	}
	// }

}

// class RequestHelpers{

// }
