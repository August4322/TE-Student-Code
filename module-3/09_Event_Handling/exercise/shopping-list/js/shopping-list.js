let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}



document.addEventListener('DOMContentLoaded', () => {
  setPageTitle();      
  displayGroceries();
  
  const selectItem = document.querySelectorAll("li");
  const selectCompleteAll = document.getElementById("toggleAll");

  selectItem.forEach((item) => {
    item.addEventListener('click', () => {
      if(!item.classList.contains("completed")) {
        item.classList.add("completed");
        item.querySelector("i").classList.add("completed");
      }
    });
    item.addEventListener('dblclick', () => {
      if (item.classList.contains("completed")) {
        item.classList.remove("completed");
        item.querySelector("i").classList.remove("completed")
      }
    })
  });

  selectCompleteAll.addEventListener('click', () => {
    if (allItemsIncomplete) {
      selectItem.forEach((item) => {
          allItemsIncomplete = false;
          item.classList.add("completed");
          item.querySelector("i").classList.add("completed");
          selectCompleteAll.innerText = "Mark All Incomplete";
        }
      )} else {
        selectItem.forEach((item) => {
          allItemsIncomplete = true;
          item.classList.remove("completed");
          item.querySelector("i").classList.remove("completed");
          selectCompleteAll.innerText = "Mark All Complete";
        })
      }
  })


})























/*

document.addEventListener('DOMContentLoaded', (event) => {
  setPageTitle();
  displayGroceries();

  function markCompleted() {}
  const groceryList = document.querySelectorAll("li")
  const groceryItems = Array.from(list.children)
  }
  
  groceryList.forEach((item) => {
    item.addEventListener('click', (event) => {
      if (allItemsIncomplete == false) {
        continue;
      } else if (allItemsIncomplete == true) {
        item.setAttribute('class', 'completed')
        item.querySelector('i').classList.add('completed')
      }
    });
    item.addEventListener('dblclick', (event) => {
      if (allItemsIncomplete == true) {
        continue;
      } else if (allItemsIncomplete == false) {
        item.removeAttribute('class', 'completed')
        item.querySelector('i').classList.remove('completed')
      }
    });
  });
})


*/