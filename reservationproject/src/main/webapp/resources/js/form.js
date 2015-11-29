/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createBookingForm(limit){
    var container = document.getElementById("bookingForm").firstChild;
    var tag = 'input';
    var types = ['date'];
    for(var n=0;0 < (limit);n++){
        //createInput(container,tag,types[0],'form-type');
        container.innerHTML = 'something';
    }
}

function createInput(container,tag,type,className){
    var input = document.createElement(tag);
    input.type = type;
    input.className = className;
    container.appendChild(input);
}
