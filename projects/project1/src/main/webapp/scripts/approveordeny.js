let pendingReqsList = document.getElementById("pending-reqs");

async function getPendingReqs() {
  let response = await fetch(`${apiUrl}/reimbursements`);

  if(response.status == 200) {
    let data = await response.json();

    for (reimbReq in data) {
      let pendingReqItem = document.createElement('li');
      pendingReqItem.classList.add("list-group-item");
      pendingReqItem.innerHTML = `<span class="check icon-span" onclick="approve(${data[reimbReq].id})"><i class="fas fa-check-square"></i></span><span class="trash icon-span"><i class="fas fa-trash-alt"></i></span>${data[reimbReq].reimbType} - $${data[reimbReq].reimbAmount}: ${data[reimbReq].reimbDescription}           - <span class="submitted-by">Submitted by ${data[reimbReq].userId}</span>`;
      pendingReqsList.appendChild(pendingReqItem);
    }
  } else {
    console.log('Unable to retrieve users.')
  }
}

getPendingReqs();

// async function approve(id) {

// // Simple PUT request with a JSON body using fetch
// const element = document.querySelector('#put-request .date-updated');
// const requestOptions = {
//     method: 'PUT',
//     headers: { 'Content-Type': 'application/json' },
//     body: JSON.stringify({ title: 'Fetch PUT Request Example' })
// };
// fetch('https://reqres.in/api/articles/1', requestOptions)
//     .then(response => response.json())
//     .then(data => element.innerHTML = data.updatedAt );
// }

async function approve(id) {
  const data = {
    reimbId: id,
    reimbStatus: "approved"
  }
  // Default options are marked with *
  const response = await fetch(`${apiUrl}/reimbursements/${id}`, {
    method: 'PUT', // *GET, POST, PUT, DELETE, etc.
    // mode: 'cors', // no-cors, *cors, same-origin
    // cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    // credentials: 'same-origin', // include, *same-origin, omit
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    // redirect: 'follow', // manual, *follow, error
    // referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });
  return response.json(); // parses JSON response into native JavaScript objects
}