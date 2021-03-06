/* Remove All Adjacent Duplicates In String
Input: "abbacacc" remove "bb" -> "aacacc"
"aacacc" remove "aa" -> "cacc"
"cacc" remove "cc" -> "ca"
return "ca"*/
removeDuplicates = (S) => {

    let stringArray = S.split("");
    console.log("S = ",S," string array = ",stringArray);

    for (let i = 0; i < stringArray.length; i++) {

        if (stringArray[i] === stringArray[i + 1]) {

            stringArray.splice(i, 2);
            i = -1;
            continue;
        }
    }
    return stringArray.join("");
};

let originalString = "abbacacc";
console.log("Original String = ",originalString,", result of removing adjacent duplicates = ",removeDuplicates(originalString));
console.log();



const findEvenNumberLength = function(nums) {
    let even = 0;
    for(let num of nums) {
        if(num.toString().length%2 === 0) {
            even++;
        }
    }
    return even;
};
let evenNums = [1,2,34,567,890,4321,4,32,5678];
console.log("Return count of even numbers in ",evenNums, " = ",findEvenNumberLength(evenNums));
console.log();



/* https://www.techiedelight.com/rearrange-the-array-with-alternate-high-and-low-elements/ */
secondNumberIsGreater = arr => {

    let currentGreatest = 0, greatest = 0;
    arr = arr.toString().split(",");
    let returnedArr = [];

    for(let i = 0; i < arr.length; i++) {

        if(i%2 != 0 && i < arr.length-1) {

            currentGreatest = Math.max(parseInt(arr[i-1]), parseInt(arr[i+1]));
            greatest = parseInt(arr[i]) > currentGreatest ? parseInt(arr[i]) : ++currentGreatest;
            returnedArr.push(greatest);

        } else {
            returnedArr.push(parseInt(arr[i]));
        }
    }
    return returnedArr;
}

let secondNumGreater = ["1, 5, 3, 4, 5, 6, 7, 8, 9"];
console.log("original array = ",secondNumGreater);
console.log("Return every other element is largest from immediate left to immediate right = ",secondNumberIsGreater(secondNumGreater));



function numSquaresOne(n) {

    let map = new Map();

    for(let i = 1; i*i <= n; i++) {
        map.set(i,i*i);
    }

    console.log("\nsquares from 1 to ",n);

    for (let [key, value] of map) {
        console.log(key + ' = ' + value)
    }

    console.log();
}

const squares = 100;
numSquaresOne(squares);



/* https://algodaily.com/challenges/sum-of-perfect-squares */
function howManySquares(n) {

    let perfectSqNumsLength = 1;

    while (perfectSqNumsLength * perfectSqNumsLength < n) {
        perfectSqNumsLength++;
    }

    if (perfectSqNumsLength * perfectSqNumsLength > n) {
        perfectSqNumsLength--;
    }

    const perfectSqNums = [];

    // Fill the array backwards so we get the numbers to work with
    for (let i = perfectSqNumsLength - 1; i >= 0; i--) {
        perfectSqNums[perfectSqNumsLength - i - 1] = (i + 1) * (i + 1);
    }

    // instantiate a hashmap of possible paths
    const paths = {};
    paths[1] = 1; // 1 = 1
    paths[0] = 0; // 0 means you need 0 numbers to get 0

    return numSquares(paths, perfectSqNums, n);
}


function numSquares(paths, perfectSqNums, n) {

    if (paths.hasOwnProperty(n)) {
        // we already knew the paths to add up to n.
        return paths[n];
    }

    let min = Number.MAX_SAFE_INTEGER;
    let thisPath = 0;

    for (let i = 0; i < perfectSqNums.length; i++) {

        if (n - perfectSqNums[i] >= 0) {

            const difference = n - perfectSqNums[i];
            // this is key - recursively solve for the next perfect square
            // that could sum to n by traversing a graph of possible perfect square sums
            thisPath = numSquares(paths, perfectSqNums, difference);

            // compare the number of nodes required in this path
            // to the current minimum
            min = Math.min(min, thisPath);
        }
    }

    min++; // increment the number of nodes seen
    paths[n] = min; // set the difference for this number to be the min so far

    return min;
}

let countSquares = 104;
console.log("How many squares are in ",countSquares," = ",howManySquares(countSquares));


/*Find kth largest element in array https://leetcode.com/problems/kth-largest-element-in-an-array/
Find the kth largest element in an unsorted array. Note that it is the kth 
largest element in the sorted order, not the kth distinct element.
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4 */
const findKthLargest = function(nums, k) {
    
    nums.sort(function(a, b) {
        return a - b;
    });
    
    for(let i = 0; i < nums.length; i++) {
        k--;
        if(k === 0) {
            return nums[nums.length-1-i];
        }
    }
    return -1;
};


console.log(findKthLargest([3,2,3,1,2,4,5,5,6],4));


