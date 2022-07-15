let employeeList = document.getElementById("employees");

async function getEmployees() {
  let response = await fetch(`${apiUrl}/users`);

  if(response.status == 200) {
    let data = await response.json();

    for (employee in data) {
      let employeeItem = document.createElement('li');
      employeeItem.classList.add("list-group-item");
      employeeItem.innerHTML = `${data[employee].username}`;
      employeeList.appendChild(employeeItem);
    }
  } else {
    console.log('Unable to retrieve employees.')
  }
}

getEmployees();