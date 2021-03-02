let year = 2000;
let numArr = Array.from(String(year), Number);
console.log("orig = ",year," array from string = ",numArr);
// orig =  2000  array from string =  [ 2, 0, 0, 0 ]


/*Given a year, return century it is in.
Century = 1-100, so 1 = 100, and 100 = 100, but 101 = 200 */
function centuryFromYear(year) {
  let centuryCount = 0;
  while (year > 0){
    year = year - 100;
    centuryCount = centuryCount + 1;
  }
  return centuryCount;
}
console.log("Year 1 century = ",centuryFromYear(1));
console.log("Year 100 century = ",centuryFromYear(100));
console.log("Year 101 century = ",centuryFromYear(101));
console.log("Year 1999 century = ",centuryFromYear(1899));
console.log("Year 1999 century = ",centuryFromYear(1999));
console.log("Year 2000 century = ",centuryFromYear(2000));
console.log("Year 2001 century = ",centuryFromYear(2001));

/* FindIntersection(strArr) read the array of strings stored in strArr which 
will contain 2 elements: the first element will represent a list of 
comma-separated numbers sorted in ascending order, the second element will 
represent a second list of comma-separated numbers (also sorted). 
Your goal is to return a comma-separated string containing the numbers that 
occur in elements of strArr in sorted order. If there is no intersection, 
return the string false.*/
function FindIntersection(strArr) { 

  let StringArr1 = strArr[0].split(",");
  let StringArr2 = strArr[1].split(",");
  let first;
  let second;
  let finalString = "";

  for(let i = 0; i < StringArr1.length; i++) {

    first = StringArr1[i];

    for(let j = 0; j < StringArr2.length; j++) {

      second = StringArr2[j];

      if(first === second) {
        finalString += first+",";
      }
    }
  }

  finalString = finalString.slice(0, -1);
  finalString = finalString.split(" ").join("");

  return finalString !== "" ? finalString : false; 

}
   
// expected: Output: 1,4,13
console.log(FindIntersection(["1, 3, 4, 7, 13", "1, 2, 4, 13, 15"]));
// expected: Output: 1,9,10
console.log(FindIntersection(["1, 3, 9, 10, 17, 18", "1, 4, 9, 10"]));
// expected: Output: false
console.log(FindIntersection(["1, 3, 9, 10, 17, 18", "2, 4, 8, 11"]));


/* Return the difference from multiplication of digits to addition */
digitsManipulations = (n) => {

  let digits = (""+n).split("");
  console.log("orig = ",n," after split = ",digits);
  let multiply = 1;
  let add = 0;

  for(let i = 0; i < digits.length; i++) {
    multiply *= parseInt(digits[i]);
    add += parseInt(digits[i]);
  }

  return multiply-add;
}
// expected: 699
console.log(digitsManipulations(123456));
// expected: -2
console.log(digitsManipulations(1010));

/* You are given two strings, pattern and s.
pattern contains only 0 and 1, s contains only lowercase letters.
If pattern matches a substring s[1...r] of s, if the following conditions are met:
- they have equal length
- for each 0 in pattern the corresponding letter in the substring is a vowel
- for each i in pattern the corresponding letter is a constant 
Ex: pattern = 010, s = amazing, the output = 2
ama==010 YES, maz!=010, 010==azi YES, zin!=010, ing!=010
Ex: pattern = 100, s = codesignal, output = 0
cod!=100, ode!=100, des!=100, esi!=100, sig!= 100
output = 0,
*/
matchPattern = (pattern, s) => {

  let digits = (""+s).split("");
  let finalCount = 0;

  for(let i = 0; i < pattern.length-digits.length; i++) {
    let count = 1;
    let patternCount = i;

    for(let j = 0; j < digits.length; j++) {

      if(pattern.charAt(patternCount) === 'a' && digits[j] === '0' || pattern.charAt(patternCount) === 'e' && digits[j] === '0' || pattern.charAt(patternCount) === 'i' && digits[j] === '0' || pattern.charAt(patternCount) === 'o' && digits[j] === '0' || pattern.charAt(patternCount) === 'u' && digits[j] === '0' || pattern.charAt(patternCount) === 'y' && digits[j] === '0') {
        count += 1;
      }
      patternCount += 1;
    }

    if(count === digits.length) {
      console.log("i = ",i);
      finalCount++;
    }
  }

  return finalCount;
}
// expected: 2
console.log("amazing & 010 = ",matchPattern("amazing","010"));
// expected: 0
console.log("codesignal & 100 = ", matchPattern("codesignal","100"));


