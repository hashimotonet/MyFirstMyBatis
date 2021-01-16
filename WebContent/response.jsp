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
<title>Hello From Serverside.</title>
</head>
<body>
<h1>
<%--  for (SampleBean result : list) {
		out.println(result.getId());
		out.println("｜");
		out.println(result.getName());
		out.println("<br/>");
		out.println("----------------------------");
		out.println("<br/>");
	} --%>
<c:forEach var="bean" items="${list}">
	<c:out value="${bean.id}"/>｜
	<c:out value="${bean.name}"/><br>
</c:forEach></h1>
</body>
</html>
