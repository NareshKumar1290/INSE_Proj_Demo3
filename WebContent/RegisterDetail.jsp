
<script>
	window.onload = function() {
		document.getElementById("form-client").style.display = "none";
		document.getElementById("form-worker").style.display = "none";
	}
	
	function validateForm() {
		var fname = document.forms["Registration"]["firstName"].value;
		var mname = document.forms["Registration"]["middleName"].value;
		var lname = document.forms["Registration"]["lastName"].value;
		var email = document.forms["Registration"]["emailAddress"].value;
		var password = document.forms["Registration"]["password"].value;
		var phonenumber = document.forms["Registration"]["phoneNumber"].value;
		var address1 = document.forms["Registration"]["addressLine1"].value;
		var address2 = document.forms["Registration"]["addressLine2"].value;
		var city = document.forms["Registration"]["city"].value;
		var province = document.forms["Registration"]["province"].value;
		var postalc = document.forms["Registration"]["postalCode"].value;
		var country = document.forms["Registration"]["country"].value;

		if (fname == null || fname == "") {
			alert("name must be filled out");
			return false;
		}
		if (lname == null || lname == "") {
			alert("last name must be filled out");
			return false;
		}
		if (email == null || email == "") {
			alert("email must be filled out");
			return false;
		}
		if (password == null || password == "") {
			alert("password must be filled out");
			return false;
		}
		if (phonenumber == null || phonenumber == "") {
			alert("phonenumber must be filled out");
			return false;
		}
		if (address1 == null || address1 == "") {
			alert("address1 must be filled out");
			return false;
		}
		if (city == null || city == "") {
			alert("city must be filled out");
			return false;
		}
		if (province == null || province == "") {
			alert("province must be filled out");
			return false;
		}
		if (postalc == null || postalc == "") {
			alert("postalc must be filled out");
			return false;
		}
		if (country == null || country == "") {
			alert("country must be filled out");
			return false;
		}
}

	function displayForm(valueofSelection) {
		var selection = document.getElementById("optionValue");
		var final_selection = selection.options[selection.selectedIndex].text;
		if (valueofSelection == "client" || valueofSelection == "Client") {
			document.getElementById("form-client").style.display = "";
			document.getElementById("form-worker").style.display = "none";
		} else if (valueofSelection == "worker" || valueofSelection == "Worker") {
			document.getElementById("form-worker").style.display = "";
			document.getElementById("form-client").style.display = "none";
		} else {
			document.getElementById("form-worker").style.display = "none";
			document.getElementById("form-client").style.display = "none";
		}
	}
</script>


<form name="Registration" action="RegisterDetailConfirmation.jsp"
	onsubmit="return validateForm()" method="post">
	<h1>Kindly Register yourself at Client or Worker. Thanks !!!!</h1>
	First Name : <input type="text" name="firstName" /><br />
	<br /> Middle Name : <input type="text" name="middleName" /><br />
	<br /> Last Name : <input type="text" name="lastName" /><br />
	<br /> Email Address : <input type="text" name="emailAddress" /><br />
	<br /> Password : <input type="text" name="password" /><br />
	<br /> Phone Number : <input type="text" name="phoneNumber" /><br />
	<br /> Address Line 1 : <input type="text" name="addressLine1" /><br />
	<br /> Address Line 2 : <input type="text" name="addressLine2" /><br />
	<br /> City : <input type="text" name="city" /><br />
	<br /> Province : <input type="text" name="province" /><br />
	<br /> Postal Code : <input type="text" name="postalCode" /><br />
	<br /> Country : <input type="text" name="country" /><br />
	
	<br /> <br /> <select id="optionValue" name="optionValue" onmousedown="this.value='';" onchange="displayForm(this.value)">
		<option value="default">Plz Choose</option>
		<option value="client">Client</option>
		<option value="worker">Worker</option>
	</select>

	<div id="form-client" class="form-client">
		<h2>Client Registration</h2>
		Company Name: <input type="text" name="cName"> <br>
		Company Address: <input type="text" name="cAddress"> <br>
		Credit Card Holder Name: <input type="text" name="creditCardHoldername"><br>
		Credit Card Number: <input type="number" name="creditCardNumber"> <br> 
		Credit Card Expiry Date: <input type="date" name="creditCardExpiry"> <br> 
		Credit Card Security Code: <input type="number" name="creditCardSecurityCode"> <br>
	</div>

	<div id="form-worker" class="form-worker">
		<h2>Worker Registration</h2>
		Credit Card / Paypal Account Number <input type="text" name="creditCardNumber"> <br>
	</div>

	<br/>
	<input type="submit" value="Register" />
</form>