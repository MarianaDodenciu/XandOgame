<%--
  Created by IntelliJ IDEA.
  User: mariana
  Date: 06.04.2019
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/webResources/history.css">
    <script src="${pageContext.request.contextPath}/webResources/history.js"></script>
</head>
<body>

<div class="containerHistory">

    <!-- header section -->
    <div class="header">
        <h1> The last 3 winning matches</h1>
    </div></br>

    <div><a href="/GameTestingXandO_war_exploded/">Go back to game</a></div></br></br>
    <!-- board container-->

    <div class="containerBoard">
        <div class="board" >           <!-- first board -->
            <div class="row">
                <div id ="0" class="square" ></div>
                <div id ="1" class="square" ></div>
                <div id ="2" class="square" ></div>
            </div>
            <div class="row">
                <div id ="3" class="square" ></div>
                <div id ="4" class="square" ></div>
                <div id ="5" class="square" ></div>
            </div>
                <div class="row">
                <div id ="6" class="square" ></div>
                <div id ="7" class="square" ></div>
                <div id ="8" class="square" ></div>
            </div>
        </div>

        <div class="board">       <!-- second board -->
            <div class="row">
                <div id ="9" class="square" ></div>
                <div id ="10" class="square" ></div>
                <div id ="11" class="square" ></div>
            </div>
                <div class="row">
                <div id ="12" class="square" ></div>
                <div id ="13" class="square" ></div>
                <div id ="14" class="square" ></div>
            </div>
                <div class="row">
                <div id ="15" class="square" ></div>
                <div id ="16" class="square" ></div>
                <div id ="17" class="square" ></div>
            </div>
        </div>

        <div class="board">     <!--third board-->
            <div class="row">
                <div id ="18" class="square" >&nbsp;</div>
                <div id ="19" class="square" >&nbsp;</div>
                <div id ="20" class="square" >&nbsp;</div>
            </div>
                <div class="row">
                <div id ="21" class="square" >&nbsp;</div>
                <div id ="22" class="square" >&nbsp;</div>
                <div id ="23" class="square" >&nbsp;</div>
            </div>
            <div class="row">
                <div id ="24" class="square" >&nbsp;</div>
                <div id ="25" class="square" >&nbsp;</div>
                <div id ="26" class="square" >&nbsp;</div>
            </div>
        </div>
    </div></br></br>


</div>
</body>
</html>
