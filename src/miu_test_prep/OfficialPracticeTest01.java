/**
 * 
 */
package miu_test_prep;

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
}
