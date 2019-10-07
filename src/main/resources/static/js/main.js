'use strict';

var singleUploadForm = document.querySelector('#singleUploadForm');
var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document
		.querySelector('#singleFileUploadSuccess');

var multipleUploadForm = document.querySelector('#multipleUploadForm');
var multipleFileUploadInput = document
		.querySelector('#multipleFileUploadInput');
var multipleFileUploadError = document
		.querySelector('#multipleFileUploadError');
var multipleFileUploadSuccess = document
		.querySelector('#multipleFileUploadSuccess');

var el_up = document.getElementById("GFG_UP"); 
var el_down = document.getElementById("GFG_DOWN");


/* Abbyy File Uplaoder page */

var abbyyUploadForm = document.querySelector('#abbyyUploadForm');
var abbyyFileUploadInput = document.querySelector('#abbyyFileUploadInput');
var abbyyFileUploadError = document.querySelector('#abbyyFileUploadError');
var abbyyFileUploadSuccess = document
		.querySelector('#abbyyFileUploadSuccess');

var abbyy_el_up = document.getElementById("abbyyGFG_UP"); 
var abbyy_el_down = document.getElementById("abbyyGFG_DOWN"); 

/* End  */

var obj = {  }; 


/* el_up.innerHTML = JSON.stringify(obj); */


function uploadSingleFile(file) {
	var formData = new FormData();
	formData.append("file", file);

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/uploadFile");
	
	
	

	xhr.onload = function() {
		console.log(xhr.responseText);
		var response = JSON.parse(xhr.responseText);
		if (xhr.status == 200) {
			singleFileUploadError.style.display = "none";
			
			//el_up.innerHTML = JSON.stringify(response);
			el_down.innerHTML = JSON.stringify(response, undefined, 4); 
			//singleFileUploadSuccess.innerHTML = response;
			
			
			
			singleFileUploadSuccess.style.display = "block";
		} else {
			singleFileUploadSuccess.style.display = "none";
			singleFileUploadError.innerHTML = (response && response.message)
					|| "Some Error Occurred";
		}
	}

	xhr.send(formData);
}


function abbyyFileUpload(file) {
	var formData = new FormData();
	formData.append("file", file);

	console.log(formData);
	console.log(file);
}


function uploadMultipleFiles(files) {
	var formData = new FormData();
	for (var index = 0; index < files.length; index++) {
		formData.append("files", files[index]);
	}

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/uploadMultipleFiles");

	xhr.onload = function() {
		console.log(xhr.responseText);
		var response = JSON.parse(xhr.responseText);
		if (xhr.status == 200) {
			multipleFileUploadError.style.display = "none";
			var content = "<p>All Files Uploaded Successfully</p>";
			for (var i = 0; i < response.length; i++) {
				content += "<p>DownloadUrl : <a href='"
						+ response[i].fileDownloadUri + "' target='_blank'>"
						+ response[i].fileDownloadUri + "</a></p>";
			}
			multipleFileUploadSuccess.innerHTML = content;
			multipleFileUploadSuccess.style.display = "block";
		} else {
			multipleFileUploadSuccess.style.display = "none";
			multipleFileUploadError.innerHTML = (response && response.message)
					|| "Some Error Occurred";
		}
	}

	xhr.send(formData);
}

singleUploadForm.addEventListener('submit', function(event) {
	var files = singleFileUploadInput.files;
	if (files.length === 0) {
		singleFileUploadError.innerHTML = "Please select a file";
		singleFileUploadError.style.display = "block";
	}
	uploadSingleFile(files[0]);
	event.preventDefault();
}, true);

abbyyUploadForm.addEventListener('submit', function(event) {
	var files = abbyyFileUploadInput.files;
	if (files.length === 0) {
		abbyyFileUploadError.innerHTML = "Please select a file";
		abbyyFileUploadError.style.display = "block";
	}
	abbyyFileUpload(files[0]);
	event.preventDefault();
}, true);

multipleUploadForm.addEventListener('submit', function(event) {
	var files = multipleFileUploadInput.files;
	if (files.length === 0) {
		multipleFileUploadError.innerHTML = "Please select at least one file";
		multipleFileUploadError.style.display = "block";
	}
	uploadMultipleFiles(files);
	event.preventDefault();
}, true);
