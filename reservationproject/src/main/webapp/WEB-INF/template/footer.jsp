<%-- 
    Document   : footer
    Description: The look of the site's footer
    Created on : 27-Nov-2015, 15:00:07
    Author     : Erick
--%>
<!--Elements inside Footer div-->
<div>
    <div class="text-container" onmouseout="showBlank();">
        <table>
            <tr>
                <td> <h1 id="foot-h2">Site designed and created by Erik Perez<span>&#169;</span> </h1></td>
                <td><img src="${pageContext.request.contextPath}/images/self-portrait.jpg" alt="self portrait" class="self-portrait-img" align="center"></td>
            </tr>
        </table>
    </div>
    <div class="icons-container" id="icons-container" align="center">
        <p id="mail">Contact me</p>
        <a href="https://twitter.com/eritri89" target="_blank">
            <img src="${pageContext.request.contextPath}/images/icons/twitter_icon.png" alt="twitter icon" class="icon" onmouseover="showTwitter();"/>
        </a>    
        <a href="https://se.linkedin.com/in/erik-perez-b91ba3a4" target="_blank">
            <img src="${pageContext.request.contextPath}/images/icons/linkedin_icon.png" alt="linkedin icon" class="icon" onmouseover="showLinkedIn();"/>
        </a>
        <img src="${pageContext.request.contextPath}/images/icons/gmail_icon.png" alt="gmail icon" class="icon" id="gmail-icon" onmouseover="showGmail();"/>
        <img src="${pageContext.request.contextPath}/images/icons/outlook_icon.png" alt="outlook icon" class="icon" id="outlook-icon" onmouseover="showOutlookMail();"/>
    </div>
</div>


