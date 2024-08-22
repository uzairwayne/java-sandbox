/**
 * 
 */
package miu_test_prep;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class OfficialPracticeTest01 {

	/**
	 * 
	 */
	public OfficialPracticeTest01() {
		// TODO Auto-generated constructor stub
	}
	
	int largestAdjacentSum(int[] a) {
		int laSum = 0;
		
		for (int i = 0; i < a.length - 1; i++) {
			int sum = a[i] + a[i+1];
			
			if (sum > laSum) {
				laSum = sum;
			}
		}
		
		return laSum;
	}
	
	int checkConcatenatedSum(int n, int catlen) {
		int origNum = n;
		int totalSum = 0;
		while (n != 0) {
			int digit = n%10;
			int sum = 0;
			for (int i = 0; i < catlen; i++) {
				sum = ((sum*10) + digit);
			}
			
			totalSum += sum;
			
			n/=10;
		}
		
		return totalSum == origNum ? 1 : 0;
	}
	
	int isSquaredArray(int[] a, int m, int n) {
		int totalValidDigits = (n - m) + 1;
		int uniqueDigitCount = 0;
		int currMax = a[0];
		int prevVal = currMax - 1;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] > currMax) {
				currMax = a[i];
			}
			
			if (a[i] < currMax) {
				return 0;
			}
			
			if (a[i] != prevVal) {
				uniqueDigitCount++;
			}
			
			prevVal = a[i];
		}
		
		return totalValidDigits == uniqueDigitCount ? 1 : 0;
	}
	
	int equivalentArrays(int [] a1, int [] a2) {
		if (a1.length == 0 || a2.length == 0) return 0;

		int minVal = a1[0];
		int maxVal = a1[0];
		
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] < minVal) {
				minVal = a1[i];
			}
			
			if (a1[i] > maxVal) {
				maxVal = a1[i];
			}
		}
		
		for (int i = 0; i < a2.length; i++) {
			if (a2[i] < minVal || a2[i] > maxVal) return 0;
		}
		
		return 1;
	}
	
	int is121Array(int[] a) {
		if (a.length < 3) return 0;
		
		if (a[0] != 1 || a[a.length - 1] != 1) return 0;
		
		boolean startEndCounting = false;
		
		int start1Count = 1;
		int end1Count = 1;
		
		for (int i=1; i<a.length-1; i++) {
			if (a[i] != 2 && a[i] != 1) return 0;
			
			if (a[i] == 2 && end1Count > 1) return 0;
			
			if (a[i] == 2 && !startEndCounting) {
				startEndCounting = true;
			}
			else if (a[i] == 1 && !startEndCounting) start1Count++;
			else if (a[i] == 1 && startEndCounting) end1Count++;
		}
		
		return start1Count == end1Count ? 1 : 0;
	}
	
	int hasNValues(int[] a, int n) {
		int distintDigitCount = 0;
		// Creating an empty HashMap
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		
		for (int i = 0; i < a.length; i++) {
			if (!map.containsKey(a[i])) {
				distintDigitCount++;
				map.put(a[i], true);
			}
		}
		
		return distintDigitCount == n ? 1 : 0;
	}
	
	int is235Array(int[] a) {
		int[] arr = new int[4];
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0)
				arr[0]++;
			if (a[i] % 3 == 0)
				arr[1]++;
			if (a[i] % 5 == 0)
				arr[2]++;
			
			if (a[i] % 2 != 0 && a[i] % 3 != 0 && a[i] % 5 != 0)
				arr[3]++;
		}
		
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		
		return a.length == sum ? 1 : 0;
	}
	
	int closestFibonacci(int n) {
		if (n == 0) return n;
		int fib = 1;
		int[] fibs = new int[]{fib,fib};
		while (fib <= n) {
			fib = fibs[1] + fibs[0];
			
			fibs[0] = fibs[1];
			fibs[1] = fib;
			
		}
		
		return fibs[0];
	}
	
	int isStepped (int[] a) {
		if (a.length < 3) return 0;
		int prevVal = a[0] - 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] < prevVal) return 0;
			
			map.put(a[i], (map.get(a[i]) != null ? map.get(a[i]) : 0) + 1);
			prevVal = a[i];
		}
		
		return map.containsValue(0) || map.containsValue(1) || map.containsValue(2) ? 0 : 1;
	}
	
	int isPairedN(int[] a, int n) {
		// Check if the array is too short to contain two distinct elements
        if (a == null || a.length < 2) {
            return 0;
        }
        
	    // Check if n is too large for any valid indices
        if (n < 1 || n > a.length) {
          return 0;
        }

        // HashMap to store value and its index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int complement = n - a[i];
            int requiredIndex = n - i;

            // Check if there's a previous element such that arr[j] + arr[i] = n and j + i = n
            if (map.containsKey(complement) && map.get(complement) == requiredIndex) {
                return 1;
            }

            // Add current element and its index to the map
            map.put(a[i], i);
        }

        // If no such pair is found, return 0
        return 0;
	}
	
	int computeWeightedSum(int[] a) {
		int evenWeightedSum = 0;
		int oddWeightedSum = 0;
		
		for (int i = 0; i < a.length; i++) {
			if ((a[i] & 1) == 1) oddWeightedSum += 3 * a[i];
			else evenWeightedSum += 2 * a[i];
		}
		
		return evenWeightedSum + oddWeightedSum;
	}
}
