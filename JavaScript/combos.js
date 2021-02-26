

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


/* ONLY WORKS WITH SIZE OF 2

combinationsOfGivenNumber = (comboArr, comboSize) => {
	let outterArray = [];
	let innerArray = [];
	for(let i = 0; i < comboArr.length-comboSize+1; i++) {
		for(let j = i+1; j < comboArr.length; j++) {
			if(!innerArray.length || innerArray.length === 0) {
				let innerArray = [];
				innerArray.push(comboArr[i]);
				innerArray.push(comboArr[j]);
				outterArray.push(innerArray);
			} else {
				innerArray = outterArray[i];
				outterArray.push(...innerArray, comboArr[i], comboArr[j]);
			}
		}
	}
	return outterArray;

}




let comboArr = [1,2,3,4];
let comboNum = 3;
console.log("original array = ",comboArr,", combos = ",comboNum);
console.log(combinationsOfGivenNumber(comboArr, comboNum));
console.log();*/


