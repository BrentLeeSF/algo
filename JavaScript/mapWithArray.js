/* ITERATE THROUGH MAP: https://hackinbits.com/articles/how-to-iterate-a-map-in-javascript---map-part-2
MAP WITH OBJECT: https://stackoverflow.com/questions/51131176/map-single-key-multiple-values-using-new-map-javascript
MAP FUNCTIONS https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map 

The join() method creates and returns a new string by concatenating all of the elements in an array */

let anagrams = ["CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE", "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG", "SUED", "LEAN", "SCAR", "DESIGN"];
console.log("anagrams = ",anagrams);
console.log();

function arrangeAnnagrams(anagrams) {

	let map = new Map();

	for(let i = 0; i < anagrams.length; i++) {

		let arr = anagrams[i];
		// sort string
		let sortString = function(arr) {
    		return arr.split('').sort().join('');
		};
		arr = sortString(arr);

		if(!map.has(arr)) {
			map.set(arr, [anagrams[i]]);

		} else {
			map.set(arr, [anagrams[i], ...map.get(arr)]);
		}
	}

	for(let [key, value] of map) {
		console.log(key," = ",value);
	}
}

arrangeAnnagrams(anagrams);



/**
 * Return the user ids of the users that go in the order "A,B,C"
 */

func = (arr) => {
  let map = new Map();
  let newArr;

  for(let i = 0; i < arr.length; i++) {

    if(!map.has(arr[i].userId)) {
      map.set(arr[i].userId, [arr[i].action]);

    } else {
      map.set(arr[i].userId, [arr[i].action, ...map.get(arr[i].userId)]);
    }
  }

  let alpha = ['A','B','C'];
  let returnArr = [];
  add = true;

  for (let [key, value] of map) {
    for(let j = 0; j < alpha.length; j++) {

      if(alpha[j] !== value[value.length-1-j]) {
        add = false;
      }
    }
    if(add) {
      returnArr.push(key);
    }
    add = true;
  }
  return returnArr;
}

let firstArr = [
  {userId: 1, action: 'A'}, {userId: 1, action: 'B'},{userId: 2, action: 'A'},
  {userId: 2, action: 'B'}, {userId: 2, action: 'C'},{userId: 1, action: 'B'},
  {userId: 3, action: 'A'}, {userId: 4, action: 'B'},{userId: 3, action: 'B'},
  {userId: 4, action: 'B'}, {userId: 3, action: 'C'},{userId: 4, action: 'B'},
  ];
console.log();
console.log("original array = ",firstArr)
console.log(func(firstArr));


/* Given a non-empty array of non-negative integers nums, the degree of 
this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray 
of nums, that has the same degree as nums.*/
/* Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6. */
const findShortestSubArray = function(nums) {

    let map = new Map();
    let diff = 0, thisMin = 0, maxLength = 0;

    for(let i = 0; i < nums.length; i++) {
        if(map.has(nums[i])) {
            map.set(nums[i], [...map.get(nums[i]), i]);
        } else {
            map.set(nums[i],[i]);
        }
    }

    for(let [key, value] of map) {
        if(value.length === maxLength) {
            diff = 1 + value[value.length-1] - value[0];
            if(thisMin === 0) {
                thisMin = diff;
            } else {
                thisMin = Math.min(diff, thisMin);
            }

        } else if ( value.length > maxLength ) {
            maxLength = value.length;
            thisMin = 1 + value[value.length-1] - value[0];
        }
    }
    return thisMin;
};


console.log(findShortestSubArray(
[1,2,2,3,1]));
console.log(findShortestSubArray([1,2,2,3,1,4,2]));



const exampleTasks = [
  {task: "buy groceries", depends: ["get groceries for sandwich"]},
  {task: "make sandwich", depends: ["go inside with groceries"]},
  {task: "drive back home with groceries", depends: ["buy groceries"]},
  {task: "get groceries for sandwich", depends: ["arrive at the store"]},
  {task: "go inside with groceries", depends: ["drive back home with groceries"]},
  {task :"drive to the store", depends: ["get into the car to drive to the store"]},
  {task: "arrive at the store", depends: ["drive to the store"]},
  {task: "eat sandwich", depends: ["make sandwich"]},
  {task: "get into the car to drive to the store", depends: []}
];


determineOrder = (arr, givenString) => {

  let newArr = [];
  let map = new Map();
  let start = [];
  givenArrayIndex = 0;

  if(givenString.length === 0 || arr.length === 0) return ['The array is empty'];
  if(givenString.length > arr.length) return ['The array is too big'];

  for(let i = 0; i < arr.length; i++) {
    map.set(arr[i].depends, [arr[i].task.toString()]);
    if(givenString[givenArrayIndex] === arr[i].task) start = [arr[i].task.toString()]; 
  }

  if(start.length > 0) {
    while(newArr.length < givenString.length) {
      for(let [key, value] of map) {
        if(givenString[givenArrayIndex] === key[0]) {
          if(newArr[newArr.length-1] !== key[0]) newArr.push(key[0]);
          start[0] = value[0];
          givenArrayIndex++;
        }
        if(givenString[givenArrayIndex] !== start[0]) {
          return ['Sorry, those elements are not in the array of objects'];
        }
      }
      newArr.push(start[0]);
    }
  }
  return newArr.length === givenString.length ? newArr : ['Sorry, those elements are not in the array of objects'];
}

console.log(determineOrder(exampleTasks, ['get into the car to drive to the store', 'drive to the store', 'arrive at the store', 'get groceries for sandwich', 'buy groceries', 'drive back home with groceries', 'go inside with groceries', 'make sandwich', 'eat sandwich']));
console.log(determineOrder(exampleTasks, ['get into the car to drive to the store', 'drive to the store', 'arrive at the store', 'get groceries for sandwich', 'buy groceries', 'drive back home with groceries', 'go inside with groceries', 'make sandwich', 'eat sandwich', 'get into the car to drive to the store']));
console.log(determineOrder(exampleTasks, []));
console.log(determineOrder(exampleTasks, ['get into the car to drive to the store', 'drive to the store', 'arrive at the store', 'get groceries for sandwich', 'buy groceries', 'drive back home with groceries', 'go inside with groceries', 'eat sandwich']));
console.log(determineOrder(exampleTasks, ['get into the car to drive to the store', 'drive to * the store', 'arrive at the store']));
console.log(determineOrder(exampleTasks, ['get into the car to drive to the store', 'drive to the store', 'eat sandwich']));
console.log(determineOrder(exampleTasks, ['get into the car to drive to the store', 'drive to the store', '']));

