<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cable DataBase cable wise</title>
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
				id="cableCode" name="cableCode" onchange="getCableData();">
				<option value="" disabled selected>Cable Size</option>
			</select>
		</div>
		<div class="d-flex justify-content-center">
			<div class="spinner-border" role="status" id="loading">
				<span class="sr-only">Loading...</span>
			</div>
		</div>

		<div class="table-responsive">
			<table class = "table" id="cableData"></table>
		</div>

		<script src=".//js//cableData.js"></script>


		<%@ include file="components/allcss.jsp"%>
</body>
</html>