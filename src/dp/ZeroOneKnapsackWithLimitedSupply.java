package dp;

public class ZeroOneKnapsackWithLimitedSupply {

	public static int zero_one_Knapsack(int[] weight,int[] val,int capacity){
		int n = weight.length;
		int[][] ans = new int[n+1][capacity+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=capacity;j++){
				if (j < weight[i-1])
					ans[i][j] = ans[i-1][j];
				else{
					ans[i][j] = Math.max(ans[i-1][j], val[i-1] + ans[i-1][j-weight[i-1]]);
				}
					
			}
		}
		return ans[n][capacity];
	}
	
	public static void main(String[] args) {
		/*
		 * //Test case 1
		int val[] = new int[]{60, 100, 120}; 
        int weight[] = new int[]{10, 20, 30}; 
        int  capacity = 50;*/ 
        
        int val[] = new int[]{10, 40, 30, 50}; 
        int weight[] = new int[]{5, 4, 6, 3}; 
        int  capacity = 10; 
        
        int finalAns = zero_one_Knapsack(weight, val, capacity);
        System.out.println(finalAns);

	}

}
