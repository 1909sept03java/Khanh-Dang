window.onload = function () {
    document.getElementById("fetchPeople").addEventListener("click", getPeopleWithFetchAndAsync);
}
let apiUrl = "https://randomuser.me/api/?results=25";
let state = { people: '' };
let updateContent = function() {
    document.getElementById('people').innerText = state.people;
}

async function getPeopleWithFetchAndAsync() {
    // clean up the Promises syntax, fewer chained .then() statements..
    try {
        let response = await fetch(apiUrl, {method:"GET", headers:{"Accept":"application/json"}});
        let data = await response.json();
        state.people = data.people;
        updateContent();
    } catch(error) {
        console.log(error);
    }
}

function getPeopleWithFetch() {
    fetch(apiUrl, {method:"GET", headers:{"Accept":"application/json"}})
        //define behavior for when response returns
        .then((response) => {
            //return unwrapped promise object for the next chained operation
            let data = response.json();
            return data;
        })
        // utilize unwrapped promise as a JS object
        .then((data) => {
            console.log(data);
            state.people = data.people;
            updateContent();
        })
        //storing data to display
        data.results.forEach(people => 
        {
            p = `<div>
            <img src="${people.picture.medium}" class="img-rounded" alt="Cinque Terre">
            <span style="margin-left:25px;">${people.name.title}  ${people.name.first} ${people.name.last}</span>
            <span>(${people.nat})</span>
            <span style="margin-left:350px;">Email: ${people.email}</span>
            </div>`;
            //console.log(p);
            //$("#result").append(p);
        })
        //what if there's a problem?
        .catch((error) => {
            alert('oh no :(');
            console.log(error);
        });
}