/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(param1, param2) {

    console.log("Param 1: " + param1);
    console.log("Param 2: " + param2);

    return param1 * param2;

}



/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
function multiplyTogetherWithDefaults(param1=0, param2=0) {

  console.log("Param 1: " + param1);
  console.log("Param 2: " + param2);

  return param1 * param2;

}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

/**
 * 
 * @param {string} name name of the person
 * @param {number} age age of the person
 * @param {array} listOfQuirks 
 * @param {string} separator 
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

/*
// Named functions are what we have seen before
function printName(name) {
  console.log(name);
}

//Same thing as above, but now anonymous (no name)
(name) => {
  console.log(name);
}
*/
function forEachExample() {

  const myArray = [1,2,3,4,5];

  
  myArray.forEach((num) => {
    console.log(num);
  });

  /*
  for(let num of myArray) {
    console.log(num);
  } */
 
 //myArray.forEach(printNum);

}

function printNum(num) {
  console.log(num);
}

function mapExample() {

  const myArray = [1,2,3,4,5];

  const myNewArray = myArray.map(
    (x) => {
      return x*2;
    }
  );

  console.log(myNewArray);

  const myPersonList = [
    {firstName: "Christopher", middleName: "Frank", lastName: "Guarnera"},
    {firstName: "Ben", middleName: "Frank", lastName: "Guarnera"},
    {firstName: "Morbius", middleName: "Frank", lastName: "Guarnera"},
    {firstName: "Matthew", middleName: "Frank", lastName: "Guarnera"}
  ];

  console.log(myPersonList);

  const names = myPersonList.map(
    (x) => {
      return x.firstName + " " + x.middleName + " " + x.lastName;
    }
  );

  console.log(names);

  const splitOutNames = names.map(
    (name) => {
      const splitOutName = name.split(" ");
      return {
        firstName: splitOutName[0],
        middleName: splitOutName[1],
        lastName: splitOutName[2]
      };
    }
  );

  console.log(splitOutNames);

}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
//const numbersToSum = [1,2,3,4,5,6,7,8,9,10];

function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce(
    (sum, currentVal) => {
      return sum + currentVal;
    }
  );
}

function reduceNames() {
  const myPersonList = [
    {firstName: "Christopher", middleName: "Frank", lastName: "Guarnera"},
    {firstName: "Ben", middleName: "Frank", lastName: "Guarnera"},
    {firstName: "Morbius", middleName: "Frank", lastName: "Guarnera"},
    {firstName: "Matthew", middleName: "Frank", lastName: "Guarnera"}
  ];

  return myPersonList.reduce(
      (reducer, currentVal) => {

        let namesSoFar = "";
        if(reducer.firstName) {
          namesSoFar = reducer.firstName;
        } else {
          namesSoFar = reducer;
        }

        return namesSoFar + ", " + currentVal.firstName;
      }
  );
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter(
    (x) => {
      return x % 3 === 0; // we return the condition we want to test
    }
  );
}

function filterNames(){
  const myPersonList = [
    {firstName: "Christopher", middleName: "Frank", lastName: "Guarnera"},
    {firstName: "Ben", middleName: "Frank", lastName: "Guarnera"},
    {firstName: "Morbius", middleName: "Frank", lastName: "Guarnera"},
    {firstName: "Matthew", middleName: "Frank", lastName: "Guarnera"}
  ];

  return myPersonList.filter(
    (x) => {return x.firstName.startsWith("M");}
  );
}
