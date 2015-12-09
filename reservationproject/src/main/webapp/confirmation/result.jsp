<%-- 
    Document   : result
    Description: The look of the result page, according to the answer of the FormController servlet
    Created on : 02-Dec-2015, 19:07:38
    Author     : Erik Perez
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
    <jsp:body>
        <c:choose>
            <c:when test="${succeed}">
                <!-- Booking suceeded! -->
                <h2>Thanks for the booking</h2>
                <img src="http://25.media.tumblr.com/tumblr_m2gph3GavN1qzamioo1_500.jpg" alt="success_image" class="img_room"/>
                <div class="result-grid"><table>
                        <thead>
                            <tr><th>Room Number</th><th>First Name</th><th>Last Name</th><th>E-mail</th><th>Booking Date</th><th>From</th><th>To</th></tr>
                        </thead>
                        <tbody>
                            <tr><td>${roomnumber}</td><td>${firstname}</td><td>${lastname}</td><td>${email}</td><td>${date}</td><td>${from}</td><td>${to}</td></tr>
                        </tbody>
                    </table>
                </div> 
                        <p>Total 300 SEK</p>
                        <p>If you miss the booking... it's ok, you can book another time and play</p>
            </c:when>
            <c:otherwise>
                <!-- Booking failed! -->
                <h2>${error}</h2>
                <br/><br/><br/>
                <img src="http://previews.123rf.com/images/aquir/aquir1311/aquir131100094/23420980-Failed-red-grunge-stamp-Stock-Photo.jpg" alt="failed_image" class="img_room"/>
            </c:otherwise>
        </c:choose>


    </jsp:body>
</t:main>
