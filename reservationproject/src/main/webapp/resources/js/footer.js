/* 
 * all the js functions done in the footer of the site
 * @author Erik Perez
 * @version 1.0
 */

/**
 * This function hides the contact side in the footer
 * */
function hideFooter(){
     var footer = document.getElementById("icons-container");
    footer.style.visibility = "collapse";
}
/**
 * This function shows the contact side in the footer
 * */
function showFooter(){
    var footer = document.getElementById("icons-container");
    footer.style.visibility = "visible";    
}
/**
 * This function shows the author's gmail
 * */
function showGmail(){
    var textparaf = document.getElementById("mail");
    textparaf.innerHTML = "eritri89@gmail.com";
}
/**
 * This function shows the author's outlook mail
 * */
function showOutlookMail(){
    var textparaf = document.getElementById("mail");    
    textparaf.innerHTML = "eritri89@outlook.com";
}
/**
 * This function shows only the following sentence 'contact me'
 * */
function showBlank(){
    var textparaf = document.getElementById("mail");    
    textparaf.innerHTML = "Contact me";
}
/**
 * This function shows only the following sentence 'contact me on LinkedIn'
 * */
function showLinkedIn(){
      var textparaf = document.getElementById("mail");    
    textparaf.innerHTML = "Contact me on LinkedIn";
}
/**
 * This function shows only the following sentence 'contact me on Twitter'
 * */
function showTwitter(){
      var textparaf = document.getElementById("mail");    
    textparaf.innerHTML = "Contact me on Twitter";
}
