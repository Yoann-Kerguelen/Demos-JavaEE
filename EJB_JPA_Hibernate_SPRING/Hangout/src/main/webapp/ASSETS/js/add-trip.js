var expanded = false;

function showCheckboxes() {
	var checkboxes = document.getElementById("checkboxes");
	if (!expanded) {
		checkboxes.style.display = "block";
		expanded = true;
	} else {
		checkboxes.style.display = "none";
		expanded = false;
	}
}

function addPlace(value) {
	if (value === "add-place") {
		window.location.href = './ajouter-lieu';
	}
}

var date = document.getElementById("date");
date.addEventListener("change", function() {
	moment.locale('fr');
	this.setAttribute(
		"data-date",
		moment(this.value, "YYYY-MM-DD")
			.format(this.getAttribute("data-date-format"))
	)
})

