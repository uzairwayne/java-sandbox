/**
 * 
 */
package miu_official_test_aug_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: uzairahmedwyne@hotmail.com
 */
public class MIUOfficialTestAug2024Problem001 {
	
	int isStepped (int[] a) {
		/**
		 * if less than 3 elements, then return 0
		 * as the condition "3 or more occurrences of each distinct value in the array" fails
		 */
		if (a.length < 3) return 0;
		
		// initializing variables
		int prevVal = a[0] - 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < a.length; i++) {
			// return early if we find that its not in ascending order
			if (a[i] < prevVal) return 0;
			
			/**
			 * set the map as
			 * key = a[i]
			 * value = value + a[i]
			 * ----------------------------------------------------
			 * this is to store the count of each distinct element
			 */
			map.put(a[i], (map.get(a[i]) != null ? map.get(a[i]) : 0) + 1);
			prevVal = a[i];
		}
		
		/**
		 * If we find that any digit has occurrence less than three then we return 0 else 1
		 */
		return map.containsValue(0) || map.containsValue(1) || map.containsValue(2) ? 0 : 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// initialize
		MIUOfficialTestAug2024Problem001 obj = new MIUOfficialTestAug2024Problem001();
		int[] a;

		// TEST CASES
		a = new int[]{1, 1, 1, 5, 5, 5, 5, 8, 8, 8};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isStepped(a)));
		
		a = new int[]{1, 1, 5, 5, 5, 5, 8, 8, 8};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isStepped(a)));
		
		a = new int[]{5, 5, 5, 15};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isStepped(a)));
		
		a = new int[]{3, 3, 3, 2, 2, 2, 5, 5, 5};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isStepped(a)));
		
		a = new int[]{3, 3, 3, 2, 2, 2, 1, 1, 1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isStepped(a)));
		
		a = new int[]{1, 1, 1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isStepped(a)));
		
		a = new int[]{1, 1, 1, 1, 1, 1, 1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isStepped(a)));

	}

}
