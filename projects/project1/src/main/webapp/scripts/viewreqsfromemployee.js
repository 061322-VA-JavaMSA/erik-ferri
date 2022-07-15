let employeeList = document.getElementById("employees");
let employeeReqs = document.getElementById("employee-reqs");

async function getEmployees() {
  let response = await fetch(`${apiUrl}/users`);

  if(response.status == 200) {
    let data = await response.json();

    for (employee in data) {
      let EmployeeItem = document.createElement('li');
      EmployeeItem.innerHTML = `<li><button class="dropdown-item" type="button" onclick='getEmployeeReqs(${data[employee].id})'>${data[employee].userFirstName} ${data[employee].userLastName}</button></li>`;
      employeeList.appendChild(EmployeeItem);
    }
  } else {
    console.log('Unable to retrieve employees.')
  }
}

getEmployees();

async function getEmployeeReqs(id) {
  employeeReqs.innerHTML = "";
  let response = await fetch(`${apiUrl}/reimbursements/${id}`);

  if(response.status == 200) {
    let data = await response.json();
    console.log(data);

    for (reimbReq in data) {
      let employeeReqItem = document.createElement('li');
      employeeReqItem.classList.add("list-group-item");
      employeeReqItem.innerHTML = `${data[reimbReq].reimbType} - $${data[reimbReq].reimbAmount}: ${data[reimbReq].reimbDescription} - ${data[reimbReq].reimbStatus}`;
      employeeReqs.appendChild(employeeReqItem);
    }
  } else {
    console.log('Unable to retrieve requests.')
  }
}