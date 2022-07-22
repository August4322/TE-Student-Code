const todoList = document.getElementById("todos");

let todos = [];
let pageTitle = "";

function init() {
    pageTitle = "My Morning Routine";
    todos = [
        {id: 1, task: "Wake Up", completed: false},
        {id: 2, task: "Brush Teeth", completed: false},
        {id: 3, task: "Shower", completed: false},
        {id: 4, task: "Get Dressed", completed: false},
        {id: 5, task: "Drive To Work", completed: false},
        {id: 6, task: "Work", completed: false},
        {id: 7, task: "Drive Home From Work", completed: false},
        {id: 8, task: "Dinner", completed: false},
        {id: 9, task: "Brush Teeth", completed: false},
        {id: 10, task: "Go To Bed", completed: false}
    ]
}

function addPageTitle() {
    const heading = document.createElement("h1")
    heading.innerText = pageTitle;
    todoList.appendChild(heading);
}

function addTodos() {
    const ul = document.createElement("ul");
    todoList.appendChild(ul);

    todos.forEach((todo) => {
        const li = document.createElement("li")
        li.innerText = todo.task
        ul.appendChild(li);
    });
}

init();
addPageTitle();
addTodos();