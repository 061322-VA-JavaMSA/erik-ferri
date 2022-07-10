let welcomeH1 = document.getElementById('welcome');

// Different welcome message based on logged in user retrieved from session storage
if(principal){
  welcomeH1.innerHTML = `Welcome to the employee portal, ${principal.username}!`
} else{
  welcomeH1.innerHTML = `Employee Reimbursement System`
}

// Setting up event listener for submit button
let submitButton = document.getElementById('submit-btn');
submitButton.addEventListener('click', submitReimbursement);

async function submitReimbursement(){

  let reimbType = document.getElementById('reimb-data').value;

  const data = {
    reimbType: reimbType,
  };

  fetch(`${apiUrl}/reimbursements`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
  .then(response => response.json())
  .then(data => {
    console.log('Success:', data);
  })
  .catch((error) => {
    console.error('Error:', error);
  });

  login(username,password);

  // if(response.status == 200){
  //     let data = await response.json();

  //     /*
  //         persisting the User object sent back to session storage for use in other pages
  //         Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
  //      */
  //      sessionStorage.setItem('principal', JSON.stringify(data));
  //     // redirect to the homepage on success
  //     window.location.href="./index.html";
  // } else{
  //     console.log('Unable to login.')
  // }
  }