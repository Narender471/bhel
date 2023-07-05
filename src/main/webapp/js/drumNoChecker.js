
function getSelectValue() {
	var s1 = document.getElementById("vRating");
	var s2 = document.getElementById("cableCode");

	s2.innerHTML = "";
	if (s1.value == "11pkv") {
		var optionArray = ['11pkv240001c|1 core X 240 sqmm', '11pkv240003c|3 core X 240 sqmm', '11pkv630001c|1 core X 630 sqmm'];
	}
	else if (s1.value == "3p3kv") {
		var optionArray = ['3p3kv185003c|3 core X 185 sqmm', '3p3kv240001c|1 core X 240 sqmm'];
	} else if (s1.value == "1p1kv") {
		var optionArray = ['1p1kv630001c|1 core X 630 sqmm', '1p1kv400001c|1 core X 400 sqmm', '1p1kv240003c|3 core X 240 sqmm', '1p1kv1853p5c|3.5 core X 185 sqmm', '1p1kv185003c|3 core X 185 sqmm', '1p1kv150003c|3 core X 150 sqmm', '1p1kv120001c|1 core X 120 sqmm', '1p1kv0953p5c| 3.5 core X 95 sqmm', '1p1kv095003c|3 core X 95 sqmm', '1p1kv095002c| 2 core X 95 sqmm', '1p1kv0503p5c|3.5 core X 50 sqmm', '1p1kv050003c|3 core X 50 sqmm', '1p1kv050002c|2 core X 50 sqmm', '1p1kv040001c|1 core X 40 sqmm', '1p1kv035001c|1 core X 35 sqmm', '1p1kv0253p5c|3.5 core X 25 sqmm', '1p1kv025003c|3 core X 25 sqmm', '1p1kv025002c|2 core X 25 sqmm', '1p1kv010004c|4 core X 10 sqmm', '1p1kv010003c|3 core X 10 sqmm', '1p1kv010002c|2 core X 10 sqmm', '1p1kv006002c|2 core 6 sqmm', '1p1kv004005c|5 core X 4 sqmm', '1p1kv2p5012c|12 core X 2.5 sqmm', '1p1kv2p5007c|7 core X 2.5 sqmm', '1p1kv2p5005c|5 core X 2.5 sqmm', '1p1kv2p5003c|3 core X 2.5 sqmm', '1p1kv2p5002c|2 core X 2.5 sqmm'];
	}
	var newOption = document.createElement("option");
	newOption.value = "";
	s2.options.add(newOption);
	for (var opt in optionArray) {
		var pair = optionArray[opt].split("|");
		var newOption = document.createElement("option");
		newOption.value = pair[0];
		newOption.innerHTML = pair[1];
		s2.options.add(newOption);
	}
}

function onClick() {
	var s1 = document.getElementById("cableCode");
	console.log(s1.value);

}
function getDrumNo() {

	var s2 = document.getElementById("cableCode");
	

	s3.innerHTML = "";
	let p = fetch("http://ec2-65-0-4-145.ap-south-1.compute.amazonaws.com:8080//CableManagementSystem/DrumNoFromCableCode?cableCode=" + s2.value)
	p.then((value1) => {
		return value1.json()
	}).then((drumNumbers) => {
		var newOption = document.createElement("option");
		newOption.value = "";
		s3.options.add(newOption);

		for (let i = 0; i < drumNumbers.length; i++) {
			var newOption = document.createElement("option");
			newOption.value = drumNumbers[i];
			newOption.innerHTML = drumNumbers[i];
			s3.options.add(newOption);
		}
	})
}
function getDbNo() {

	var s2 = document.getElementById("cableCode");
	var s3 = document.getElementById("drumNo");

	s3.innerHTML = "";
	let p = fetch("http://ec2-65-0-4-145.ap-south-1.compute.amazonaws.com:8080//CableManagementSystem/DrumNoFromCableCode?cableCode=" + s2.value)
	p.then((value1) => {
		return value1.json()
	}).then((drumNumbers) => {
		var newOption = document.createElement("option");
		newOption.value = "";
		s3.options.add(newOption);

		for (let i = 0; i < drumNumbers.length; i++) {
			var newOption = document.createElement("option");
			newOption.value = drumNumbers[i];
			newOption.innerHTML = drumNumbers[i];
			s3.options.add(newOption);
		}
	})
}
getSelectValue();
