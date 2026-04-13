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

			const ServerInfoChild = AddServer(result, id);
			if (ServerInfoChild == null || !ServerInfoChild) {
				break;
			}

			ServerElement.append(ServerInfoChild);
		}
	} catch (error) {
		console.error(error);
	}
}

function AddServer(contents, id) {
	/* This function takes the information about servers and formats it in HTML which then gets
	added to the dashboard and rendered to the user.
	 */
	try{
		const server_info = document.createElement("div");
		server_info.id = "server_info";

		server_name = document.createElement("h4");
		server_name.id = "server_name";
		server_name.innerHTML = "Server name: " + contents.server_name;
		server_info.append(server_name);

		os_version = document.createElement("p");
		os_version.id = "os_version";
		os_version.innerHTML = "OS Version: " + contents.os_version;
		server_info.append(os_version);

		os_hostname = document.createElement("p");
		os_hostname.id = "os_hostname";
		os_hostname.innerHTML = "Hostname: " + contents.os_hostname;
		server_info.append(os_hostname);

		net_ip = document.createElement("p");
		net_ip.id = "net_ip";
		net_ip.innerHTML = "Server IP: " + contents.net_ip;
		server_info.append(net_ip);

		os_cpu_arch = document.createElement("p");
		os_cpu_arch.id = "os_cpu_arch";
		os_cpu_arch.innerHTML = "CPU architecture: " + contents.os_cpu_arch;
		server_info.append(os_cpu_arch);

		os_cpu_cores = document.createElement("p");
		os_cpu_cores.id = "os_cpu_cores";
		os_cpu_cores.innerHTML = "CPU core Count: " + contents.os_cpu_cores;
		server_info.append(os_cpu_cores);

		os_cpu_threads = document.createElement("p");
		os_cpu_threads.id = "os_cpu_threads";
		os_cpu_threads.innerHTML = "CPU thread count: " + contents.os_cpu_threads;
		server_info.append(os_cpu_threads);

		os_hard_ram = document.createElement("p");
		os_hard_ram.id = "os_hard_ram";
		os_hard_ram.innerHTML = "RAM size: " + contents.os_hard_ram;
		server_info.append(os_hard_ram);

		delete_button = document.createElement("button");

		delete_button_a = document.createElement("a");
		delete_button_a.id = "delete_button";
		delete_button_a.onclick = function(){DeleteItemFromDatabase(id,contents.server_name)};
		delete_button_a.title="Remove Server from Dashboard";
		delete_button_a.style = "width:auto;";

		view_button = document.createElement("button");
		view_button_a = document.createElement("a");
		view_button_a.id = "view_button";
		view_button_a.title="View more information about the Server."
		view_button_a.style = "width:auto;";

		delete_button_a.innerHTML = '<svg id="remove_server_icon" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/delete_server_light.png" /></svg>';
		view_button_a.innerHTML = '<a href="/server/' + id +'"><svg id="view_server_icon" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/view_server_light.png" /></svg></a>';

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


async function FetchServer(id) {
	/* This function uses the ID of a server to fetch information from the dashboards backend database.
	 */
	try{
		const ApiResponse = await fetch('http://localhost:25580/dashboard/fetch_server/' + id);
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
		const ApiResponse = await fetch('http://localhost:25580/dashboard/fetch_item_table_length');
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
		const ApiResponse = await fetch('http://localhost:25580/database/ListIDs');
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
			const ApiResponse = await fetch('http://localhost:25580/database/delete/' + id, { method: 'DELETE' });

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
