//Testing Fetch file works with no event handler at the mean time. 
const url = "https://randomuser.me/api/?results=25";
const ul = document.getElementById("people");

function createUser(e) { // create user func
   return document.createElement(e);
}
function append(parent, e) {
   return parent.appendChild(e); // Append the second element to the first element in parent
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

fetch(url)
.then((resp) => resp.json())
.then(function(data) {
 let users = data.results;
 return users.map(function(user) {
   let li = createUser('li'),
       img = createUser('img'),
       p = createUser('p');
       a = createUser('a');
   img.src = user.picture.thumbnail;
   p.innerHTML = `${user.name.first} ${user.name.last}`;
   a.innerHTML = `${user.dob.age}`;
   append(li, img);
   append(li, p);
   append(ul, li);
   append(li, a);

   /*sum += user.dob.age;
       avg = sum/25;
       avgAge = document.getElementById("averageAge");
       avgAge.innerHTML = 'Average age: ${avg}';
       console.log(avg);*/
 })
})
.catch(function(error) {
 console.log(error);
});