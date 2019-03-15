<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
         
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 <link href="./css/prettify-1.0.css" rel="stylesheet">
<title>Search Flight</title>
<style type="text/css">
	.error{
		color:red;
	}
	
	
</style>
<script type="text/javascript">
            $(function(){
                $("#datepicker").datepicker({
                		minDate: 0,
                        changeMonth: true,
                        changeYear: true,
                       dateFormat: 'yy-mm-dd'
                });
                           
            });
          </script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<span class="navbar-brand mb-0 h1">Flight Search </span>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto" style="margin-right: 10%">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> ${userEmail} </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<c:url value="/logout" />">Logout</a>
					</div></li>
			</ul>
		</div>
	</nav>


	<div style="margin: 5% 5% 5% 5%">

		<form:form action="search" method="post" modelAttribute="flightSearchParameter">
			<div class="row">
				<div class="col">
					<form:input type="text" path="departureLocation"
						class="form-control" 
						id="departureLocation" placeholder="Enter Departure Location" />
					<form:errors cssClass="error" path="departureLocation" />
				</div>
				<div class="col">
                     <form:input type="text" path="flightDate" class="form-control"  id="datepicker" readonly="readonly"/>
                </div>
				<div class="col">
					<form:input type="text" class="form-control" path="arrivalLocation"
						id="Arrival Location" placeholder="Enter Arrival Location"/>
						<form:errors cssClass="error" path="arrivalLocation" />
				</div>
				<div class="col">
					<form:select class="form-control" path="flightclass"  id="class">
						<option value="E">E</option>
						<option value="B">B</option>
					</form:select>
					<form:errors cssClass="error" path="flightclass" />
				</div>
				<div class="col">
					<form:select class="form-control" id="sort" path="outputPreference">
						<option value="fare">Fare</option>
						<option value="both">Fare And Duration</option>
					</form:select>
					<form:errors cssClass="error" path="outputPreference" />
				</div>
				<form:button type="submit" class="btn btn-primary">Search</form:button>
			</div>
		</form:form>

		<c:if test="${flights.size() > 0}">
			<table class="table" style="margin-top: 2%">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Flight Number</th>
						<th scope="col">Departure Location</th>
						<th scope="col">Arrival Location</th>
						<th scope="col">Date</th>
						<th scope="col">Time</th>
						<th scope="col">Duration</th>
						<th scope="col">Fare</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="flight" items="${flights}">
						<tr>
							<th>${flight.getFlightNo()}</th>
							<td>${flight.getDepartureLoc()}</td>
							<td>${flight.getArrivalLoc()}</td>
							<td>${flight.getValidTill().toString().substring(0,10)}</td>
							<td>${flight.getFlightTime()}</td>
							<td>${flight.getFlightDuration()}</td>
							<td>${flight.getFare()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</c:if>

	</div>


</body>
</html>





 