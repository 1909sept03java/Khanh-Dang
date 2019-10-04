window.onload = function() {
	populateUser();
}

async function populateUser() {

	try {
		let [response, plist] = await Promise.all([fetch('http://localhost:8082/Project1/session'),
			fetch('http://localhost:8082/EmployeeManagement/empundman')]);
		const list = await plist.json();
		const data = await response.json();
		let i = 1;
		if(data.session === null) {
			window.location = "http://localhost:8082/Project1/login"
		} else {
			user = data;
			document.getElementById("welcomemanager").innerText = "Welcome " + data.employeeUsername + " To Your Employee Portal!";
			let table = document.getElementById("table");
			list.forEach(element => {
				let tr = document.createElement("tr");
				
				tr.innerHTML = `
					<td>${element.employeeId}</td>
					<td>${element.reimbursementBalance}</td>
					<td>${element.reimbursementStatus}</td>
					`;
				table.appendChild(tr);
				i++;
			});
			
		}
	} catch(error) {
		console.log(error);
	}
}