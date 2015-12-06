<%-- 
    Document   : rooms
    Created on : 27-Nov-2015, 16:16:56
    Author     : Erick
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
    <jsp:body>
        <p>${notAllowedMessage}</p>
        <h2>Rehearsal Rooms</h2>
        <p>Something about the rooms, the prices and the quality of the rooms</p>
        <br/><br/><br/>        
        <div>           
            <div>
                <h3>Rehearsal Room 1</h3>
                <img src="${pageContext.request.contextPath}/images/rooms/rehearsal-room1.jpg" alt="rehearsal room 1" class="img_room"/>
            </div>
            <div>
                <button type="button" onclick="showTable('times-table1', 'showButton1');" id="showButton1" class="showhideBtn">Show times already taken in this room</button>
                <div class="datagrid-container" id="times-table1">
                    <!-- show table from room 1 here-->
                    <div class="datagrid"><table>
                            <thead>
                                <tr><th>Date</th><th>From</th><th>To</th></tr>
                            </thead>
                            <tbody>                                
                                <c:choose>
                                    <c:when test="${not empty roomlist1}">
                                        <c:forEach var="booking" items="${roomlist1}">
                                            <tr>
                                                <td>${booking.bookingDate}</td><td>${booking.startTime}</td><td>${booking.endTime}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td>None</td><td>None</td><td>None</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>                                              
                    </div>
                    <form action="FormController" method="post">
                        <input type="hidden" name="roomnumber" value="1"/>
                        <jsp:include page="form.jsp"/>
                        <input class="table-button" type="submit" value="Confirm booking"/>
                    </form> 
                </div>
            </div>
        </div>
        <div>            
            <div>
                <h3>Rehearsal Room 2</h3>
                <img src="${pageContext.request.contextPath}/images/rooms/rehearsal-room2.jpg" alt="rehearsal room 2" class="img_room"/>
            </div>
            <div>
                <button type="button" onclick="showTable('times-table2', 'showButton2');" id="showButton2" class="showhideBtn">Show times already taken in this room</button>
                <div class="datagrid-container" id="times-table2">
                    <!-- show table from room 2 here-->
                    <div class="datagrid"><table>
                            <thead>
                                <tr><th>Date</th><th>From</th><th>To</th></tr>
                            </thead>
                            <tbody>
                               <c:choose>
                                    <c:when test="${not empty roomlist2}">
                                        <c:forEach var="booking" items="${roomlist2}">
                                            <tr>
                                                <td>${booking.bookingDate}</td><td>${booking.startTime}</td><td>${booking.endTime}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td>None</td><td>None</td><td>None</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>
                    <form action="FormController" method="post">
                        <input type="hidden" name="roomnumber" value="2"/>
                        <jsp:include page="form.jsp"/>
                        <input class="table-button" type="submit" value="Confirm booking"/>
                    </form>
                </div>
            </div>
        </div>
        <div>            
            <div>
                <h3>Rehearsal Room 3</h3>
                <img src="${pageContext.request.contextPath}/images/rooms/rehearsal-room3.jpg" alt="rehearsal room 3" class="img_room"/>
            </div>
            <div>
                <button type="button" onclick="showTable('times-table3', 'showButton3');" id="showButton3" class="showhideBtn">Show times already taken in this room</button>
                <div class="datagrid-container" id="times-table3">
                    <!-- show table from room 3 here-->
                    <div class="datagrid"><table>
                            <thead>
                                <tr><th>Date</th><th>From</th><th>To</th></tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${not empty roomlist3}">
                                        <c:forEach var="booking" items="${roomlist3}">
                                            <tr>
                                                <td>${booking.bookingDate}</td><td>${booking.startTime}</td><td>${booking.endTime}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td>None</td><td>None</td><td>None</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>
                    <form action="FormController" method="post">
                        <input type="hidden" name="roomnumber" value="3"/>
                        <jsp:include page="form.jsp"/>
                        <input class="table-button" type="submit" value="Confirm booking"/>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:main>
