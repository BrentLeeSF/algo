/**
STRING FUNCTIONS TO KNOW
str.charAt()
str.concat()
str.includes()
str.match() - retrieves the result of matching a string against a regex.
str.replace('dog', 'monkey') - replaces dog with monkey

str.slice() - extracts a section of a string and returns it as a new string, without modifying the original string
const str = 'The quick brown fox jumps over the lazy dog.';
console.log(str.slice(31));
// Expected output: "the lazy dog."
console.log(str.slice(4, 19));
// Expected output: "quick brown fox"
console.log(str.slice(-4));
// Expected output: "dog."
console.log(str.slice(-9, -5));
// Expected output: "lazy"



*/
//str.split() - takes a pattern and divides a String into an ordered list of substrings by searching for the pattern, puts these substrings into an array, and returns the array
str = 'The big lazy dog';
console.log('Split = ',str.split(' ')); // array of all words
console.log('Split = ',str.split()); // array of one word

console.log('Substring - ',str.substring(4,7)); // big - (beginning index, ending index)

/* Remove All Adjacent Duplicates In String
Input: "abbacacc" remove "bb" -> "aacacc"
"aacacc" remove "aa" -> "cacc"
"cacc" remove "cc" -> "ca"
return "ca"*/
removeDuplicates = (S) => {

    let stringArray = S.split("");

    for (let i = 0; i < stringArray.length; i++) {

        if (stringArray[i] === stringArray[i + 1]) {

            stringArray.splice(i, 2);
            i = -1;
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



/* https://www.techiedelight.com/rearrange-the-array-with-alternate-high-and-low-elements/ 
Given an integer array, rearrange it such that every second element becomes greater than its left and right elements.
No duplicates */
secondNumberIsGreater = arr => {
    const sortedArray = arr.sort();
    let returnedArr = [];
    for (let i = 0; i < sortedArray.length; i++) {
        if (i !== 0 && i%2 !== 0 && sortedArray[i+1]) {
            let numToSwitch = sortedArray[i];
            returnedArr.push(sortedArray[i+1]);
            sortedArray[i+1] = numToSwitch;
        }
        else {
            returnedArr.push(sortedArray[i]);
        }
    }
    return returnedArr;
}

let secondNumGreater = [1, 5, 3, 4, 0, 6, 7, 2, 8, 10, 9];
console.log("original array = ",secondNumGreater);
console.log("Return every other element is largest from immediate left to immediate right = ",secondNumberIsGreater(secondNumGreater));



// Square numbers in n
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

const squares = 81;
numSquaresOne(squares);



function reverseNum(x) {
    const str = x.toString();
    let i = str.length;
    let hey = '';
    let reversed = '';
    if (str.charAt(0) === '-') {
        i = str.length-1;
        hey += '-';
        reversed = str.split("").slice(1,str.length).reverse().join("");
    }
    else {
        reversed = str.split("").reverse().join("");
    }
    while (reversed.charAt(i) === '0' && i > 0) {
        i--;
    }
    for(let j = 0; j < i; j++) {
        hey += reversed.charAt(j);
    }
    return Number(hey);
};

const firstNum = 123;
const secondNum = -123;
const thirdNum = 120;
console.log('Reverse of ',firstNum,' = ',reverseNum(firstNum));
//console.log();
console.log('Reverse of ',secondNum,' = ',reverseNum(secondNum));
//console.log();
console.log('Reverse of ',thirdNum,' = ',reverseNum(thirdNum));
//console.log();

/* https://algodaily.com/challenges/sum-of-perfect-squares 
find perfect squares like 1, (2) 4, (3) 9, (4) 16, (5) 25, etc*/
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


