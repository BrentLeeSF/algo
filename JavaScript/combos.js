
/*Return sub arrays of given size */
const combinationOfGivenArray = function(originalArray, sizeLimit) {
     let currentArray = [];
     let finalResults = [];
     combineHelper(originalArray, sizeLimit, 0, currentArray, finalResults);
     return finalResults;
 };

const combineHelper = function(originalArray, sizeLimit, start, currentArray, finalResults) {
     if (sizeLimit === 0) {
         finalResults.push(currentArray.slice());
         return finalResults;
     }

     for (let i = start; i < originalArray.length; i++) {
         currentArray.push(originalArray[i]);
         combineHelper(originalArray, sizeLimit - 1, i + 1, currentArray, finalResults);
         currentArray.pop(originalArray[i]);
     }
 };
let originalComboArray = [1,2,3,4,5];
let comboSize = 2;
console.log("original array = ",originalComboArray, ", size = ",comboSize);
console.log(combinationOfGivenArray(originalComboArray,comboSize));


/* Triple Sub arrays that equal value */
returnTriplets = (arr, sum) => {

    arr.sort(function(a, b) {
        return a - b;
    });

    let finalResults = [];

    for(let i = 0; i < arr.length-2; i++) {

        let k = sum-arr[i];
        let low = i+1;
        let high = arr.length-1;

        while (low < high) {

            if (arr[low] + arr[high] < k) {
                low++;
            }
            else if (arr[low] + arr[high] > k) {
                high--;
            }
   
            // triplet with the given sum is found
            else {
                let newArr = [arr[i], arr[low], arr[high]];
                finalResults.push(newArr);
                low++;
                high--;
            }
        }
    }
    return finalResults;
}

let tripletArray = [2, 7, 4, 0, 9, 5, 1, 3,9,-3 ];
let tripletNum = 6;
console.log("Returned triplets that = ",tripletNum," = ",returnTriplets(tripletArray, tripletNum));


/* Return sub arrays that equal given number */
const subArraySum = (nums, k) => {

    const results = [];
    for(let start = 0; start < nums.length; start++) {

        let sum = 0;
        for(let end = start; end <= nums.length; end++) {

            sum += nums[end];
            if(sum === k) {
                results.push(nums.slice(start, end + 1));
            }
        }
    }
  return results;
}

let summArray = [4, 2, -3, -1, 0, 4];
console.log();
let subArrayTotalOne = 0;
console.log("Subarrays that add to ",subArrayTotalOne," = ",subArraySum(summArray, subArrayTotalOne));
let secondArr = [6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7];
console.log();
console.log("Subarrays that add to ",subArrayTotalOne," = ",subArraySum(secondArr, subArrayTotalOne));
let summArrayTwo = [0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10, -4];
let subArraySumTotal = -3;
console.log();
console.log("Sub arrays that = ",subArraySumTotal," = ",subArraySum(summArrayTwo, subArraySumTotal));



