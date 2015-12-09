<%-- 
    Document   : form
    Description: general structure of the form
    Created on : 27-Nov-2015, 16:03:32
    Author     : Erik Perez
--%>


<div class="form-div">    
        <table>
            <tr>
                <td><p class="p-form">First Name</p> </td>
                <td><input type="text" name="firstname" class="input" id="firstNameInp" required/></td>
                <td class="p-form"><p>Choose Time here:</p></td>
            </tr>
            <tr>
                <td><p  class="p-form">Last Name</p></td>
                <td><input type="text" name="lastname" class="input" id="lastNameInp" required/></td>
                <td><input type="date" name="date" min="2014-01-12" id="datePicker" class="input" onmouseover="setDatePickerValue(this);" /></td>
            </tr>
            <tr>
                <td><p  class="p-form">E-mail</p></td>
                <td><input type="email" name="email" class="input" id="emailInp" required/></td>
                 <td>
                    <select name="select" id="select" class="input">
                        <option value="10:00-13:00" default>From 10:00 - To 13:00</option>
                        <option value="14:00-17:00">From 14:00 - To 17:00</option>
                        <option value="18:00-21:00">From 18:00 - To 21:00</option>
                    </select>
                </td>
            </tr>         
        </table>        
</div>

