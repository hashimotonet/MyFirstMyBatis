<%@ page
	language="java"
	import="java.util.*, hashimotonet.bean.SampleBean"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="list" type="java.util.ArrayList<SampleBean>" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Hello From Serverside.</title>
</head>
<body>
<table>
	<tr>
		<td>Here is My Company</td>
	</tr>
</table>
<hr/>
<table>
<c:forEach var="bean" items="${list}">
	<tr>
		<td>
			<c:out value="${bean.id}"/>
		</td>
		<td>
			<c:out value="${bean.name}"/>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
