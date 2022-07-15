console.log("user = " + principal.id);
let userId = principal.id;
let resolvedReqsList = document.getElementById("resolved-reqs");

async function getResolvedReqs() {
  let response = await fetch(`${apiUrl}/reimbursements/resolved`);

  if(response.status == 200) {
    let data = await response.json();

    for (reimbReq in data) {
      let resolvedReqItem = document.createElement('li');
      resolvedReqItem.innerHTML = `${data[reimbReq].reimbType} - resolved by ${data[reimbReq].reimbResolverId}`;
      resolvedReqsList.appendChild(resolvedReqItem);
    }
  } else {
    console.log('Unable to retrieve requests.')
  }
}

getResolvedReqs();
