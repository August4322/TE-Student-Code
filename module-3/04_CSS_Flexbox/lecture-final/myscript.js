function changeStyles() {
    const allMyDivs = document.querySelectorAll("div");
    allMyDivs.forEach( 
        (x) => { 
            x.classList.add("largerBox"); 
        }
    );
}