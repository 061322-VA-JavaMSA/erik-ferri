let pendingReqsList = document.getElementById("pending-reqs");

async function getPendingReqs() {
  let response = await fetch(`${apiUrl}/reimbursements`);

  if(response.status == 200) {
    let data = await response.json();

    for (reimbReq in data) {
      let pendingReqItem = document.createElement('li');
      pendingReqItem.classList.add("list-group-item");
      pendingReqItem.innerHTML = `<span class="check icon-span" onclick="approve(${data[reimbReq].id})"><i class="fas fa-check-square"></i></span><span class="trash icon-span" onclick="deny(${data[reimbReq].id})"><i class="fas fa-trash-alt"></i></span>${data[reimbReq].reimbType} - $${data[reimbReq].reimbAmount}: ${data[reimbReq].reimbDescription}           - <span class="submitted-by">Submitted by ${data[reimbReq].userId}</span>`;
      pendingReqsList.appendChild(pendingReqItem);
    }
  } else {
    console.log('Unable to retrieve users.')
  }
}

getPendingReqs();

async function approve(id) {
  const data = {
    reimbId: id,
    reimbStatus: "approved",
    reimbResolverId: principal.id
  }
  const response = await fetch(`${apiUrl}/reimbursements/?id=${data.reimbId}&reimbStatus=${data.reimbStatus}&reimbResolverId=${data.reimbResolverId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });
  location.reload();
  return response.json(); // parses JSON response into native JavaScript objects
}

async function deny(id) {
  const data = {
    reimbId: id,
    reimbStatus: "denied",
    reimbResolverId: principal.id
  }
  const response = await fetch(`${apiUrl}/reimbursements/?id=${data.reimbId}&reimbStatus=${data.reimbStatus}&reimbResolverId=${data.reimbResolverId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });
  location.reload();
  return response.json(); // parses JSON response into native JavaScript objects
}