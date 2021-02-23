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



/**
 * Return the user ids of the users that go in the order "A,B,C"
 */

func = (arr) => {
  let map = new Map();
  let newArr;

  for(let i = 0; i < arr.length; i++) {
    if(!map.has(arr[i].userId)) {
      let newArr = [];
      newArr.push(arr[i].action);
      map.set(arr[i].userId, newArr);
    } else {
      newArr = map.get(arr[i].userId);
      map.set(arr[i].userId, [arr[i].action, ...newArr]);
    }
  }

  let alpha = ['A','B','C'];
  let returnArr = [];
  let thisArray = [];
  add = true;

  for (let [key, value] of map) {
    thisArray = value;
    for(let j = 0; j < alpha.length; j++) {
      if(alpha[j] !== thisArray[thisArray.length-1-j]) {
        add = false;
      }
    }
    if(add) {
      returnArr.push(key);
    }
    add = true;
  }
  return returnArr;
}

let firstArr = [
  {userId: 1, action: 'A'}, {userId: 1, action: 'B'},{userId: 2, action: 'A'},
  {userId: 2, action: 'B'}, {userId: 2, action: 'C'},{userId: 1, action: 'B'},
  {userId: 3, action: 'A'}, {userId: 4, action: 'B'},{userId: 3, action: 'B'},
  {userId: 4, action: 'B'}, {userId: 3, action: 'C'},{userId: 4, action: 'B'},
  ];
console.log();
console.log("original array = ",firstArr)
console.log(func(firstArr));

