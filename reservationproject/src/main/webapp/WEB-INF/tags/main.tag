<%-- 
    Document   : base
    Created on : 27-Nov-2015, 15:27:48
    Author     : Erick
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="content" fragment="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- css -->
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/css/main.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/css/footer.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/css/header.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/css/central.css'>
        
        
        <title>El Borracho Studio</title>
    </head>
    <body>
        <div class="header-container" align="center">
            <jsp:include page="/WEB-INF/template/header.jsp"/>
        </div>
        <div class="central-container" align="center">
            <jsp:doBody/>
        </div>
            <div class="footer-container" onmouseover="showFooter();" onmouseout="hideFooter();">
            <jsp:include page="/WEB-INF/template/footer.jsp"/>
        </div>
        <!--scripts-->
        <script type="text/javaScript" src="${pageContext.request.contextPath}/resources/js/footer.js"></script>
        <script type="text/javaScript" src="${pageContext.request.contextPath}/resources/js/rooms.js"></script>
        <script type="text/javaScript" src="${pageContext.request.contextPath}/resources/js/form.js"></script>
    </body>
</html>