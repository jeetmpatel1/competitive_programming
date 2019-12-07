package dp;

public class KadaneAlgorithmMaximumSumSubarrayWithNegative {

	public static int printMaximumSubarrayWithIndices(int[] input){
		
		int sum = input[0];
		int finalAns = input[0];
		
		int start=0;
		int end =0;
		
		for(int j=1; j< input.length; j++){
			sum = sum + input[j];
			if( sum >= finalAns){
				if( sum >= input[j]){
					finalAns = sum;
					end = j;
				}else{
					finalAns = input[j];
					start = j;
					end = j;
					sum = finalAns;
				}
			}else{
				if(finalAns <= input[j]){
					finalAns = input[j];
					start = j;
					end = j;
					sum = finalAns;
				}
			}
		}
		
		for (int i = start; i <= end; i++) {
			System.out.print( input[i] + "   ");
		}
		System.out.println();
		return finalAns;
	}
	public static void main(String[] args) {
		
		/*// Test case 1
		int[] input = new int[]{5};*/
		
		/*// Test case 1
		int[] input = new int[]{-5};*/
		
		/*// Test case 3
		int[] input = new int[]{1,5};*/
		
		/*// Test case 4
		int[] input = new int[]{-1,5};*/

		/*// Test case 5
		int[] input = new int[]{5,-1};*/
			
		/*// Test case 6
		int[] input = new int[]{-5,-1};*/
		
		/*// Test case 7 
		int[] input = new int[]{-1,-5};*/
		
		// Test case 8
		int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
				
		int finalAns = printMaximumSubarrayWithIndices(input);
		System.out.println(finalAns);
	}

}
