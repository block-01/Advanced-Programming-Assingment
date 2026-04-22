async function ServerMain() {

	// Main function for adding server info to the dashboard.
	const ServerElement = document.getElementById("server_view");
	ServerElement.id = "server";

	const TableLength = await FetchItemTableLength();
	const DatabaseIDs = await FetchItemTableIDs();

	if (TableLength == 0){
		// If there are no servers in the database then a message about how to add new servers is displayed instead.
		AddServer = document.createElement("p").innerHTML = "Unable to find any servers. To add a new server go to.";
		ServerElement.append(AddServer);
	}

	try {
		for (i = 0; i <= TableLength; i++) {
			// Iterates over the DatabaseIDs List and uses the Item ID to request data from the backend database.

			const id = DatabaseIDs[i];
			const result = await FetchServer(id);
			if (result == null || !result) {
				break;
			}

			const ServerInfoChild = await AddServer(result, id);
			if (ServerInfoChild == null || !ServerInfoChild) {
				break;
			}

			ServerElement.append(ServerInfoChild);
		}
	} catch (error) {
		console.error(error);
	}
}

async function AddServer(contents, id) {
	/* This function takes the information about servers and formats it in HTML which then gets
	added to the dashboard and rendered to the user.
	 */
	try{
		// creates the server tile on the dashboard.
		const server_info = document.createElement("div");
		server_info.id = "server_info";

		// Fetches the servers current status and updates the servers uptime.
		const status = await CheckClientServerStatus(contents.net_ip);
		server_status = document.createElement("a");
		server_status.id = "server_status";
		const uptime = await ServerUptime(contents.net_ip);

		if (status && uptime) {
			server_status.title = "Server: '" + contents.server_name + "' is currently online.\nServer has been online for " + uptime + ".";
			server_status.innerHTML = '<svg id="server_status_icon" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/server-status-online-light.png" /></svg>';
		}
		else if (!status) {
			server_status.title = "Server: '" + contents.server_name + "' or the backend client are currently offline.";
			server_status.innerHTML = '<svg id="server_status_icon" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/server-status-offline-light.png" /></svg>';
		}
		server_info.append(server_status);


		// Fetches the Server Reservation and adds an icon with the reservation info

		server_booking = document.createElement("a");
		server_booking.id = "server_status";
		const server_reservation = await FetchServerReservation(contents.os_hostname);

		if (server_reservation) {
			server_booking.title = "Server: " + contents.os_hostname + "\nReserved by: " + server_reservation.Username + "\nStarting at: " + server_reservation.ReservationStart + "\nFinishing at: " + server_reservation.ReservationEnd + "\nDuration: " + server_reservation.Duration + " hours";
			server_booking.innerHTML = '<svg id="server_booking_icon_reserved" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/server-booked-light.png" /></svg>';

		}
		else if (!server_reservation) {
			server_booking.title = "Server: " + contents.os_hostname + " is currently not reserved.";
			server_booking.innerHTML = '<svg id="server_booking_icon_free" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/server-un-booked-light.png" /></svg>';
		}

		server_info.append(server_booking);

		// Adds the name of the server to the server tile on the dashboard.
		server_name = document.createElement("h4");
		server_name.id = "server_name";
		server_name.innerHTML = "Server name: " + contents.server_name;
		server_info.append(server_name);

		// Adds the Operating Systems version on the server to the server tile on the dashboard.
		os_version = document.createElement("p");
		os_version.id = "os_version";
		os_version.innerHTML = "OS Version: " + contents.os_version;
		server_info.append(os_version);

		// Adds the hostname name of the servers Operating System to the server tile on the dashboard.
		os_hostname = document.createElement("p");
		os_hostname.id = "os_hostname";
		os_hostname.innerHTML = "Hostname: " + contents.os_hostname;
		server_info.append(os_hostname);

		// Adds the IP address/URL of the server to the server tile on the dashboard.
		net_ip = document.createElement("p");
		net_ip.id = "net_ip";
		net_ip.innerHTML = "Server IP: " + contents.net_ip;
		server_info.append(net_ip);

		// Adds the name of CPU architecture of the servers CPU to the server tile on the dashboard. (often X86_64 or arm64/aarch64)
		os_cpu_arch = document.createElement("p");
		os_cpu_arch.id = "os_cpu_arch";
		os_cpu_arch.innerHTML = "CPU architecture: " + contents.os_cpu_arch;
		server_info.append(os_cpu_arch);

		// Adds the core count of the servers CPU to the server tile on the dashboard.
		os_cpu_cores = document.createElement("p");
		os_cpu_cores.id = "os_cpu_cores";
		os_cpu_cores.innerHTML = "CPU core Count: " + contents.os_cpu_cores;
		server_info.append(os_cpu_cores);

		// Adds the number of threads of the servers CPU to the server tile on the dashboard.
		os_cpu_threads = document.createElement("p");
		os_cpu_threads.id = "os_cpu_threads";
		os_cpu_threads.innerHTML = "CPU thread count: " + contents.os_cpu_threads;
		server_info.append(os_cpu_threads);

		// Adds the amount of RAM the server has to the server tile on the dashboard.
		os_hard_ram = document.createElement("p");
		os_hard_ram.id = "os_hard_ram";
		os_hard_ram.innerHTML = "RAM size: " + contents.os_hard_ram;
		server_info.append(os_hard_ram);


		// Adds a delete button to the server tile on the dashboard.
		delete_button = document.createElement("button");
		delete_button_a = document.createElement("a");
		delete_button_a.id = "delete_button";
		delete_button_a.onclick = function(){DeleteItemFromDatabase(id,contents.server_name)};
		delete_button_a.title="Remove Server from Dashboard";
		delete_button_a.style = "width:auto;";

		// Adds a view server button to the server tile on the dashboard.
		view_button = document.createElement("button");
		view_button_a = document.createElement("a");
		view_button_a.id = "view_button";
		view_button_a.title="View more information about the Server."
		view_button_a.style = "width:auto;";

		// Adds the icons to the delete and view info buttons.
		delete_button_a.innerHTML = '<svg id="remove_server_icon" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/delete_server_light.png" /></svg>';
		view_button_a.innerHTML = '<a href="/server/' + id +'"><svg id="view_server_icon" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/view_server_light.png" /></svg></a>';

		// appends the delete and view info buttons to the server tile on the dashboard.
		server_info.append(delete_button);
		delete_button.append(delete_button_a);
		server_info.append(view_button);
		view_button.append(view_button_a);

		return server_info;
	} catch (error){
		console.error(error.message)
		return null;
	}
}


