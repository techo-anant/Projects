// fetch("https://pokeapi.co/api/v2/pokemon/pikachu")
//     .then(response => {

//         if(!response.ok){
//             throw new Error("Could not fetch resource");
//         }
//         return response.json();
//     })
//     .then(data => console.log(data.))
//     .catch(error => console.error(error));


async function fetchdata() {
    try{

        const pokemonName = document.querySelector("#pokemonname").value.toLowerCase();

        const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`);
        const notFound = document.querySelector("#wrongName");
        const imgElement = document.getElementById("pokemonSprite");
        if(!response.ok){
            notFound.style.display = "block";
            imgElement.style.display = "none";
            throw new Error("could not fetch resourse")
        }else{
            notFound.style.display = "none";
            const data = await response.json();
            console.log(data);
            const pokemonSprite = data.sprites.front_default;
            const pokeInfo = document.querySelector(".info");
            const info = data.types;

            pokeInfo.innerHTML = `<h3>Type: ${info.map(ele => ele.type.name.charAt(0).toUpperCase()+ele.type.name.substring(1,)).join(", ")} </h3>`;

            imgElement.src = pokemonSprite;
            imgElement.style.display = "block";
        }
    }catch(error){
        console.error(error);
    }
}