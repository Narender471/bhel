<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store Entry Page</title>
<%@ include file="components/allcss.jsp"%>
</head>
<body>
	<%@ include file="components/navbar.jsp"%>

	<form action="InsertDrumToStore" method="post">
		<div>
			<label>Enter the DB Number</label> <input type="text" name="dbNo">
		</div>
		
		<div>
			<label>Enter the DB Date</label> <input type="date" name="dbDate">
		</div>
		<div>
			<label for="cableCode">Cable Description:</label> <select name="cableCode" id="cableCode">
				<option value="11pkv630001c">11 KV 1 Core X 630 SQ MM CABLE</option>
				<option value="11pkv240003c">11 KV 3 Core X 240 SQ MM CABLE</option>
				<option value="1p1kv630001c">1.1 KV 1 Core X 630 SQ MM CABLE</option>
				<option value="1p1kv400001c">1.1 KV 1 Core X 400 SQ MM CABLE</option>
				<option value="1p1kv240003c">1.1 KV 3 Core X 240 SQ MM CABLE</option>
				<option value="1p1kv150003c">1.1 KV 3 Core X 150 SQ MM CABLE</option>
				<option value="1p1kv095002c">1.1 KV 2 Core X 95 SQ MM CABLE</option>
				<option value="1p1kv0503p5c">1.1 KV 3.5 Core X 50 SQ MM CABLE</option>
				<option value="1p1kv0253p5c">1.1 KV 3.5 Core X 25 SQ MM CABLE</option>
				<option value="1p1kv025003c">1.1 KV 3 Core X 25 SQ MM CABLE</option>
				<option value="1p1kv025002c">1.1 KV 2 Core X 25 SQ MM CABLE</option>
				<option value="1p1kv010004c">1.1 KV 4 Core X 10 SQ MM CABLE</option>
				<option value="1p1kv010003c">1.1 KV 3 Core X 10 SQ MM CABLE</option>
				<option value="1p1kv2p5003c">1.1 KV 3 Core X 2.5 SQ MM CABLE</option>
				<option value="1p1kv2p5002c">1.1 KV 2 Core X 2.5 SQ MM CABLE</option>
				<option value="audi">Audi</option>
			</select>
		</div>
		<div>
			<label>Enter the Drum No</label> <input type="text" name="drumNo">
		</div>
		<div>
			<label>Length of the Drum</label> <input type="text" name="length">
		</div>
		<div>
		<input type ="submit" value = "submit to Store">
		</div>
	</form>

</body>
</html>