/*
API Call functions used to make calls to the backend API
*/

async function FetchServer(id) {
	/* This function uses the ID of a server to fetch information from the dashboards backend database.
	 */
	try{
		const ApiResponse = await fetch('http://' + window.location.host  + '/dashboard/fetch_server/' + id);
		if (!ApiResponse.ok) {
			return null;
		}

		const ApiResultText = await ApiResponse.text();
		if (!ApiResultText || !ApiResultText.trim()) {
			console.error("Server returned an empty response for id =", id);
			return null;
		}

		const ApiResult = JSON.parse(ApiResultText);

		return ApiResult;
	} catch(error) {
		console.error(error.message);
		return null;
	}
}


async function FetchItemTableLength() {
	/* This function fetches the Length of the item table within the backend database and returns the length.
	 */
	try {
		const ApiResponse = await fetch('http://' + window.location.host + '/dashboard/fetch_item_table_length');
		if (!ApiResponse.ok) {
			return null;
		}

		const ApiResultText = await ApiResponse.text();
		if (!ApiResultText || !ApiResultText.trim()) {
			console.error("Unable to fetch length of Item table.")
			return null;
		}

		return Number(ApiResultText);
	} catch(error) {
		console.error(error.message);
		return null;
	}
}

async function FetchItemTableIDs() {
	/* This function fetches the IDs for all items within the ITEM table and returns a list of the IDs.
	*/
	try {
		const ApiResponse = await fetch('http://' + window.location.host + '/database/ListIDs');
		if (!ApiResponse.ok) {
			return null;
		}
		const ApiResultText = await ApiResponse.text();

		if (!ApiResultText || !ApiResultText.trim()) {
			console.error("Server returned an empty response");
		}

		const ApiResultReplace1 = ApiResultText.replace("[","");
		const ApiResultReplace2 = ApiResultReplace1.replace("]","");
		const ApiResultList = ApiResultReplace2.split(",");

		return ApiResultList;
	} catch (error) {
		console.error(error.message);
		return null;
	}
}

