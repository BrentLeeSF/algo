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