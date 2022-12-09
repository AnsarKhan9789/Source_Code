<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ tagliburi ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<title>Insert title here</title>
<style>
table{
margin-left:20%;
}

</style>
</head>
<body>
<h1 class="starting">All Account Details</h1>
<form action="<%=request.getContextPath( )%>/add" method="post">
<div style="margin-left:30%">
 <select name="userId" style="width: 20%; margin-right:30px">
			 <option value="0" selected >User Id</option>
			<c:forEach items="${listCategory}" var="category">
			
			
				<option value="${category}">${category}</option>
			</c:forEach>
		</select>
		<select name="Status" style="width: 20%;margin-right:30px">
		<option value="Active" selected> Active</option>
		<option value="Inactive"> Inactive</option>
		</select>
		<button type="submit" name="admin" value="Account Details">Show</button>
</div>
		
	</form>
	<table class="tables">
		<thead>
			<tr>
				<th>Customer Id</th>
				<th>Account Number</th>
				<th>Balance</th>
				<th>Branch</th>
				<th>Account Status</th>

			</tr>
		</thead>
		<c:set var="map" value="${flag}" />
			<c:choose>
				<c:when test="${map==0}">
					<tbody>
						<tr>
							<td colspan="5">No items to display</td>
						</tr>
					</tbody>

				</c:when>
				<c:otherwise>
		<tbody>

			<c:forEach var="entry" items="${accountMap}">

				<c:forEach var="innerMap" items="${entry.value}">
					<tr>
						<form method="post" action="<%=request.getContextPath()%>/add">

							<td>${innerMap.value.getUserId()}</td>
							<td><input name="account" value="${innerMap.value.getAccountNumber()}" readonly></td>
							<td>${innerMap.value.getBalance()}</td>
							<td>${innerMap.value.getBranch()}</td>
							<td><input type="hidden" name="admin" value="Change Status">
								<input title="change Status" type="submit" name="StatusForAccount" value="${innerMap.value.getAccountStatus()}" readonly></td>
							</form>
						
					</tr>
				</c:forEach>
<!--Kudoos to balaji-->
			</c:forEach>
		</tbody>
	</c:otherwise>
			</c:choose>
	</table>
</body>
</html>