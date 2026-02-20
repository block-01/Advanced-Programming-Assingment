package requests;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class requests {

	static HttpClient client = HttpClient.newHttpClient();

	public static JSONObject  GET(String url){
		/*
		 * GET api call
		 *
		 * Args:
		 * 		url: The IP/URL to the server
		 *
		 * Returns:
		 * 		The contents of what was returned from the API.
		 */
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

	public static JSONObject POST(String url, HashMap<String, String> args) {
		/* POST api call
		 *
		 * Args:
		 * 		url: The IP/URL to the server
		 * 		args: Any additional arguments
		 *
		 * Returns:
		 * 		The contents of what was returned from the API.
		 */
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("http://" + url))
			.header("Content-Type", "application/x-www-form-urlencoded")
			.POST(HttpRequest.BodyPublishers.ofString(RequestHelpers.HashMapToApiInput(args)))
			.build();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			Object response_json = JSONValue.parse(response.body());

			JSONObject return_json = (JSONObject) response_json;
			return_json.put("statuscode", response.statusCode());
			return return_json;

		} catch (IOException | InterruptedException e) {

			return null;
		}
	}

}

class RequestHelpers{
	static String HashMapToApiInput(HashMap<String, String> args){
		/* Converts a Hash map to the required input for an API call.
		 *
		 * Args:
		 * 		args: The arguments to be converted into a format useable by the API call.
		 *
		 * Returns:
		 * 		A format that can be used by the API call.
		 */
		StringBuilder FormBuilder = new StringBuilder();

		for (Map.Entry<String, String> entry : args.entrySet()){
			if (FormBuilder.length() > 0 ){
				FormBuilder.append("&");
			}
			FormBuilder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
			FormBuilder.append("=");
			FormBuilder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
		}
		return FormBuilder.toString();
	}
}
