// concat returns a new array
const concat1 = ['a', 'b', 'c'];
const concat2 = ['d', 'e', 'f'];
const concat3 = concat1.concat(concat2);
// expected output: Array ["a", "b", "c", "d", "e", "f"]
console.log(concat3);

/* The fill() method changes all elements in an array to a static value, 
from a start index (default 0) to an end index (default array.length). 
It returns the modified array. */
const fill1 = [1, 2, 3, 4];
// expected output: [6, 6, 6, 6]
console.log(fill1.fill(6));


const poppy = ['broccoli', 'cauliflower', 'cabbage', 'kale', 'tomato'];
poppy.pop();
console.log(poppy);
// expected output: "tomato"

const pushy = ['pigs', 'goats', 'sheep'];
pushy.push('cows');
console.log(pushy);
// expected output: 4

/* The reduce() method executes a reducer function (that you provide) 
on each element of the array, resulting in single output value. */
const reducer1 = [1, 2, 3, 4];
const reducer = (accumulator, currentValue) => accumulator * currentValue;
// 1 * 2 * 3 * 4 = 24
console.log(reducer1.reduce(reducer));

// shift removes first element in array
const shifty1 = [1, 2, 3];
const firstElement = shifty1.shift();
console.log(shifty1);
// expected output: Array [2, 3]

/* slice() method returns a shallow copy of a portion of an array into a new 
array object selected from start to end (end not included) where start and 
end represent the index of items in that array. 
The original array will not be modified. */
const slice1 = ['ant', 'bison', 'camel', 'duck', 'elephant'];
console.log(slice1.slice(2));
// expected output: Array ["camel", "duck", "elephant"]
console.log(slice1.slice(2, 4));
// expected output: Array ["camel", "duck"]
console.log(slice1.slice(1, 5));
// expected output: Array ["bison", "camel", "duck", "elephant"]

/* splice() method changes the contents of an array by removing or replacing 
existing elements and/or adding new elements in place. */
const splice1 = ['Jan', 'March', 'April', 'June'];
splice1.splice(1, 0, 'Feb');
// inserts at index 1
console.log(splice1);
// expected output: Array ["Jan", "Feb", "March", "April", "June"]
splice1.splice(4, 1, 'May');
// replaces 1 element at index 4
console.log(splice1);
// expected output: Array ["Jan", "Feb", "March", "April", "May"]

