/**
 * Sample Test Preparation Questions
 * https://compro.miu.edu/sample-test/
 */
package miu_test_prep;

import java.util.Arrays;


/**
 * 
 */
public class MIUSampleTest {
	
	/**
	  * An array with an odd number of elements is said to be centered if all elements (except the middle one) are strictly greater than the value of the middle element.
	  * Note that only arrays with an odd number of elements have a middle element.
	  * Write a function that accepts an integer array and returns 1 if it is a centered array, otherwise it returns 0.
	  * @param arr - array of integers
	  */
	  static int checkIfArrayIsCentered(int[] arr) {
	    if (arr.length % 2 == 0) {
	      return 0;
	    }

	    int middleIndex = arr.length / 2;

	    for (int i = 0; i < arr.length; i++) {
	      if (i == middleIndex) {
	        continue;
	      }

	      if (arr[i] <= arr[middleIndex]) {
	        return 0;
	      }
	    }

	    return 1;
	  }

	  /**
	   * Write a function that takes an array of integers as an argument and returns a value based on the sums of the even and odd numbers in the array.
	   * Let X = the sum of the odd numbers in the array and
	   * let Y = the sum of the even numbers.
	   * The function should return X – Y
	   * @param args
	   */
	  static int getEvenOddDifference(int[] arr) {
	    int oddSum = 0;
	    int evenSum = 0;

	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i] % 2 == 0) {
	        evenSum += arr[i];
	      } else {
	        oddSum += arr[i];
	      }
	    }

	    return oddSum - evenSum;
	  }

	  /**
	   * Write a function that accepts a character array, a zero-based start position and a length.
	   * It should return a character array containing containing lengthcharacters starting with the startcharacter of the input array.
	   * The function should do error checking on the start position and the length and return null if the either value is not legal.
	   * The function signature is:
	   * char[ ] f(char[ ] a, int start, int len)
	   * @param a
	   * @param start
	   * @param len
	   * @return
	   */
	  static char[] getSubArray(char[] a, int start, int len) {
	    if (a.length == 0 || start < 0 || len < 0) return null;
	    int sumLen = start + len;

	    if (sumLen > a.length) return null;

	    char[] subArr = new char[len];
	    try {
	      for (int i = start; i < sumLen; i++) {
	        subArr[i - start] = a[i];
	      }
	    } catch (Exception e) {
	      return null;
	    }
	    return subArr;
	  }

	  /**
	   * Write a function to reverse an integer using numeric operators and without using any arrays or other data structures.
	   * The signature of the function is:
	   * int f(int n)
	   * @param n
	   * @return
	   */
	  static int reverseInteger(int n) {
	    int rev = 0;
	    int sign = 1;
	    if (n < 0) {
	      sign = -1;
	      n = -n;
	    }
	    while (n != 0) {
	      rev = rev * 10 + n % 10;
	      n = n / 10;
	    }
	    return sign * rev;
	  }

	  /**
	   * Write a function to return an array containing all elements common to two given arrays containing distinct positive integers.
	   * You should not use any inbuilt methods.
	   * You are allowed to use any number of arrays.
	   * The signature of the function is:
	   * int[] f(int[] first, int[] second)
	   * @param first
	   * @param second
	   * @return
	   */
	  static int[] getArrayIntersection(int[] first, int[] second) {
	    if (first == null || second == null) return null;
	    if (first.length == 0 || second.length == 0) return new int[]{};

	    int[] outerArray;
	    int[] innerArray;
	    int len = Math.max(first.length, second.length);

	    if (first.length >= second.length) {
	      outerArray = first;
	      innerArray = second;
	    } else {
	      outerArray = second;
	      innerArray = first;
	    }

	    int[] result = new int[len];
	    int resultIndex = 0;

	    for (int i = 0; i < outerArray.length; i++) {
	      for (int j = 0; j < innerArray.length; j++) {
	        if (outerArray[i] == innerArray[j]) {
	          result[resultIndex] = outerArray[i];
	          resultIndex++;
	        }
	      } 
	    }
	    return Arrays.copyOfRange(result, 0, resultIndex);
	  }
	  
	  /**
	   * Consider an array A with n of positive integers.
	   * An integer idx is called a POE (point of equilibrium) of A,
	   * if A[0] + A[1] + … + A[idx – 1] is equal to A[idx + 1] + A[idx + 2] + … + A[n – 1].
	   * Write a function to return POE of an array, if it exists and -1 otherwise. 
	   * The signature of the function is:
	   * int f(int[] a)
	   * @param a
	   * @return
	   */
	  static int findPOE(int[] a) {
		  int[] summedArr = new int[a.length];
		  int poe = -1;

		  for (int i = 0; i < a.length; i++) {
			  int prevSum = i - 1 < 0 ? 0 : summedArr[i - 1];

			  summedArr[i] = prevSum + a[i];
		  }

		  for (int i = 0; i < summedArr.length; i++) {
			  int prevSum = i - 1 < 0 ? 0 : summedArr[i - 1];
			  int diff = summedArr[summedArr.length - 1] - summedArr[i];

			  if (prevSum == diff) {
				  poe = i;
				  break;
			  }

		  }

		  return poe;
	  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	     System.out.println("MIU Sample Test");
	     System.out.println("---------------");
	
	     int[] arr = new int[]{31,12,13};
	     System.out.println(String.format("Q1) %s centered = %d", Arrays.toString(arr), checkIfArrayIsCentered(arr)));
	
	     arr = new int[]{};
	     System.out.println(String.format("Q2) %s diff = %d", Arrays.toString(arr), getEvenOddDifference(arr)));
	
	     char[] cArr = new char[]{'a', 'b', 'c'};
	     char[] result = getSubArray(cArr, 1, 0);
	     System.out.println(result == null ? "Q3) null" : String.format("Q3) %s subArray = %s", Arrays.toString(cArr), Arrays.toString(result)));
	
	     System.out.println("Q4) " + reverseInteger(-12345));
	
	    int[] arr1 = null;
	    int[] arr2 = null;
	    System.out.println(String.format("Q5) %s %s diff = %s", Arrays.toString(arr1), Arrays.toString(arr2), Arrays.toString(getArrayIntersection(arr1, arr2))));
	    
	
	    int[] arr3 = new int[]{1, 2, 10, 3, 4};
	    int poeResult = findPOE(arr3);
	    System.out.println(String.format("Q6) %s POE = %d", Arrays.toString(arr3), poeResult));
        System.out.println("");
	    

	    System.out.println("MIU Official Practice Test");
	    System.out.println("--------------------------");
	    
	    OfficialPracticeTest01 opt01 = new OfficialPracticeTest01();

	    int[] arr4 = new int[]{1,1,1,1,1,2,1,1,1};
	    System.out.println(String.format("Q1) %s laSum = %d", Arrays.toString(arr4), opt01.largestAdjacentSum(arr4)));
	    
	    int num = 9;
	    int catlen = 1;
	    System.out.println(String.format("Q2) num:%d catlen:%d result = %d", num, catlen, opt01.checkConcatenatedSum(num, catlen)));
	    
	    int[] arr5 = new int[]{-5,-5,-4,-4,-4,-3,-3,-2,-2,-2};
	    int m = -5;
	    int n = -2;
	    System.out.println(String.format("Q3) arr:%s m:%d n:%d result = %d", Arrays.toString(arr5), m, n, opt01.isSquaredArray(arr5, m, n)));
	    
	    int[] arr6 = new int[]{5,2,0,1};
	    int[] arr7 = new int[]{0,5,5,5,1,2,1};
	    System.out.println(String.format("Q4) arr1:%s arr2:%s result = %d", Arrays.toString(arr6), Arrays.toString(arr7), opt01.equivalentArrays(arr6, arr7)));
	    
	    int[] arr8 = new int[]{1, 1, 2, 1, 2, 1, 1};
	    System.out.println(String.format("Q5) arr:%s result = %d", Arrays.toString(arr8), opt01.is121Array(arr8)));
	    
	    int[] arr9 = new int[]{1,2,3,4,5,6,7,8,9,10};
	    int n2 = 20;
	    System.out.println(String.format("Q6) arr:%s n:%d result = %d", Arrays.toString(arr9), n2, opt01.hasNValues(arr9, n2)));
	    
	    int[] arr10 = new int[]{7,2,7,2,7,2,7,2,3,7,7};
	    System.out.println(String.format("Q7) arr:%s result = %d", Arrays.toString(arr10), opt01.is235Array(arr10)));
	    
	    int n3 = 30;
	    System.out.println(String.format("Q8) n:%d result = %d", n3, opt01.closestFibonacci(n3)));
	    
	    int[] arr11 = new int[]{1,1,1,1,1,1,1};
	    System.out.println(String.format("Q9) arr:%s result = %d", Arrays.toString(arr11), opt01.isStepped(arr11)));
	    
	    int[] arr12 = new int[]{};
	    int n4 = 0;
	    System.out.println(String.format("Q10) arr:%s n:%d result = %d", Arrays.toString(arr12), n4, opt01.isPairedN(arr12, n4)));
	    
	    int[] arr13 = new int[]{0,0,0,0,0};
	    System.out.println(String.format("Q11) arr:%s result = %d", Arrays.toString(arr13), opt01.computeWeightedSum(arr13)));
	    
	    int[] arr14 = new int[]{2};
	    System.out.println(String.format("Q11) arr:%s result = %d", Arrays.toString(arr14), opt01.isMartian(arr14)));
	    
	    int[] arr15 = new int[]{1,3,9,27};
	    System.out.println(String.format("Q11) arr:%s result = %d", Arrays.toString(arr15), opt01.isRapidlyIncreasing(arr15)));
	    
	    int[] arr16 = new int[]{-1001,-101,-21,-21,2,4,6};
	    System.out.println(String.format("Q11) arr:%s result = %d", Arrays.toString(arr16), opt01.isTwinPaired(arr16)));
	    
	}

}
