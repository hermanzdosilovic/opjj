<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${rezultati.size() > 10}">
		<p>Slijedi jako velika lista podataka</p>
	</c:when>
	<c:otherwise>
		<p>Broj elemenata nije velik</p>
	</c:otherwise>
</c:choose>

<table>
<c:forEach var="r" items="${rezultati}">
<tr><tb>${r.broj}</tb><td>${r.vrijednost}</tb></tr>
</c:forEach>
</table>