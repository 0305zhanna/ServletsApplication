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
                    document.getElementById("amount").innerHTML = this.responseText;
                }
            }
            request.open(name, "", true);
            request.send();
        }

        function doGet() {
            var request = new XMLHttpRequest();
            request.open("GET", "", true);
            request.send();
        }
    </script>
</head>
<body>
<center>
    <div id="state">${state}</div>
    <button type="button" onclick="doGet()" name="GET">GET</button>
    <button type="button" onclick="doRequest(this.name)" name="POST">POST</button>
    <button type="button" onclick="doRequest(this.name)" name="PUT">PUT</button>
    <button type="button" onclick="doRequest(this.name)" name="DELETE">DELETE</button>
    <div>
    </div>
</center>
<h2>Amount of views: <span id="amount">${amount}</span></h2>
<div>
    <c:forEach items="${states}" var="state">
        <p>${state}</p>
    </c:forEach>
</div>
</body>
</html>
