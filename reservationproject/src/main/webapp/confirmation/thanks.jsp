<%-- 
    Document   : thanks
    Created on : 02-Dec-2015, 19:07:38
    Author     : Erick
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
    <jsp:body>
        <h2>Thanks for the booking</h2>
        
        
        <p>room Number: ${roomnumber}</p>
        <br/>
        <p>first name: ${firstname}</p>
        <br/>
        <p>last name: ${lastname}</p>
        <br/>
        <p>email: ${email}</p>
        <br/>
        <p>date: ${date}</p>
        <br/>
        <p>Moment: ${select}</p>
        <br/>
        
    </jsp:body>
</t:main>
