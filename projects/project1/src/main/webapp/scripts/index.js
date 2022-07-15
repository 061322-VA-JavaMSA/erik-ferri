let welcomeH1 = document.getElementById('welcome');
let goToPortal = document.getElementById('go-to-portal');

// Different welcome message based on logged in user retrieved from session storage
if(principal){
    welcomeH1.innerHTML = `Welcome back ${principal.username}!`
    if(principal.role == "BASIC_USER") {
        goToPortal.innerHTML = `<div class="col-12 d-flex justify-content-center">
        <a href="employeemain.html" class="btn btn-outline-secondary mt-5">Go to Employee Portal</a>
        </div>`
    } else {
        goToPortal.innerHTML = `<div class="col-12 d-flex justify-content-center">
        <a href="managermain.html" class="btn btn-outline-secondary mt-5">Go To Manager Portal</a>
        </div>`
    }
} else{
    welcomeH1.innerHTML = `Employee Reimbursement System`
}

