<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>JspPage</title>
    <script>
        function doRequest(name) {
            var request = new XMLHttpRequest();
            request.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("state").innerHTML = name
                }
            }
            request.open(name, "/", true);
            request.send();
        }
    </script>
</head>
<body>
<center>
    <h2>Clicked button: <span id="state"></span></h2>
    <%--<input id="post" type="button" onclick="doRequest(this.id)" value="POST">--%>
    <%--<input id="put" type="button" onclick="doRequest(this.id)" value="PUT">--%>
    <%--<input id="DELETE" type="button" onclick="doRequest(this.id)" value="DELETE">--%>
    <%--<input id="get" type="button" onclick="doRequest(this.id)" value="GET">--%>
    <button type="button" onclick="doRequest(this.name)" name="GET">GET</button>
    <button type="button" onclick="doRequest(this.name)" name="POST">POST</button>
    <button type="button" onclick="doRequest(this.name)" name="PUT">PUT</button>
    <button type="button" onclick="doRequest(this.name)" name="DELETE">DELETE</button>
    <div>
        <c:forEach items="${states}" var="state">
            <p>${state}</p>
        </c:forEach>
    </div>
</center>
<h2>Amount of views: ${amount}</h2>
</body>
</html>
