/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/************************************ Manipulating booking inputs *******************************/
/**
 * @param {input date} datePicker description
 * */
function setDatePickerValue(datePicker) {
    if (datePicker.value == '') {
        datePicker.valueAsDate = new Date();
        datePicker.min = datePicker.value;

    }
}
/********************************* Check Warnings **************************************/






