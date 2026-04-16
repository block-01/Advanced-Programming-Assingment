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

/**
 * Class of functions related to making API requests.
 *
 * @author Lily Wilks
 */
public class requests {

	static HttpClient client = HttpClient.newHttpClient();

	/**
	 * GET api call
	 *
	 * @param url The IP/URL to the server
	 *
	 * @return The contents of what was returned from the API.
	 */
	public static JSONObject  GET(String url){

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

	/**
	 * POST api call
	 *
	 * @param url  The IP/URL to the server
	 * @param args Any additional arguments
	 *
	 * @return The contents of what was returned from the API.
	 */
	public static JSONObject POST(String url, HashMap<String, String> args) {

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

/**
 * Helper functions for the requests class.
 *
 * @author Lily Wilks
 */
class RequestHelpers{

	/**
	 * Converts a Hash map to the required input for an API call.
	 *
	 * @param args The arguments to be converted into a format useable by the API call.
	 *
	 * @return A format that can be used by the API call.
	 */
	static String HashMapToApiInput(HashMap<String, String> args){
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
