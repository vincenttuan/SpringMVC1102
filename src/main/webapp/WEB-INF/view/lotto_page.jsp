<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lotto Page</title>
    </head>
    <body>
        <h1>本期電腦選號是:</h1>
        <%=request.getAttribute("lotto") %>
        ${ requestScope.lotto }
        ${ lotto }
    </body>
</html>
