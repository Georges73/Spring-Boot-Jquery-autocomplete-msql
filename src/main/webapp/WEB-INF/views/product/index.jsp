<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Hello ${name}!</title>

<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

</head>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$('#productName')
								.autocomplete(
										{
											minLength : 2,
											source : '${pageContext.request.contextPath }/product/search', /* declare sourc variable */

											select : function(event, ui) { /* click event dans ui to fire method*/
												/* alert(event) */

												var inputFromBox = ui.item.label;
												var searchResults = [];
												var html_to_append = '';

												$.ajax({
															type : 'GET',
															url : '${pageContext.request.contextPath }/product/search_full?inputParam='+ inputFromBox,
															dataType : 'json',

															/* ************************************* FUNCTION *****************************************************************************/

															success : function(
																	response) {
																console.log(response);

																$.each(response,function(i,item) {

																	
																					html_to_append += '<tr>';

																					html_to_append +='<td >' + item.id  + '</td>'; 
																					html_to_append +='<td>' + item.name  + '</td>';
																					html_to_append +='<td>' + item.description  + '</td>';
																					html_to_append +='<td>' + item.price  + '</td>';
																					html_to_append +='</tr>';	
																					
																					});

																$("#result_table table").append(html_to_append);
															 }, 

														});

											}
										});
					});
</script>

<body>
	<div align="center">
		<div class="ui-widget">
			<p>Type a product</p>
			<label for="automplete-1">Tags: </label> <input type="text"	id="productName">
		</div>
	</div>

	<br>
	<!-- <br> Result -->

	<br>

	<div  id="result_table">

		<table style="width: 20%;">
			
				<tr>
					<th >ID</th> 
					<th >Name</th>
					<th >Description</th>
					<th >Price</th>

				</tr>
			
		</table>

	</div>

	<!-- <div id="result"></div>
	<br> -->

</body>
</html>




















<!-- <table>
        <tr>
            <td>prod search</td>
            <td><input type='text' id="productName" ></td>
        </tr>

       <tr>
            <td>the rest</td>
            <td><input type='text' id='selectuser_id' /></td>
        </tr>

        <tr>
            <td>Multiple Selection</td>
            <td><input type='text' id='multi_autocomplete' ></td>
        </tr>

        <tr>
            <td>Selected User ids</td>
            <td><input type='text' id='selectuser_ids' /></td>
        </tr>

    </table>
	 -->