// document.getElementById('getData').onclick = getData;
document.getElementById('get-data').addEventListener("click", getData);

/*
    - When button is clicked, send http request to API for a specific id

    - get the id value from input box
    - send request to PokeAPI
        - Method: GET
        - Headers: None
        - Body: None
        - url: https://pokeapi.co/api/v2/pokemon/ + id from input box
    - might have to convert JSON to JS object

    - populate the data in Section
*/
let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

async function getData() {
    console.log('Button was clicked!');
    let id = document.getElementById('data-input').value;
    console.log(`id = ${id}`);

    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse.status >= 200 && httpResponse.status < 300){
    let data = await httpResponse.json();

    populateData(data);
    
    } else {
        console.log('Invalid request.');
    }
}

function populateData(response) {
    console.log(response);
    var pokemon = document.createElement('tr');
    pokemon.innerHTML = "<td>" + response.id + "</td><td>" + response.name.charAt(0).toUpperCase() + response.name.slice(1) + "</td><td><img src=" + response.sprites.front_default + "></td>" + "</td><td><img src=" + response.sprites.front_shiny + "></td>";
    document.getElementById('pokemon-table').appendChild(pokemon);
}