let user = {};

window.onload = function() 
{
	populateUser();
}
let list;
function populateUser() 
{
	// send a GET request to SessionServlet to obtain session information
	Promise.all([
		fetch("http://localhost:8082/Project1/session"),
		fetch("http://localhost:8082/Project1/requestsession"),
	  ]).then(allResponses => {
		  const response1 = allResponses[0]
		  const response2 = allResponses[1]

		
		//fetch("http://localhost:8082/Project1/session").then(function(response) 
	
		return response2.json();
		return response1.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
		console.log(response2);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8082/Project1/login"
		} else {
			//define behavior for when a user is returned
			user = data;
			document.getElementById("welcome").innerText = "Welcome " + data.employeeUsername + " To Your Employee Portal!";
			let table = document.getElementById("table");
			list.forEach(element => {
				let tr = document.createElement("tr");
				let date = element.s_date.dayOfMonth+'/'+element.s_date.monthValue+'/'+element.s_date.year;

				tr.innerHTML = `<th scope="row">${i}</th>
					<td>${element.Amount}</td>
					<td>${element.Status}</td>
					<td>${element.Note}</td>
					`;
				table.appendChild(tr);
				i++;
			
		})
	}}). then .then(function(data){};
}
	
	
