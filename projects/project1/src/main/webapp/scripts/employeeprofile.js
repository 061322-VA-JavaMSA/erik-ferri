let employeeName = document.getElementById("employee-name");
let employeeUsername = document.getElementById("username");

console.log(principal);

employeeName.innerHTML += `<b>${principal.userFirstName} ${principal.userLastName}</b> <i class="fa fa-pencil" aria-hidden="true"></i>`;
employeeUsername.innerHTML += principal.username;