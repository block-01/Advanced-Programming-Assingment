function funcDarkModeToggle() {
	/*
	 * Toggles darkmode when button is clicked in settings page.
	 */
	var element = document.body;
	element.classList.toggle("dark-mode");
	if (localStorage.getItem("darkmode") == "true") {
		localStorage.setItem("darkmode", false);
		document.getElementById("settings_icon").innerHTML = '<image height="40" width="40" href="/assets/settings_gear_light.png" />';
		document.getElementById("add_server_icon").innerHTML = '<image height="40" width="40" href="/assets/add_server_light.png" />';
		document.getElementById("home_page_button_icon").innerHTML = '<image height="40" width="40" href="/assets/home_page_light.png" />';
		// document.getElementById("remove_server_icon").innerHTML = '<image height="30" width="30" href="/assets/delete_server_light.png" />';
		// document.getElementById("view_server_icon").innerHTML = '<image height="30" width="30" href="/assets/view_server_light.png" />';
	}
	else {
		localStorage.setItem("darkmode", true);
		document.getElementById("settings_icon").innerHTML = '<image height="40" width="40" href="/assets/settings_gear_dark.png" />';
		document.getElementById("add_server_icon").innerHTML = '<image height="40" width="40" href="/assets/add_server_dark.png" />';
		document.getElementById("home_page_button_icon").innerHTML = '<image height="40" width="40" href="/assets/home_page_dark.png" />';
		// document.getElementById("remove_server_icon").innerHTML = '<image height="30" width="30" href="/assets/delete_server_dark.png" />';
		// document.getElementById("view_server_icon").innerHTML = '<image height="30" width="30" href="/assets/view_server_dark.png" />';
	}
}

function funcCheckDarkModeToggle() {
	/*
	 * Checks for if the 'darkmode' variable is true in local storage.
	 * if true dark mode CSS is loaded.
	 */
	var element = document.body;
	if (localStorage.getItem("darkmode") == "true") {
		element.classList.toggle("dark-mode");
		document.getElementById("settings_icon").innerHTML = '<image height="40" width="40" href="/assets/settings_gear_dark.png" />';
		document.getElementById("add_server_icon").innerHTML = '<image height="40" width="40" href="/assets/add_server_dark.png" />';
		document.getElementById("home_page_button_icon").innerHTML = '<image height="40" width="40" href="/assets/home_page_dark.png" />';
		// document.getElementById("remove_server_icon").innerHTML = '<image height="30" width="30" href="/assets/delete_server_light.png" />';
		// document.getElementById("view_server_icon").innerHTML = '<image height="30" width="30" href="/assets/view_server_light.png" />';
	}
	else{
		document.getElementById("settings_icon").innerHTML = '<image height="40" width="40" href="/assets/settings_gear_light.png" />';
		document.getElementById("add_server_icon").innerHTML = '<image height="40" width="40" href="/assets/add_server_light.png" />';
		document.getElementById("home_page_button_icon").innerHTML = '<image height="40" width="40" href="/assets/home_page_light.png" />';
		// document.getElementById("remove_server_icon").innerHTML = '<image height="30" width="30" href="/assets/delete_server_dark.png" />';
	}
}
