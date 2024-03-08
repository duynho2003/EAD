<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpperCase Bean Demo</title>
</head>
<body>
	<h1>Upper Case Message</h1>
	<form method='post' action="UpperCase">
		<input type='text' name='message'  /> <br />
		<input type='submit' value='Submit' />
	</form>
	<p>Result: ${result}</p>
</body>
</html>