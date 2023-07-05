<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cable Stock Management System</title>
<%@ include file="components/allcss.jsp"%>
</head>
<body>
	<%@ include file="components/navbar.jsp"%>
	<div style="width: 800px; margin: 0 auto;">
		<div>
			<label for="vRating">Select the Voltage Rating of the cable</label> <select
				id="vRating" name="vRating" onchange="getSelectValue();">
				<option value="" disabled selected>Voltage Rating of cable</option>
				<option value="11pkv">11 KV</option>
				<option value="3p3kv">3.3 KV</option>
				<option value="1p1kv">1.1 KV</option>
			</select>
		</div>

		<div>
			<label for="cableCode">Enter the Cable Size</label> <select
				id="cableCode" name="cableCode" onchange="getDrumData();">
				<option value="" disabled selected>Cable Size</option>
			</select>
		</div>
		
		<div>
			<label for="drumNo">Select the Drum Number</label> <select
				id="drumNo" name="drumNo" onchange="">
				<option value="" disabled selected>Drum Number</option>
				</select>
		</div>
		
		<div>
			<label for="cableSchedule">Select the Cable Schedule</label> <select
				id="cableSchedule" name="cableSchedule" onchange="getCableFrom();">
				<option value="" disabled selected>Cable Schedule</option>
				<option value="0ba">0BA</option>
				<option value="0bb">0BB</option>
				<option value="0ca">0CA</option>
				<option value="0cb">0CB</option>
				<option value="1ba">1BA</option>
				<option value="1bb">1BB</option>
				<option value="1ca">1CA</option>
				<option value="2ba">2BA</option>
				<option value="2bb">2BB</option>
				<option value="2ca">2CA</option>
				<option value="0da">0DA</option>
				<option value="0db">0DB</option>
				<option value="0dc">0DC</option>
				<option value="0dd">0DD</option>
				<option value="0dr">0DR</option>
				<option value="0ta">0TA</option>
			</select>
		</div>

		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>
			<script src=".//js//cabling.js"></script>
</body>
</html>