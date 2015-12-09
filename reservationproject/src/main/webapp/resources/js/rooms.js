
/** 
 * all the js functions done in the rooms.jsp site
 * @author Erik Perez
 * @version 1.0
 */

/**
 * This function shows and hides the table in the rooms.jsp site
 * @param {id} divId the id of the div tag to be affected
 * @param {id} buttonId the id of the button that will affect the div
 * */
function showTable(divId, buttonId) {
    if (document.getElementById(buttonId).innerHTML === "Show times already taken in this room") {
        document.getElementById(buttonId).innerHTML = "Hide table";
        document.getElementById(divId).style.visibility = "visible";
    } else {
        document.getElementById(buttonId).innerHTML = "Show times already taken in this room";
        document.getElementById(divId).style.visibility = "hidden";
    }
}
/**
 * This function hides the table
 * @param {id} id the id of the div tag to be affected
 * */
function hideTable(id) {
    var div1 = document.getElementById(id);
    div1.style.visibility = "hidden";
}
