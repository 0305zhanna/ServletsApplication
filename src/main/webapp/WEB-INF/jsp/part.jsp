<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<div id="state">Current state: ${state}</div>
<h2>Amount of views: <span id="amount">${amount}</span></h2>
<div>
    <c:forEach items="${states}" var="i">
        <p>${i}</p>
    </c:forEach>
</div>