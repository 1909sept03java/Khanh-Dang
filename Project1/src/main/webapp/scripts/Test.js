let user = {};

window.onload = function() {
	populateUser();
}

async function populateUser() {

	try {
		let [response, reqlist] = await Promise.all([fetch('http://localhost:8082/Project1/session'),
			fetch('http://localhost:8082/Project1/requestsession')]);
		const list = await reqlist.json();
		const data = await response.json();
		let i = 1;
		if(data.session === null) {
			window.location = "http://localhost:8082/Project1/login"
		} else {
			//define behavior for when a user is returned
			user = data;
			document.getElementById("welcome").innerText = "Welcome " + data.employeeUsername + " To Your Employee Portal!";
			let table = document.getElementById("table");
			list.forEach(element => {
				let tr = document.createElement("tr");
				
				tr.innerHTML = `
					<td>${element.employeeId}</td>
					<td>${element.reimbursementBalance}</td>
					<td>${element.reimbursementStatus}</td>
					<td>${element.Note}</td>
					`;
				table.appendChild(tr);
				i++;
			});
		}
	} catch(error) {
		console.log(error);
	}
}