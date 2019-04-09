<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/webResources/styles.css">
        <script src="${pageContext.request.contextPath}/webResources/xo.js"></script>
    </head>


    <body>

    <div class="container">
        <!-- header section -->
        <div class="header">
            <h1> X si O</h1>
        </div>
        <div id="Win-div"></div>

        <!-- controls section : checkboxes-->
        <div class="controls">

            <h3>Select player</h3></br>
            <form action="#">

                <input class="button" type="radio" name="startPlayer" id="xPlayer" checked="checked" value="X" onclick="setPlayer()"> X Player
                <input class="button" type="radio" name="startPlayer" id="oPlayer" value="O" onclick="setPlayer()"> O Player
            </form>

        </div>

        <!-- board container-->
        <div class="containerBoard">

            <!-- first row -->
            <div class="row">
                <div id ="0" class="square" onclick="f(0)">&nbsp;</div>
                <div id ="1" class="square" onclick="f(1)">&nbsp;</div>
                <div id ="2" class="square" onclick="f(2)">&nbsp;</div>
            </div>

            <!-- second row -->
            <div class="row">
                <div id ="3" class="square" onclick="f(3)">&nbsp;</div>
                <div id ="4" class="square" onclick="f(4)">&nbsp;</div>
                <div id ="5" class="square" onclick="f(5)">&nbsp;</div>
            </div>

            <!-- third row -->
            <div class="row">
                <div id ="6" class="square" onclick="f(6)">&nbsp;</div>
                <div id ="7" class="square" onclick="f(7)">&nbsp;</div>
                <div id ="8" class="square" onclick="f(8)">&nbsp;</div>
            </div>

        <div class ="history"></br></br>

            <button type="button" class="button-bar" id="reset" onclick="resetGame()">Reset game</button></br></br>

            <a href="history.jsp">History</a>


        </div>


    </div>
    </div>

    </body>

</html>
