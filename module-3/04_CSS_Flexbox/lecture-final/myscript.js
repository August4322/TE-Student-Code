function changeStyles() {

    const div1 = document.getElementById("div1");
    div1.addEventListener('mouseover', () => {
        alert('Hello World');
    });

    const allMyDivs = document.querySelectorAll("div");
    allMyDivs.forEach( 
        (x) => { 
            x.classList.add("largerBox"); 
        }
    );
}


document.addEventListener('DOMContentLoaded', () => {


    const myButton = document.querySelector("button");
    myButton.addEventListener('click', (x) => {
        changeStyles();
    });

    

    const textInput = document.getElementById("textInput");
    textInput.addEventListener('change', () => {
        console.log('Its Morbin Time');
    })

});



