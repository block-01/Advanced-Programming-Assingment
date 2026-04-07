function AddServerClickOff(){
	var modal = document.getElementById('add_server');
	window.onclick = function (event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
}

function SettingsClickOff() {
	var modal = document.getElementById('settings');
	window.onclick = function (event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
}
