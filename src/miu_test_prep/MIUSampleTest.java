/**
 * 
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
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("MIU Sample Test");

	    // int[] arr = new int[]{31,12,13};
	    // System.out.println(String.format("%s centered = %d", Arrays.toString(arr), checkIfArrayIsCentered(arr)));

	    // arr = new int[]{};
	    // System.out.println(String.format("%s diff = %d", Arrays.toString(arr), getEvenOddDifference(arr)));

	    // char[] cArr = new char[]{'a', 'b', 'c'};
	    // char[] result = getSubArray(cArr, 1, 0);
	    // System.out.println(result == null ? "null" : String.format("%s subArray = %s", Arrays.toString(cArr), Arrays.toString(result)));

	    // System.out.println(reverseInteger(-12345));

	    int[] arr1 = null;
	    int[] arr2 = null;
	    System.out.println(String.format("%s %s diff = %s", Arrays.toString(arr1), Arrays.toString(arr2), Arrays.toString(getArrayIntersection(arr1, arr2))));

	}

}
