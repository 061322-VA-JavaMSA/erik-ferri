let pendingReqsList = document.getElementById("pending-reqs");

async function getPendingReqs() {
  let response = await fetch(`${apiUrl}/reimbursements`);

  if(response.status == 200) {
    let data = await response.json();

    for (reimbReq in data) {
      let pendingReqItem = document.createElement('li');
      pendingReqItem.classList.add("list-group-item");
      pendingReqItem.innerHTML = `<span class="check icon-span"><i class="fas fa-check-square"></i></span><span class="trash icon-span"><i class="fas fa-trash-alt"></i></span>${data[reimbReq].reimbType} - $${data[reimbReq].reimbAmount}: ${data[reimbReq].reimbDescription}           - <span class="submitted-by">Submitted by ${data[reimbReq].userId}</span>`;
      pendingReqsList.appendChild(pendingReqItem);
    }
  } else {
    console.log('Unable to retrieve users.')
  }
}

getPendingReqs();