package dp;

public class CoinChange {

	public static int minimumCoinsRequired(int[] typesOfCoins,int total){
		int[][] ans = new int[typesOfCoins.length][total+1];
		
		//Initialization
		for(int i=0;i<typesOfCoins.length;i++){
			ans[i][0] = 0;
		} 
		for(int j=1;j<=total;j++){
			ans[0][j] = Math.max(0,j - typesOfCoins[0] +1 );
		}
		
		// Main logic 
		for(int i=1 ; i<typesOfCoins.length ;i++ ){
			for(int j=1 ; j<= total ;j++ ){
				if(j<typesOfCoins[i]){
					ans[i][j] = ans[i-1][j];
				}else{
					ans[i][j] = Math.min(ans[i-1][j], 1 + ans[i][j-typesOfCoins[i]]);
				}
				
			}
		}
		
		return ans[typesOfCoins.length - 1 ][total ];
	}
	public static void main(String[] args) {
		
		/*// Test case 1
		int[] typesOfCoins =  {1, 2, 3};
		int total = 4;
		*/
		/*// Test case 2
		int[] typesOfCoins =  {1, 5, 10};
		int total = 8;*/
		
		int[] typesOfCoins =  {1, 5, 10};
		int total = 12;
		
		int finalAns = minimumCoinsRequired(typesOfCoins, total);
		System.out.println(finalAns);

	}

}
