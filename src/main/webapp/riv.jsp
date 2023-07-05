<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Riv Entry Page</title>
<%@ include file="components/allcss.jsp"%>
</head>
<body>
	<%@ include file="components/navbar.jsp"%>
	<div>
	<%
	
	if(request.getParameter("transactionStatus") != null){
		String transactionStatus = request.getParameter("transactionStatus");
		out.println(transactionStatus);
	}
	
	
	%>
	</div>

	<form action="insertRivData" method="get">
		<label for="vRating">Select the Voltage Rating of the cable</label> <select
			id="vRating" name="vRating"
			onchange="getSelectValue(this.id,'cableCode');">
			<option value="" disabled selected>Voltage Rating of cable</option>
			<option value="11pkv">11 KV</option>
			<option value="3p3kv">3.3 KV</option>
			<option value="1p1kv">1.1 KV</option>
		</select> <br> <label for="cableCode">Enter the Cable Size</label> <select
			id="cableCode" name="cableCode" onchange="onChangeCableCode();">
			<option value="" disabled selected>Cable Size</option>
		</select> <br> <label for="dbNo">Enter the db Number</label> <select
			id="dbNo" name="dbNo" onchange="onChangeDbNumber();">
			<option value="" disabled selected>Db Number</option>
		</select> <br> <label for="drumNo">Enter the Drum Number</label> <select
			id="drumNo" name="drumNo" onchange="onChangeDrumNumber();">
			<option value="" disabled selected>Drum Number</option>
		</select> <br> <label for="rivNo">Riv Number</label> <input type="text"
			id="rivNo" name="rivNo"> <label for="rivDate">Riv
			Date</label> <input type="date" id="rivDate" name="rivDate"> <br>
		<label for="gpNo">Gate Pass Number</label> <input type="text"
			id="gpNo" name="gpNo"> <label for="gpDate">Gate Pass
			Date</label> <input type="date" id="gpDate" name="gpDate"> <br>
		<label for="length">Length of the Drum</label> <input type="text"
			id="length" name="length">

		<div>
			<input type="submit" value="submit RIV">
		</div>


	</form>




	<script src=".//js//riv.js"></script>
	<%@ include file="components/allcss.jsp"%>

</body>
</html>