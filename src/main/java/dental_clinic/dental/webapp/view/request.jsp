<!DOC TYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content ="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<p>Request list</p>
<table>
<tr>
<th>id</th>
<th>date</th>
<th>time</th>
<th>dentist</th>
<th>patient</th>
<th>status</th>
<th>note</th>
</tr>
<c:forEach var="request" items="${requests}">
<tr>
<td>${request.getRequest_id()} </td>
<td>${request.getNoteRequest()} </td>
<td>${request.getStatusRequest()} </td>
<td>${request.getDateRequest()} </td>
<td>${request. getPatient_id()} </td>
<td>${request.getPhoneNumber()} </td>
<td>${request.getTimeRequest()} </td>
</tr>
</c:forEach>
</table>
</body>
</html>