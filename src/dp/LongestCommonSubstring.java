package dp;

public class LongestCommonSubstring {

	public static String printLongestCommonSubstring(String first,String second){

		int firstLen = first.length();
		int secondLen = second.length();

		int[][] ans = new int [firstLen+1][secondLen+1];

		for(int i=0;i<=firstLen;i++){
			ans[i][0] = 0;
		}
		for(int j=0;j<=secondLen;j++){
			ans[0][j] = 0;
		}

		int rowOfFinalMatch=0,colOfFinalMatch=0,lengthOfCommonSubstring=0;
		
		int maxTillNow = Integer.MIN_VALUE;
		for (int i = 1; i <= firstLen; i++) {
			for (int j = 1; j <= secondLen; j++) {
				if(first.charAt(i-1) == second.charAt(j-1)){
					ans[i][j] = 1 + ans[i-1][j-1] ;
					if(ans[i][j]>maxTillNow){
						maxTillNow = ans[i][j];
						lengthOfCommonSubstring = maxTillNow;
						rowOfFinalMatch = i;
						colOfFinalMatch = j;
					}
				}else{
					ans[i][j] = 0;
				}
			}
		}
		
		String commonSubstring = "";
		while (lengthOfCommonSubstring != 0) {
			commonSubstring = first.charAt(rowOfFinalMatch-1) + commonSubstring;
			lengthOfCommonSubstring--;
			rowOfFinalMatch--;
		}
		return commonSubstring;
	}

	public static void main(String[] args) {
		
		/*//Test case 1
		String first = "bdb";
		String second = "abdeb";*/

		String first = "zxabcdezy";
		String second = "yzabcdezx";

		
		String finalAns = printLongestCommonSubstring(first,second);
		System.out.println(finalAns);
	}

}
