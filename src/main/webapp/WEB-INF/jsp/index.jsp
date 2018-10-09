<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>JspPage</title>
        <script>
            function doRequest(id) {
                var request = new XMLHttpRequest();
                var name = document.getElementById(id).value
                request.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("state").innerHTML=name
                    }
                }
                request.open(name, "/", true);
                request.send();
            }
            function doPost() {
                var xhttp = new XMLHttpRequest();
                xhttp.open("POST", "/", true);
                xhttp.send();
                document.getElementById("state").innerHTML="POST"
            }
            function doGet() {
                var xhttp = new XMLHttpRequest();
                xhttp.open("GET", "/", true);
                xhttp.send();
                document.getElementById("state").innerHTML="GET"
            }
        </script>
    </head>
    <body>
        <center>
            <h2>Clicked button: <span id="state"></span></h2>
            <input id="get" type="button" onclick="doRequest(this.id)" value="GET">
            <input id="post" type="button" onclick="doRequest(this.id)" value="POST">
            <input id="put" type="button" onclick="doRequest(this.id)" value="PUT">
            <input id="DELETE" type="button" onclick="doRequest(this.id)" value="DELETE">
            <c:forEach items="${states}" var="state">
                <p>${state}</p>
            </c:forEach>
        </center>
    </body>
</html>
