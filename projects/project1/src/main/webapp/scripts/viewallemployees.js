let employeeList = document.getElementById("employees");

async function getEmployees() {
  let response = await fetch(`${apiUrl}/users`);

  if(response.status == 200) {
    let data = await response.json();

    for (employee in data) {
      let EmployeeItem = document.createElement('li');
      EmployeeItem.innerHTML = `${data[employee].username}`;
      employeeList.appendChild(EmployeeItem);
    }
  } else {
    console.log('Unable to retrieve employees.')
  }
}

getEmployees();