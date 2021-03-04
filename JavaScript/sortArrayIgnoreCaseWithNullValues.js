
/*If contains invalid, replace with replaced, return sorted*/
sortArrayIgnoreCaseWithNullValues = (arr) => {

	let newArr = [];
	let invalidString = "invalid";
	let letters = /^[A-Za-z]+$/;

	for(let i = 0; i < arr.length; i++) {

		if(typeof arr[i] === "string" && letters.test(arr[i])) {
			/* compare string ignore case 
			The localeCompare() method returns a number indicating whether a reference string 
			comes before, or after, or is the same as the given string in sort order.*/
			/*The { sensitivity: 'accent' } tells localeCompare() to treat two variants 
			of the same base letter as the same unless they have different accents 
			(as in the third example) above.
			https://stackoverflow.com/questions/2140627/how-to-do-case-insensitive-string-comparison*/
			if(invalidString.localeCompare(arr[i], undefined, { sensitivity: 'accent' }) !== 0) {
				newArr.push(arr[i]);
			} else {
				newArr.push("replaced");
			}
		}
	}
	console.log("New arr without null values and bad characters = ",newArr);

	/* sort array ignoring case
	localeCompare() method returns a number indicating whether a 
	reference string comes before, or after, or is the same as the 
	given string in sort order. */
	newArr.sort(function (a, b) {
    	return a.toLowerCase().localeCompare(b.toLowerCase());
	});
	console.log("SORTED NEW array = ",newArr);

	// place into original array
	arr.length = newArr.length;
	for(let j = 0; j < newArr.length; j++) {
		arr[j] = newArr[j];
	}
	return arr;
}

console.log();
let arr = ['Hey', 'Yo', 'be', , ,'invalid', 'valid', 'InVaL7id', 5, 'aa', 'InVaLid', '5', -4];
console.log("Original array = ",arr);
console.log("Sorted array returned = ",sortArrayIgnoreCaseWithNullValues(arr));