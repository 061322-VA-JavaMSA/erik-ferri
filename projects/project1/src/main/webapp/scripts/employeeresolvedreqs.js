console.log("user = " + principal.id);
let userId = principal.id;
let resolvedReqsList = document.getElementById("resolved-reqs");

async function getResolvedReqs() {
  let response = await fetch(`${apiUrl}/reimbursements/resolved/${userId}`);

  if(response.status == 200) {
    let data = await response.json();

    for (reimbReq in data) {
      let resolvedReqItem = document.createElement('li');
      resolvedReqItem.classList.add("list-group-item");
      resolvedReqItem.innerHTML = `${data[reimbReq].reimbType} - $${data[reimbReq].reimbAmount}: ${data[reimbReq].reimbDescription} - ${data[reimbReq].reimbStatus}`;
      resolvedReqsList.appendChild(resolvedReqItem);
    }
  } else {
    console.log('Unable to retrieve requests.')
  }
}

getResolvedReqs();
