package dp;

public class MatrixChainMultiplication {
	
	public static int minimumMultiplicationsForMatrix(int[] dimentions){
		int numOfMatrices = dimentions.length-1;
		
		int[][] ans = new int[numOfMatrices+1][numOfMatrices+1];
		
		for(int l=2;l<=numOfMatrices;l++){
			for(int i=1;i<=numOfMatrices-l+1;i++){
				int j=i+l-1;
				ans[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<=j-1;k++){
					int temp = ans[i][k]+ans[k+1][j]+ ( dimentions[i-1] * dimentions[k] * dimentions[j]);
					if(temp < ans[i][j])
						ans[i][j] = temp;
				}
			}
		}
		return ans[1][numOfMatrices];
	}

	public static void main(String[] args) {
		
		/*// Test case 1
		int[] dimentions = new int[]{2,3,6,4,5};*/
		
		// Test case 2
		int[] dimentions = new int[]{1, 2, 3, 4};
		
		int finalAns = minimumMultiplicationsForMatrix(dimentions);
		System.out.println(finalAns);
	}

}
