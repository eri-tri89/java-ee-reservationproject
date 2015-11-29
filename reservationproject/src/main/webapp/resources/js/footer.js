/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function hideFooter(){
     var footer = document.getElementById("icons-container");
    footer.style.visibility = "collapse";
}
function showFooter(){
    var footer = document.getElementById("icons-container");
    footer.style.visibility = "visible";    
}
function showGmail(){
    var textparaf = document.getElementById("mail");
    textparaf.innerHTML = "eritri89@gmail.com";
}
function showOutlookMail(){
    var textparaf = document.getElementById("mail");    
    textparaf.innerHTML = "eritri89@outlook.com";
}
function showBlank(){
    var textparaf = document.getElementById("mail");    
    textparaf.innerHTML = "Contact me";
}
function showFB(){
      var textparaf = document.getElementById("mail");    
    textparaf.innerHTML = "Contact me on facebook";
}
function showLinkedIn(){
      var textparaf = document.getElementById("mail");    
    textparaf.innerHTML = "Contact me on LinkedIn";
}
function showTwitter(){
      var textparaf = document.getElementById("mail");    
    textparaf.innerHTML = "Contact me on Twitter";
}
