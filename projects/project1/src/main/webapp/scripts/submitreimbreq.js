console.log("user: " + principal.username);

// Setting up event listener for submit button
let submitButton = document.getElementById('submit-btn');
submitButton.addEventListener('click', submitReimbReq);

async function submitReimbReq() {

  let reimbType = document.getElementById('reimb-type').value;
  let reimbAmount = document.getElementById('reimb-amount').value;
  let reimbDescription = document.getElementById('reimb-description').value;

  const data = {
    reimbType: reimbType,
    reimbStatus: "pending",
    reimbAmount: reimbAmount,
    reimbDescription: reimbDescription,
    userId: principal.id
  };

  console.log(data);

  let response = await fetch(`${apiUrl}/reimbursements`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data)
  })
  return response.json();
}