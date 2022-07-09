// Checks if a user is already logged in, if yes redirect to homepage
if(principal){
  window.location.href="./index.html";
}

// Setting up event listener for login button
let signUpButton = document.getElementById('submit-btn');
signUpButton.addEventListener('click', signUp);
let username;
let password;

async function signUp(){

  username = document.getElementById('username').value;
  password = document.getElementById('password').value;

  const data = {
      username: username,
      password: password
  };

  fetch(`${apiUrl}/users`, {
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

async function login(username, password){

  let response = await fetch(`${apiUrl}/auth`,{
      method: 'POST',
      credentials: 'include',
      headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
      },
      body: new URLSearchParams({
          'username': `${username}`,
          'password': `${password}`
      })
  });

  if(response.status == 200){
      let data = await response.json();

      /*
          persisting the User object sent back to session storage for use in other pages
          Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
       */
       sessionStorage.setItem('principal', JSON.stringify(data));
      // redirect to the homepage on success
      window.location.href="./index.html";
  } else{
      console.log('Unable to login.')
  }
}