async function DeleteItemFromDatabase(id, ServerName){
	/* This function takes in the ID and name of a Server within dashboard and removes it
	from the dashboard.
	*/
	try {
		let delete_check = prompt("To confirm the deletion of '" + ServerName + "' from the dashboard please enter the name and click 'OK'.");
		if (delete_check == ServerName){
			const ApiResponse = await fetch('http://' + window.location.host + '/database/delete/' + id, { method: 'DELETE' });

			if (!ApiResponse.ok) {
				console.error("Failed to remove Server from dashboard.")
				return alert("Failed to Delete '" + ServerName + "'.\nPlease try again later");
			}

			confirm("'" + ServerName +"' has been successfully removed from the Dashboard")
			return location.reload();
		}
		else {
			return null;
		}
	} catch (error) {
		console.error(error.message);
		return alert("Failed to Delete '" + ServerName + "'.\nPlease try again later");
	}
}

async function CheckClientServerStatus(server_ip) {
	/* This function checks to see if the client on the target server is online.
	 */
	try {
		const ApiResponse = await fetch('http://' + window.location.host + '/api/client/status/' + server_ip, { method: 'GET' });
		console.log(ApiResponse);
		if (!ApiResponse.ok) {
			return false;
		}
		return true;
	} catch (error) {
		console.error(error.message);
		return false;
	}
}

async function ServerUptime(server_ip) {
	/* This function fetches the uptime of the target server.
	 */
	try {
		const ApiResponse = await fetch('http://' + window.location.host + '/api/client/uptime/' + server_ip, { method: 'GET' });
		console.log(ApiResponse);
		if (!ApiResponse.ok) {
			return null;
		}
		const ApiResultText = await ApiResponse.text();
		if (!ApiResultText || !ApiResultText.trim()) {
			console.error("Unable to fetch servers uptime.")
			return null;
		}

		const ApiResultReplace1 = ApiResultText.replace('{"os_uptime":"up', "");
		const ApiResultReplace2 = ApiResultReplace1.replace('"}',"");
		return ApiResultReplace2;
	} catch (error) {
		console.error(error.message);
		return null;
	}
}

async function FetchServerReservation(hostname){
	/* Fetches information about server reservations */
	try{
		const ApiResponse = await fetch('http://' + window.location.host + '/reservations/' + hostname, { method: 'GET' });

		if (! ApiResponse.ok){
			console.error("Unable to fetch server reservation.");
			return null
		}
		const ApiResultText = await ApiResponse.text();
		if (!ApiResultText || !ApiResultText.trim()) {
			console.error("Server returned an empty response for hostname:",hostname);
			return null;
		}

		const ApiResult = JSON.parse(ApiResultText);
		return ApiResult;
	}
	catch (error){
		console.error(error.message);
		return null;
	}
}

async function AddServerReservation(hostname) {
	/* Adds information about server reservations to the view_server page. */
	try{
		const server_reservation = await FetchServerReservation(hostname);

		const server_reservation_info_root = document.getElementById("server_reservation_info");
		const server_reservation_info = document.createElement("a")
		server_reservation_info.id = "server_info";
		server_reservation_info_root.append(server_reservation_info);

		reservation_title = document.createElement("h4");
		reservation_title.innerHTML = "Reservation Status: " + hostname;
		server_reservation_info.append(reservation_title);

		server_booking = document.createElement("a");
		if (server_reservation) {
			server_booking.title = "Server is currently reserved";
			server_booking.innerHTML = '<svg id="server_booking_icon_reserved" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/server-booked-light.png" /></svg>';
			server_reservation_info.append(server_booking);

			server_reservation_user = document.createElement("p");
			server_reservation_user.innerHTML = "Reserved by: " + server_reservation.Username;
			server_reservation_info.append(server_reservation_user);

			server_reservation_start = document.createElement("p");
			server_reservation_start.innerHTML = "Started at: " + server_reservation.ReservationStart;
			server_reservation_info.append(server_reservation_start);

			server_reservation_duration = document.createElement("p");
			server_reservation_duration.innerHTML = "Reservation Duration: " + server_reservation.Duration + " hours";
			server_reservation_info.append(server_reservation_duration);

			server_reservation_end = document.createElement("p");
			server_reservation_end.innerHTML = "Finishing at: " + server_reservation.ReservationEnd;
			server_reservation_info.append(server_reservation_end);
		}
		else if (!server_reservation) {
			server_booking.title = "Server is currently not reserved.";
			server_booking.innerHTML = '<svg id="server_booking_icon_free" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/server-un-booked-light.png" /></svg>';
			server_reservation_info.append(server_booking);

			server_reservation_none = document.createElement("p");
			server_reservation_none.innerHTML = "Server is currently not reserved";
			server_reservation_info.append(server_reservation_none);
		}

	} catch(error){
		console.error(error.message)
	}
}
