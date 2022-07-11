let pendingReqsList = document.getElementById("pending-reqs");

let pendingReqs = fetch(`${apiUrl}/reimbursements`)
.then(response => response.json())
.then(data => {
  console.log('Success:', data);
  for (reimbReq in data) {
    let pendingReqItem = document.createElement('li');
    pendingReqItem.innerHTML = `${data[reimbReq].reimbType}`;
    pendingReqsList.appendChild(pendingReqItem);
  }
})
.catch((error) => {
  console.error('Error:', error);
});