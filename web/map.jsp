<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/mapstyle.css">
        <title>Map Page</title>
    </head>
    <body>
        <h1>Map of Red Bud Square</h1>
        <img src="images/map.png" width="800" height="800" alt="Red Bud Square Map"/>
        <div class="forms">
            <form name="buildingNameForm" method="get" action="InfoServlet">
                Enter a building to learn more about:
                <div class="inputs">
                    <input type="text" name="buildingName" value="Ex: City Hall" />
                    <input type="submit" value="Enter" />
                </div>
            </form>
            <form name="backForm" action="index.jsp" method="POST">
                <input type="submit" value="Back" />
            </form>
        </div>
        <p>do not enter: destroy computer</p>
    </body>
</html>
