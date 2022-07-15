let pendingReqsList = document.getElementById("pending-reqs");

async function getPendingReqs() {
  let response = await fetch(`${apiUrl}/reimbursements/pending`);

  if(response.status == 200) {
    let data = await response.json();

    for (reimbReq in data) {
      let pendingReqItem = document.createElement('li');
      pendingReqItem.classList.add("list-group-item");
      pendingReqItem.innerHTML = `<span class="check icon-span" onclick="approve(${data[reimbReq].id})"><i class="fas fa-check-square"></i></span><span class="trash icon-span" onclick="deny(${data[reimbReq].id})"><i class="fas fa-trash-alt"></i></span>${data[reimbReq].reimbType} - $${data[reimbReq].reimbAmount}: ${data[reimbReq].reimbDescription}           - <span class="submitted-by">Submitted by ${data[reimbReq].reimbAuthor}</span>`;
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
    reimbResolver: principal.username
  }
  const response = await fetch(`${apiUrl}/reimbursements/?id=${data.reimbId}&reimbStatus=${data.reimbStatus}&reimbResolver=${data.reimbResolver}`, {
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
    reimbResolver: principal.username
  }
  const response = await fetch(`${apiUrl}/reimbursements/?id=${data.reimbId}&reimbStatus=${data.reimbStatus}&reimbResolver=${data.reimbResolver}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });
  location.reload();
  return response.json(); // parses JSON response into native JavaScript objects
}