function validate_input() {

		var value_of_dropdown = document.SearchEmployee.drop.value;
		var entered_parameter = document.SearchEmployee.param.value;
		
		if (value_of_dropdown == "select") {
			document.getElementById("error").innerHTML = "*select an option!";
			return false;
		}
		if (value_of_dropdown == "id") {
			if (entered_parameter == "" || entered_parameter.length != 5 || isNaN(entered_parameter)) {
				document.getElementById("error").innerHTML = "*Enter valid ID!";
				return false;
			}
		}
		if (value_of_dropdown == "name") {
			if (entered_parameter == "" || !entered_parameter.match(/^[a-zA-Z ]+$/)) {
				document.getElementById("error").innerHTML = "*Enter valid name!";
				return false;
			}
		}
		if (value_of_dropdown == "mobile") {
			if (entered_parameter == "" || entered_parameter.length != 10 || isNaN(entered_parameter)) {
				document.getElementById("error").innerHTML = "*Enter valid mobile number!";
				return false;
			}
		}
		if (value_of_dropdown == "dept") {
			if (entered_parameter == "" || !entered_parameter.match(/^[a-zA-Z ]+$/)) {
				document.getElementById("error").innerHTML = "*Enter valid department!";
				return false;
			}
		}
		return true;
	}
