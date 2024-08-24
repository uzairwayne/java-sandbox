/**
 * 
 */
package miu_official_test_aug_2024;

import java.util.Arrays;

/**
 * Author: uzairahmedwyne@hotmail.com
 */
public class MIUOfficialTestAug2024Problem003 {
	
	int isRapidlyIncreasing(int[] a) {
		// assuming input array is never empty or null and always contains at least one value
		// let the first element be the initial sum
		int runningSum = a[0];

		for (int i=1; i < a.length; i++) {
			// check if the current element is less than or equal to the twice of previous accumulated sums
			// if yes, then return 0
			if (a[i] <= (2 * runningSum)) return 0;
			
			// update the accumulator
			runningSum += a[i];
		}

		// if we reached this spot, it means its a rapidly increasing array
		return 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// initialize
		MIUOfficialTestAug2024Problem003 obj = new MIUOfficialTestAug2024Problem003();
		int[] a;

		// TEST CASES
		a = new int[]{1, 3, 9, 27};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isRapidlyIncreasing(a)));
		
		a = new int[]{1, 3, 200, 500};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isRapidlyIncreasing(a)));
		
		a = new int[]{1};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isRapidlyIncreasing(a)));
		
		a = new int[]{1, 3, 9, 26};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isRapidlyIncreasing(a)));
		
		a = new int[]{1, 3, 7, 26};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isRapidlyIncreasing(a)));
		
		a = new int[]{1, 3, 8, 26};
		System.out.println(String.format("%s => %d", Arrays.toString(a), obj.isRapidlyIncreasing(a)));
	}

}
