<%-- 
    Document   : thanks
    Created on : 02-Dec-2015, 19:07:38
    Author     : Erick
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
    <jsp:body>
        <c:choose>
            <c:when test="${succeed}">
                <h2>Thanks for the booking</h2>
                
                <table>
                    <tr>
                        <td><p>room Number:</p></td>
                        <td><p>${roomnumber}</p></td>
                    </tr>                    
                    <tr>
                        <td><p>first name:</p></td>
                        <td><p>${firstname}</p></td>
                    </tr>                    
                    <tr>
                        <td><p>last name:</p></td>
                        <td><p>${lastname}</p></td>
                    </tr>
                    <tr>
                        <td><p>email:</p></td>
                        <td><p>${email}</p></td>
                    </tr>
                    <tr>
                        <td><p>date:</p></td>
                        <td><p>${date}</p></td>
                    </tr>
                    <tr>
                        <td><p>Moment:</p></td>
                        <td><p>from ${from} -  to ${to}</p></td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <h2>${error}</h2>
                <br/><br/><br/>
                <img src="http://previews.123rf.com/images/aquir/aquir1311/aquir131100094/23420980-Failed-red-grunge-stamp-Stock-Photo.jpg" class="img_room"/>
            </c:otherwise>
        </c:choose>


    </jsp:body>
</t:main>
