/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/************************************ Manipulating booking inputs *******************************/

function setBookingValue(value) {

    var datePicker1 = document.getElementById('datePicker1');
    var select1 = document.getElementById('select1');
    var paraf1 = document.getElementById('date1p');

    var datePicker2 = document.getElementById('datePicker2');
    var select2 = document.getElementById('select2');
    var paraf2 = document.getElementById('date2p');

    var datePicker3 = document.getElementById('datePicker3');
    var select3 = document.getElementById('select3');
    var paraf3 = document.getElementById('date3p');

    if (value == 0) {
        disableBookingOption(paraf1, select1, datePicker1);
        disableBookingOption(paraf2, select2, datePicker2);
        disableBookingOption(paraf3, select3, datePicker3);
    }

    if (value == 1) {
        enableBookingOption(paraf1, select1, datePicker1);

        if (datePicker2.disabled === false) {
            disableBookingOption(paraf2, select2, datePicker2);
        }
        if (datePicker3.disabled === false) {
            disableBookingOption(paraf3, select3, datePicker3);
        }
    }

    if (value == 2) {
        enableBookingOption(paraf1, select1, datePicker1);
        enableBookingOption(paraf2, select2, datePicker2);

        if (datePicker3.disabled === false) {
            disableBookingOption(paraf3, select3, datePicker3);
        }
    }

    if (value == 3) {
        enableBookingOption(paraf1, select1, datePicker1);
        enableBookingOption(paraf2, select2, datePicker2);
        enableBookingOption(paraf3, select3, datePicker3);
    }
}

function enableBookingOption(paraf, select, datePicker) {
    showDateParaf(paraf);
    enableSelectInput(select);
    enableDateInput(datePicker);
}

function disableBookingOption(paraf, select, datePicker) {
    hideDateParaf(paraf);
    disableSelectInput(select);
    disableDateInput(datePicker);
}

function showDateParaf(paraf) {
    paraf.style.visibility = 'visible';
}

function hideDateParaf(paraf) {
    paraf.style.visibility = 'hidden';
}

function enableSelectInput(select) {
    select.disabled = false;
    select.value = '10:00-13:00';
    select.style.visibility = 'visible';
}

function disableSelectInput(select) {
    select.disabled = true;
    select.value = 'noTime';
    select.style.visibility = 'hidden';
}

function enableDateInput(datePicker) {
    datePicker.disabled = false;
    datePicker.valueAsDate = new Date();
    datePicker.min = datePicker.value;
    datePicker.style.visibility = 'visible';
}

function disableDateInput(datePicker) {
    datePicker.valueAsDate = "dd-mm-yyyy";
    datePicker.disabled = true;
    datePicker.style.visibility = 'hidden';
}

/********************************* Check Warnings **************************************/

/*
 * Inputs not verified yet 02/12/2015
 * 
 * */



