<%-- 
    Document   : form
    Created on : 27-Nov-2015, 16:03:32
    Author     : Erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
    <jsp:body>

        <h2>Booking the rehearsal room $number</h2>


        <div>
            <table>
                <tr>
                    <td><p>First Name</p> </td>
                    <td><input type="text" name="firstName" class="input"/></td>
                    <td><p id="warning1"></p></td>
                </tr>
                <tr>
                    <td><p>Last Name</p></td>
                    <td><input type="text" name="lastName" class="input"/></td>
                    <td><p id="warning2"></p></td>
                </tr>
                <tr>
                    <td><p>E-mail</p></td>
                    <td><input type="email" name="email" class="input"/></td>
                    <td><p id="warning3"></p></td>
                </tr>
                <tr>
                    <td><p>Times You want to book </p></td>
                    <td>
                        <select><!-- onchange="createBookingForm(this.value)"-->
                            <option value="1" default>1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
                    </td>
                    <td><p id="warning4"></p></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><p>Date </p></td>
                    <td><input type="date" name="date1"/></td>
                    <td><p id="warning4"></p></td>
                </tr>
                <tr>
                    <td><p>From - to </p></td>
                    <td>
                         <select name="timelapse1">
                            <option value="10:00-13:00" default>From 10:00 - To 13:00</option>
                            <option value="14:00-17:00">From 14:00 - To 17:00</option>
                            <option value="18:00-21:00">From 18:00 - To 21:00</option>
                        </select>
                    </td>
                    <td><p id="warning5"></p></td>
                </tr>
                <tr>
                    <td><p>Date </p></td>
                    <td><input type="date" name="date2"/></td>
                </tr>
                <tr>
                    <td><p>From - to </p></td>
                    <td>
                         <select name="timelapse2">
                            <option value="10:00-13:00" default>From 10:00 - To 13:00</option>
                            <option value="14:00-17:00">From 14:00 - To 17:00</option>
                            <option value="18:00-21:00">From 18:00 - To 21:00</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><p>Date </p></td>
                    <td><input type="date" name="date3"/></td>
                </tr>
                <tr>
                    <td><p>From - to </p></td>
                    <td>
                         <select name="timelapse3">
                            <option value="10:00-13:00" default>From 10:00 - To 13:00</option>
                            <option value="14:00-17:00">From 14:00 - To 17:00</option>
                            <option value="18:00-21:00">From 18:00 - To 21:00</option>
                        </select>
                    </td>
                </tr>
            </table>
        </div>  
    </jsp:body>
</t:main>
