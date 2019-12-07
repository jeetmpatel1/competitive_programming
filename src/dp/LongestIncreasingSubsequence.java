package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	// The difference between four different functions is the sign while comparing elements of ith and jth loop. 
	
	public static int lengthOfLongestIncreasingSubsequence(int[] inputArray){

		int arrayLen = inputArray.length;

		int[] ans = new int[arrayLen];
		Arrays.fill(ans, 1);

		int maxLengthOfLIS = 1;
		for (int i = 1; i < arrayLen; i++) {
			for (int j = 0; j < i; j++) {
				if(inputArray[i] > inputArray[j]){
					ans[i] = Math.max(ans[i],ans[j]+1);
					if(ans[i] >= maxLengthOfLIS)
						maxLengthOfLIS = ans[i];
				}
			}
		}

		return maxLengthOfLIS;
	}

	public static int lengthOfLongestNonDecreasingSubsequence(int[] inputArray){

		int arrayLen = inputArray.length;

		int[] ans = new int[arrayLen];
		Arrays.fill(ans, 1);

		int maxLengthOfLIS = 1;
		for (int i = 1; i < arrayLen; i++) {
			for (int j = 0; j < i; j++) {
				if(inputArray[i] >= inputArray[j]){
					ans[i] = Math.max(ans[i],ans[j]+1);
					if(ans[i] >= maxLengthOfLIS)
						maxLengthOfLIS = ans[i];
				}
			}
		}

		return maxLengthOfLIS;
	}
	
	public static int lengthOfLongestDecreasingSubsequence(int[] inputArray){

		int arrayLen = inputArray.length;

		int[] ans = new int[arrayLen];
		Arrays.fill(ans, 1);

		int maxLengthOfLIS = 1;
		for (int i = 1; i < arrayLen; i++) {
			for (int j = 0; j < i; j++) {
				if(inputArray[i] < inputArray[j]){
					ans[i] = Math.max(ans[i],ans[j]+1);
					if(ans[i] >= maxLengthOfLIS)
						maxLengthOfLIS = ans[i];
				}
			}
		}

		return maxLengthOfLIS;
	}

	public static int lengthOfLongestNonIncreasingSubsequence(int[] inputArray){

		int arrayLen = inputArray.length;

		int[] ans = new int[arrayLen];
		Arrays.fill(ans, 1);

		int maxLengthOfLIS = 1;
		for (int i = 1; i < arrayLen; i++) {
			for (int j = 0; j < i; j++) {
				if(inputArray[i] <= inputArray[j]){
					ans[i] = Math.max(ans[i],ans[j]+1);
					if(ans[i] >= maxLengthOfLIS)
						maxLengthOfLIS = ans[i];
				}
			}
		}

		return maxLengthOfLIS;
	}
	
	public static void main(String[] args) {

		/*// Test case 1
		int[] inputArray = new int[]{1,1};*/

		// Test case 2
		int[] inputArray = new int[]{-1,3,4,5,2,2,2,2};

		int finalAnsIncreasing = lengthOfLongestIncreasingSubsequence(inputArray);
		System.out.println(finalAnsIncreasing);

		int finalAnsNonDecreasing = lengthOfLongestNonDecreasingSubsequence(inputArray);
		System.out.println(finalAnsNonDecreasing);

		int finalAnsDecreasing = lengthOfLongestDecreasingSubsequence(inputArray);
		System.out.println(finalAnsDecreasing);
		
		int finalAnsNonIncreasing = lengthOfLongestNonIncreasingSubsequence(inputArray);
		System.out.println(finalAnsNonIncreasing);
	}

}
