
/** 
 * all the js functions done in the forms
 * @author Erik Perez
 * @version 1.0
 */


/**
 * This function gives the current date to the input date, and also sets it as a minimum
 * @param {input date} datePicker the date input to be affected
 * */
function setDatePickerValue(datePicker) {
    if (datePicker.value == '') {
        datePicker.valueAsDate = new Date();
        datePicker.min = datePicker.value;

    }
}






