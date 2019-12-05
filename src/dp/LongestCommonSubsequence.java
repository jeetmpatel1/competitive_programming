package dp;

public class LongestCommonSubsequence {

	public static int findLengthOfLongestCommonSubsequence(String first,String second){
		int firstLen = first.length();
		int secondLen = second.length();
		
		int[][] ans = new int[firstLen+1][secondLen+1];
		
		for(int i=1;i<=firstLen;i++){
			for(int j=1;j<=secondLen;j++){
				if(first.charAt(i-1) == second.charAt(j-1)){
					ans[i][j] = ans[i-1][j-1] + 1;
				}else{
					ans[i][j] = Math.max(ans[i-1][j],ans[i][j-1]);
				}
			}
		}
		return ans[firstLen][secondLen];
	}
	public static void main(String[] args) {
		
			/*// Test case 1
			String first = "12341";
			String second = "341213";*/
			
			// Test case 2
			String first = "abcdaf";
			String second = "acbcf";
			
			int finalAns = findLengthOfLongestCommonSubsequence(first, second);
			System.out.println(finalAns);
	}

}
