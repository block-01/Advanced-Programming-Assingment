async function ServerMain() {
	let i = 1;
	const TableLength = await FetchItemTableLength();

	const ServerElement = document.getElementById("server_view");
	ServerElement.id = "server";

	if (TableLength == 0){
		AddServer = document.createElement("p").innerHTML = "Unable to find any servers. To add a new server go to.";
		ServerElement.append(AddServer);
	}

	try {
		for (i = 1; i <= TableLength; i++) {

			const result = await FetchServer(i);
			if (result == null || !result) {
				break;
			}

			const ServerInfoChild = AddServer(result, i);
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
		delete_button.id = "delete_button";
		delete_button.title="Remove Server from Dashboard";
		// delete_button.onclick = "document.getElementById('" + "').style.display='block'";
		delete_button.style = "width:auto;";

		view_button = document.createElement("button");
		view_button.id = "view_button";
		view_button.title="View more information about the Server."
		view_button.style = "width:auto;";

		delete_button.innerHTML = '<svg id="remove_server_icon" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/delete_server_light.png" /></svg>';
		view_button.innerHTML = '<a href="/server/' + id +'"><svg id="view_server_icon" height="30" width="30" xmlns="http://www.w3.org/2000/svg"><image height="30" width="30" href="/assets/view_server_light.png" /></svg></a>';

		server_info.append(delete_button);
		server_info.append(view_button);

		return server_info;
	} catch (error){
		console.error(error.message)
		return null;
	}
}


async function FetchServer(id) {
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
