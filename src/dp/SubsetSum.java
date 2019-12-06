package dp;

public class SubsetSum {
	
	public static boolean isSubsetHaveSum(int[] numbers, int requiredSum){
		
		//if confused how to get perfect size of 'ans' array, i can say that, write program and you will automatically understand it while solving ArrayIndexOutOfBound. It happens. Writing similar code over and again,you will build a skill to understand it. 
		boolean[][] ans = new boolean[numbers.length+1][requiredSum+1];
		
		// The below two for loops are base case. Put it on paper and you will understand it easily that how it is base case.
		for(int i=0;i<numbers.length+1;i++){
			ans[i][0] = true;
		}
		// You can remove this loop as well as Java by default initialize array with false.
		for(int j=1;j<requiredSum+1;j++){
			ans[0][j] = false;
		}
		
		for(int i=1;i<=numbers.length;i++){
			for(int j=1;j<=requiredSum;j++){
				if(numbers[i-1]>j){
					ans[i][j] = ans[i-1][j];
				}else{
					ans[i][j] = ans[i-1][j] || ans[i-1][j-numbers[i-1]];
				}
			}
		}
		
		return ans[numbers.length][requiredSum];
	}

	public static void main(String[] args) {
		/*// Test case 1
		int[] numbers = new int[]{2,3,7,8,10};
		int requiredSum = 11 ;*/
		
		// Test case 2 
		int[] numbers = new int[]{15, 22, 14, 26, 32, 9, 16, 8};
		int requiredSum = 53 ;
		
		boolean finalAns = isSubsetHaveSum(numbers, requiredSum);
		System.out.println(finalAns);
	}

}
