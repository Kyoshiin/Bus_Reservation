<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<html>

	<head>
		<style>
			a {
				font-size: 16px;
				text-decoration: none;
				background-color: navy;
				color: white;
				padding: 5px;
			}

			a#new {
				background-color: navy;
				color: white;
			}

			a#show {
				background-color: maroon;
				color: white;
			}

			a#update {
				background-color: green;
				color: white;
			}

			a#delete {
				background-color: darkred;
				color: white;
			}

			#head {
				font-size: 16px;
				background-color: navy;
				color: white;
				padding: 5px;
			}
		</style>
		<title>Bus Reservation</title>
	</head>

	<body>

		<!-- <a href="newLogin" id="new">Add New Login</a>   <a href="logout">Logout</a>   -->

		<br /> <br />
		<div align="center" id="list">
			<h3 align="center">Customers List</h3>
			<table border="1">

				<thead id="head">
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<!-- <th colspan="2">operations</th> -->
				</thead>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.id}</a></td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.emailId}</td>

						<!-- <td><a href="editlogin?id=${login.id}" id="update">Update</a></td>
	<td><a href="deletelogin?id=${login.id}" id="delete">Delete</a></td> </tr> -->
				</c:forEach>
			</table>
		</div>
	</body>

	</html>