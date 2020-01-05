import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** https://docs.oracle.com/javase/8/docs/api/java/util/Map.html 
 * Key, Value pair 
 * boolean - containsKey(key) || containsValue(value)
 * entrySet() - Returns a Set view of the mappings contained in this map. 
 * get(Object key) - returns VALUE 
 * keySet() - Returns a Set view of the keys contained in this map. 
 * put(K key, V value) - Associates the specified value with the specified key in this map (optional) 
 * remove(Object key) - 
 * replace(K key, V oldValue, V newValue)
 * replace(K key, V value) 
 * size() - Returns the number of key-value mappings in this map. 
 * values() - Returns a Collection view of the values contained in this map.*/
public class MapDemo {
	
	


	public static void main(String[] args) {
		
		MapDemo mappin = new MapDemo();
		String[] states = {"Alabama","Arkansas","Alaska","Arizona","Arkansas","Alabama","Arkansas","Alaska","California","Colorado","Connecticut","California","Delaware","Florida","Florida","Georgia"};

		HashMap<String, Integer> hashin = new HashMap<>();
		mappin.hashMapDemo(hashin, states);
	}
	
	public void hashMapDemo(HashMap<String, Integer> map, String[] arr) {
		
		int letterIndex = 0;
		String thisState = "";
		char a = 'a';
		
		for(int i = 0; i < arr.length; i++) {
			
			thisState = arr[i];
			
			if(thisState.charAt(0) != a) {
				map.put(thisState, 1);
				a = thisState.charAt(0);
				letterIndex = 1;
				
			} else {
				++letterIndex;
				map.put(thisState, letterIndex);
			}
		}
		
		for(String state : map.keySet()) {
			System.out.print(state+" "+map.get(state)+", ");
		}
		
	}

}
