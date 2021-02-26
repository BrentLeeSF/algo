

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


const subArraySum = (nums, k) => {
  const results = [];
  for (let start = 0; start < nums.length; start++) {
    let sum = 0;
    for (let end = start; end <= nums.length; end++) {
      sum += nums[end];
      if (sum === k) {
        results.push(nums.slice(start, end + 1));
      }
    }
  }
  return results;
}

let summArray = [4, 2, -3, -1, 0, 4];
console.log();
console.log(subArraySum(summArray, 0));
let secondArr = [6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7];
console.log();
console.log(subArraySum(secondArr, 0));



