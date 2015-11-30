/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// do function to not to be able to choose two equal events in the booking



function showTable(divId, buttonId) {
    if (document.getElementById(buttonId).innerHTML === "Show times already taken in this room") {
        document.getElementById(buttonId).innerHTML = "Hide table";
        document.getElementById(divId).style.visibility = "visible";
    } else {
        document.getElementById(buttonId).innerHTML = "Show times already taken in this room";
        document.getElementById(divId).style.visibility = "hidden";
    }
}
function hideTable(id) {
    var div1 = document.getElementById(id);
    div1.style.visibility = "hidden";
}
