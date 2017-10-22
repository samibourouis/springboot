<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

	table {
		border-collapse: collapse;
		width: 100%;
		margin-right: 20px;
	}
	
	table tr td, table tr th {
		border : 1px solid black;
	}

</style>
</head>
<body>

	<div style="width: 60%; float: left;">
		<div style="margin: 10px;">
			<table id="users">
				<thead>
					<tr>
						<th>#</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Login</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
	
	<div style="width: 40%; float: left;">
		<form>
			<label>FirstName</label><br>
			<input type="text"><br>
			<label>LastName</label><br>
			<input type="text"><br>
			<label>Login</label><br>
			<input type="text"><br>
			<label>Password</label><br>
			<input type="password"><br>
			<button>Ajouter / Modifier</button>
		</form>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
  		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  		crossorigin="anonymous"></script>
  	
  	<script type="text/javascript">
  		$.ajax({
  			url : "/api/user/",
  			type : "GET",
  			success : function(result) {
  				// alert(result);
  				console.log(result);
  				
  				// boucler sur le tabler
  				$.each(result, function(i, item) {
  					
  					// console.log($(this));
  					
  					var tr = "<tr>";
  					tr += "<td>" + item.id + "</td>";
  					tr += "<td>" + $(this)[0].firstName + "</td>";
  					tr += "<td>" + $(this)[0].lastName + "</td>";
  					tr += "<td>" + $(this)[0].login + "</td>";
  					tr += "<td></td>";
  					tr += "</tr>";
  					
  					$("#users tbody").append(tr);
  					
  				});
  			}
  		});
  	</script>
  
  
</body>
</html>