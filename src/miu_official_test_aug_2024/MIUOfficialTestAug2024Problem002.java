/**
 * 
 */
package miu_official_test_aug_2024;

import java.util.Arrays;

/**
 * Author: uzairahmedwyne@hotmail.com
 */
public class MIUOfficialTestAug2024Problem002 {
	
	int is121Array(int[] a) {
		// array with less than three elements can't be a 121 array
		if (a.length < 3) return 0;
		
		// if start and end elements are not 1 then its not a 121 array
		if (a[0] != 1 || a[a.length - 1] != 1) return 0;
		
		// initialize variables
		
		// a flag to show if we have started counting the ending trail of 1's
		boolean startEndCounting = false;
		// count of 1's at start of array
		int start1Count = 1;
		// count of 1's at end of array
		int end1Count = 1;
		
		for (int i=1; i<a.length-1; i++) {
			// if any digit other than 1 and 2 is found then return early
			if (a[i] != 2 && a[i] != 1) return 0;
			
			// if current element is 2 and we had already started counting trailing 1's of array, then return 0
			if (a[i] == 2 && end1Count > 1) return 0;
			
			// if current value is 2 and we have not started the counting for trailing 1's
			// then we need to set flag, so that on next encounter of 1 we start counting for trailing 1's
			if (a[i] == 2 && !startEndCounting) {
				startEndCounting = true;
			}
			// if current value is 1 and we have not started the counting for trailing 1's then increment start 1 count
			else if (a[i] == 1 && !startEndCounting) start1Count++;
			// if current value is 1 and we have already started the counting for trailing 1's then increment end 1 count
			else if (a[i] == 1 && startEndCounting) end1Count++;
		}
		
		// if we reached this spot, and the number of 1's at start and end of array are same, then it means its a 121 array
		return start1Count == end1Count ? 1 : 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// initialize
		MIUOfficialTestAug2024Problem002 obj = new MIUOfficialTestAug2024Problem002();
		int[] a;

		// TEST CASES
		a = new int[]{1, 2, 1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.is121Array(a)));
		
		a = new int[]{1, 1, 2, 2, 2, 1, 1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.is121Array(a)));
		
		a = new int[]{1, 1, 2, 2, 2, 1, 1, 1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.is121Array(a)));
		
		a = new int[]{1, 1, 2, 1, 2, 1, 1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.is121Array(a)));
		
		a = new int[]{1, 1, 1, 2, 2, 2, 1, 1, 1, 3};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.is121Array(a)));
		
		a = new int[]{1, 1, 1, 1, 1, 1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.is121Array(a)));
		
		a = new int[]{2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.is121Array(a)));
		
		a = new int[]{1, 1, 1, 2, 2, 2, 1, 1, 2, 2};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.is121Array(a)));
		
		a = new int[]{2, 2, 2};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.is121Array(a)));
	}

}
