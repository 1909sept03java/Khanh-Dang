//Testing Fetch file works with no event handler at the mean time. 

const ul = document.getElementById("people"); // keep constant for the file
var averageValue = 0;
var sum = 0;

function createUser(e) { // create user func ->parent func allow use to create an element 
   return document.createElement(e);
}
function appendUser(parent, e) {
   return parent.appendChild(e); // Append the second element(child) to the first element in parent funct -> method appends a node as the last child of a node.
}

function ageAverage(arr){
   //Find the sum
   var sum = 0;
   for(var i in arr) {
       sum += arr[i];
   }
   //Get the length of the array
   var numbCount = arr.length;
   //Return the average / mean.
   return (sum / numbCount);
}

fetch("https://randomuser.me/api/?results=25")
.then((resp) => resp.json()) // make first request to transfrom data into json
.then(function(data) {// get users data
 let users = data.results;
 return users.map(function(user) { // use .map to return data with keys and values into the results array. 
   let li = createUser('li'), // lists of users
       img = createUser('img'), // user image
       p = createUser('p'); // users name
       a = createUser('a');// users age
       c = createUser('c'); // users location
      
   img.src = user.picture.large; // using API documentation
   p.innerHTML = `Name: ${user.name.first} ${user.name.last}`; //modifying html file, populating the results
   a.innerHTML = `Age: ${user.dob.age}`;
   c.innerHTML = `Location: ${user.location.city}, ${user.location.state}`;
   averageValue = averageValue + user.dob.age;
   appendUser(li, img); // append new child elements to the parent.
   appendUser(li, p);
   appendUser(ul, li);
   appendUser(li, a);
   appendUser(li, c);

   // calculate avg age at the bottom when the 25 ages are shown already.
   averageAge = document.getElementById("averageAge");
   sum = averageValue/25;
   averageAge.innerHTML = `Show average age of these 25 users: ${sum}`;

 })
})
.catch(function(error) {
 console.log(error);
});