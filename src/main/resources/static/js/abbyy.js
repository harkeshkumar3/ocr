'use strict';



/* Abbyy File Uplaoder page */

var abbyyUploadForm = document.querySelector('#abbyyUploadForm');
var abbyyFileUploadInput = document.querySelector('#abbyyFileUploadInput');
var abbyyFileUploadError = document.querySelector('#abbyyFileUploadError');
var abbyyFileUploadSuccess = document
	.querySelector('#abbyyFileUploadSuccess');

var abbyy_el_up = document.getElementById("abbyyGFG_UP");
var abbyy_el_down = document.getElementById("abbyyGFG_DOWN");

/* End  */

var obj = {};




function abbyyFileUpload(file) {
	var formData = new FormData();
	formData.append("file", file);

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/abbyyFile");
	xhr.onload = function () {
		console.log(xhr.responseText);
		var response = JSON.parse(xhr.responseText);
		if (xhr.status == 200) {
			abbyyFileUploadError.style.display = "none";

			//el_up.innerHTML = JSON.stringify(response);
			abbyy_el_down.innerHTML = JSON.stringify(response, undefined, 4);
			//singleFileUploadSuccess.innerHTML = response;

			abbyyFileUploadSuccess.style.display = "block";
		} else {
			abbyyFileUploadSuccess.style.display = "none";
			abbyyFileUploadError.innerHTML = (response && response.message)
				|| "Some Error Occurred";
		}
	}

	xhr.send(formData);
}





abbyyUploadForm.addEventListener('submit', function (event) {
	var files = abbyyFileUploadInput.files;
	if (files.length === 0) {
		abbyyFileUploadError.innerHTML = "Please select a file";
		abbyyFileUploadError.style.display = "block";
	}
	abbyyFileUpload(files[0]);
	event.preventDefault();
}, true);


