

sortArrayIgnoreCaseWithNullValues = (arr) => {

	let newArr = [];

	for(let i = 0; i < arr.length; i++) {
		if(typeof arr[i] === "string") {
			newArr.push(arr[i]);
		}
	}
	console.log("New arr without null values and bad characters = ",newArr);

	// sort array ignoring case
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
let arr = ['Hey', 'Yo', 'be', , ,'invalid', 'valid', 'InVaLid', 5, 'aa', '5', -4];
console.log("Original array = ",arr);
console.log("Sorted array returned = ",sortArrayIgnoreCaseWithNullValues(arr));