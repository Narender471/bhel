<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available stock page</title>

<%@ include file="components/allcss.jsp"%>
<style type="text/css">
table, td, th {
	border: 2px #2b2b2b solid;
}

table {
	width: auto;
	float: left;
	margin: 0 30px 30px 0;
}
</style>
</head>
<body>
	<%@ include file="components/navbar.jsp"%>

	<div style="width: 800px; margin: 0 auto;">
		<div>
			<label for="vRating">Select the Voltage Rating of the cable</label> <select
				id="vRating" name="vRating"
				onchange="getSelectValue(this.id,'cableCode');">
				<option value="" disabled selected>Voltage Rating of cable</option>
				<option value="11pkv">11 KV</option>
				<option value="3p3kv">3.3 KV</option>
				<option value="1p1kv">1.1 KV</option>
			</select>
		</div>

		<div>
			<label for="cableCode">Enter the Cable Size</label> <select
				id="cableCode" name="cableCode" onchange="onChangeCableCode();">
				<option value="" disabled selected>Cable Size</option>
			</select>
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<th></th>
						<th>Total</th>
						<th>Available at Store</th>
						<th>Consumed by PRV</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Drums</td>
						<td id="totalDrums"></td>
						<td id="storeDrums"></td>
						<td id="prvDrums"></td>
					</tr>
					<tr>
						<td>Cable Length</td>
						<td id="totalLength"></td>
						<td id="storeLength"></td>
						<td id="prvLength"></td>
					</tr>
				</tbody>


			</table>
		</div>





		<script src=".//js//stock.js"></script>
		<%@ include file="components/allcss.jsp"%>
	</div>

</body>
</html>