<%@ page
	language="java"
	import="java.util.*, hashimotonet.bean.SampleBean"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="list" type="java.util.ArrayList<SampleBean>" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<%  for (SampleBean result : list) {
		out.println(result.getId());
		out.println("｜");
		out.println(result.getName());
		out.println("<br/>");
		out.println("----------------------------");
		out.println("<br/>");
	} %>
</h1>
</body>
</html>
