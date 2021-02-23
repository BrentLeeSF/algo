/* Remove All Adjacent Duplicates In String
Input: "abbacacc" remove "bb" -> "aacacc"
"aaca" remove "aa" -> "cacc"
"cacc" remove "cc" -> "ca"
return "ca"*/

removeDuplicates = (S) => {
  let stringArray = S.split("");

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
console.log("Original String = ",originalString,", result = ",removeDuplicates(originalString));

