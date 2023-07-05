<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drum No Checker</title>
</head>
<body>

	<%@ include file="components/navbar.jsp"%>

	<div style="width: 800px; margin: 0 auto;">
		<div>
			<label for="vRating">Select the Voltage Rating of the cable</label> <select
				id="vRating" name="vRating"
				onchange="getSelectValue();">
				<option value="" disabled selected>Voltage Rating of cable</option>
				<option value="11pkv">11 KV</option>
				<option value="3p3kv">3.3 KV</option>
				<option value="1p1kv">1.1 KV</option>
			</select>
		</div>

		<div>
			<label for="cableCode">Enter the Cable Size</label> <select
				id="cableCode" name="cableCode" onchange="getDrumNo();">
				<option value="" disabled selected>Cable Size</option>
			</select>
		</div>
		<div>
			<label for="drumNo">Enter the Drum No</label> <select
				id="drumNo" name="drumNo" onchange="getDrumNo();">
				<option value="" disabled selected>Drum No</option>
			</select>
		</div>
		<div>
			<label for="dbNo">Db Numbers</label> <select
				id="dbNo" name="dbNo" onchange="getDbNo();">
				<option value="" disabled selected>DB No</option>
			</select>
		</div>
		<script src=".//js//drumNoChecker.js"></script>
</body>
</html>