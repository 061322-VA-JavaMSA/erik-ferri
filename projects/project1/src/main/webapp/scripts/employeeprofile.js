let employeeName = document.getElementById("employee-name");
let employeeUsername = document.getElementById("employee-username");

console.log(principal);

employeeName.innerHTML += `<b>${principal.userFirstName} ${principal.userLastName}</b> <i class="fa fa-pencil" aria-hidden="true"></i>`;
employeeUsername.innerHTML += `${principal.username} <i class="fa fa-pencil" aria-hidden="true" onclick='updateUsername()'></i>`;

async function updateUsername() {
    let username = prompt("Please enter your new username");
    console.log(username);

    if (username != null) {
            const data = {
              id: principal.id,
              username: username
            }
            const response = await fetch(`${apiUrl}/users/?id=${data.id}&username=${data.username}`, {
              method: 'PUT',
              headers: {
                'Content-Type': 'application/json'
              },
              body: JSON.stringify(data) // body data type must match "Content-Type" header
            });
            window.location.href="./employeemain.html";
            return response.json(); // parses JSON response into native JavaScript objects
    }
}