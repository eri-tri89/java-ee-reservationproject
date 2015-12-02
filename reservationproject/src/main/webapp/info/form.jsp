<%-- 
    Document   : form
    Created on : 27-Nov-2015, 16:03:32
    Author     : Erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
    <jsp:body>
        <div class="form-div">
        <h2>Booking the rehearsal room $number</h2>

        <form action="${pageContext.request.contextPath}/confirmation/thanks.jsp" method="get" id="form">
            <table>
                <tr>
                    <td><p class="p-form">First Name</p> </td>
                    <td><input type="text" name="firstName" class="input" id="firstNameInp" required/></td>                    
                </tr>
                <tr>
                    <td><p  class="p-form">Last Name</p></td>
                    <td><input type="text" name="lastName" class="input" id="lastNameInp" required/></td>
                </tr>
                <tr>
                    <td><p  class="p-form">E-mail</p></td>
                    <td><input type="email" name="email" class="input" id="emailInp" required/></td>
                </tr>
                <tr>
                    <td><p class="p-form">Times You want to book </p></td>
                    <td>
                        <select class="input" onmouseover="setBookingValue(this.value);"
                                onchange="setBookingValue(this.value);">
                            <option value="0" default>-- Select Times --</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><p class="p-form" id="date1p">Choose Time </p></td>
                    <td><input type="date" name="date1" min="2014-01-12" id="datePicker1" class="input" disabled /></td>
                    <td>
                         <select name="select1" id="select1" disabled class="input">
                            <option value="noTime" default>-- Choose time --</option>
                            <option value="10:00-13:00">From 10:00 - To 13:00</option>
                            <option value="14:00-17:00">From 14:00 - To 17:00</option>
                            <option value="18:00-21:00">From 18:00 - To 21:00</option>
                        </select>
                    </td>
                </tr>                
                <tr>
                    <td><p  class="p-form" id="date2p">Choose Time </p></td>
                    <td><input type="date" name="date2" min="2014-01-12" id="datePicker2" class="input" disabled/></td>
                    <td>
                         <select name="select2" id="select2" disabled class="input">
                             <option value="noTime" default>-- Choose time --</option>
                            <option value="10:00-13:00">From 10:00 - To 13:00</option>
                            <option value="14:00-17:00">From 14:00 - To 17:00</option>
                            <option value="18:00-21:00">From 18:00 - To 21:00</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><p  class="p-form" id="date3p">Choose Time </p></td>
                    <td><input type="date" name="date3" min="2014-01-12" id="datePicker3" class="input" disabled/></td>
                    <td><select name="select3" id="select3" disabled class="input">
                             <option value="noTime" default>-- Choose time --</option>
                            <option value="10:00-13:00">From 10:00 - To 13:00</option>
                            <option value="14:00-17:00">From 14:00 - To 17:00</option>
                            <option value="18:00-21:00">From 18:00 - To 21:00</option>
                        </select>
                    </td>
                </tr>
            </table>
            <br/><br/><br/>
            <input type="submit" value="Confirm Booking" id="confirmButton"/>
        </form>
        </div>
    </jsp:body>
</t:main>
