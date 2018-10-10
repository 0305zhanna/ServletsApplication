<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <meta charset="utf-8">
    <title>JspPage</title>
    <script>
        function doRequest(name) {
            var request = new XMLHttpRequest();
            request.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200){
                    document.getElementById("st1").innerHTML = this.responseText;
                }
            }

            request.open(name, "?clicked='something'", true);
            request.send();
        }
    </script>
</head>
<body>
<center>
    <button type="button" onclick="doRequest(this.name)" name="GET">GET</button>
    <button type="button" onclick="doRequest(this.name)" name="POST">POST</button>
    <button type="button" onclick="doRequest(this.name)" name="PUT">PUT</button>
    <button type="button" onclick="doRequest(this.name)" name="DELETE">DELETE</button>
    <div>
    </div>
</center>
<div id="st1">
    <div id="state">Current state: ${state}</div>
    <h2>Amount of views: <span id="amount">${amount}</span></h2>
    <div>
        <c:forEach items="${states}" var="state">
            <p>${state}</p>
        </c:forEach>
    </div>
</div>
</body>
</html>
