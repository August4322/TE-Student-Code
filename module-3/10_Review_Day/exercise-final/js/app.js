const cards = [
    {
        img: "imgs/casio_watch.jpg",
        title: "Casio Watch",
        caption: "It's Morbin' Time"
    },
    {
        img: "imgs/morbin_time_mug.webp",
        title: "Morbin' Mug",
        caption: "Bring Me To Life"
    },
    {
        img: "imgs/vulture.jpg",
        title: "Morbin' Friend",
        caption: "We Should Team Up"
    },
    {
        img: "imgs/inconspicuous_outfit.webp",
        title: "Inconspicuous Outfit",
        caption: "I Put The Morb In Morbius"
    }   
];

const badReview = {
    img: "imgs/rotten.jfif",
    title: "Bad Review",
    caption: "Morbtastic"
}

const difficultyLevel = 4;

let clickedCards = [];

document.addEventListener('DOMContentLoaded', () => {

    
   const startBtn = document.getElementById("btnStartOver");
   startBtn.addEventListener('click', () => {
    startGame();
   });

});

function clearGame() {
    const main = document.querySelector('main');
    main.innerHTML= "";
}

function startGame() {
    const main = document.querySelector('main');
    clearGame();


    let deck = cards.concat(cards);

    for(let i =0; i < difficultyLevel; i++){
        deck.push(badReview);
    }

    deck = deck.sort((a,b) => {
        //we can randomly shuffle the array
        return (Math.random() > .5) ? 1 : -1;
    });

    deck.forEach((x) => {
        const card = createCard(x);
        main.appendChild(card);

        card.addEventListener('click', (event) => {

            onCardClick(event);
        })
    
    });

    
}

function onCardClick(event) {
   

    //get the card that was clicked on
    const clickedCardContainer = event.target;
    const clickedCard = clickedCardContainer.querySelector(".card");

    //remove the face down class
    clickedCard.classList.remove("faceDown");
    clickedCards.push(clickedCard);

    if(clickedCards.length >= 2) {


        setTimeout(() => {
           
            checkIfMatch();

        }, 2500);


        
    }
}

function checkIfMatch() {
    const title1 = clickedCards[0].querySelector(".title").innerText;
    const title2 = clickedCards[1].querySelector(".title").innerText;

    if(title1 === title2) {

        if(title1 === "Bad Review") {
            
            alert("Game Over!");
            clearGame();

        } else {
            alert("Match found!");
            checkIfGameWon();

        }
    } else {
        clickedCards[0].classList.add("faceDown");
        clickedCards[1].classList.add("faceDown");
        
    }

    // start a new round of selecting two cards
    clickedCards = [];
}

function checkIfGameWon() {

    const cardsDown = document.querySelectorAll(".faceDown");
    if( cardsDown.length === difficultyLevel) {
        alert("You Won!");

        clearGame();

        const main = document.querySelector("main");
        
        const img = document.createElement("img");
        img.src = "imgs/morbius-sense.gif";
        main.appendChild(img);

        const h1 = document.querySelector("h1");
        h1.innerText = "YOU MORBIN' DID IT!";
        main.append(h1);

    }

}


function createCard(cardDetails) {

    const cardContainer = document.createElement("div");
    cardContainer.setAttribute("class", "cardContainer");
    
    const card = document.createElement("div");
    card.setAttribute('class', 'card');
    card.classList.add('faceDown');
    cardContainer.appendChild(card);

    const cardTitle = document.createElement("h3");
    cardTitle.classList.add("title");
    cardTitle.classList.add("extra-bold");
    cardTitle.innerText = cardDetails.title;
    card.appendChild(cardTitle);

    const cardImg = document.createElement("img");
    cardImg.src = cardDetails.img;
    cardImg.classList.add("cardImg");
    card.appendChild(cardImg);

    const caption = document.createElement("p");
    caption.classList.add("caption");
    caption.innerText =cardDetails.caption;
    card.appendChild(caption);

    return cardContainer;
}