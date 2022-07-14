console.log("user = " + principal.id);
let userId = principal.id;
let pendingReqsList = document.getElementById("pending-reqs");

async function getPendingReqs() {
  let response = await fetch(`${apiUrl}/reimbursements/pending/${userId}`);

  if(response.status == 200) {
    let data = await response.json();

    for (reimbReq in data) {
      let pendingReqItem = document.createElement('li');
      pendingReqItem.innerHTML = `${data[reimbReq].reimbType}`;
      pendingReqsList.appendChild(pendingReqItem);
    }
  } else {
    console.log('Unable to retrieve requests.')
  }
}

getPendingReqs();
