public class Solution9 {
    public static void main(String[] args) {
        int A[] = {0,0,1,1,1,0,0};
        int K = 0;
        System.out.println(longestOnes(A,K));
    }

    public static int longestOnes(int[] A, int K) {
        int max = 0;
        for(int i = 0;i<A.length;i++){
            int temp = 0,num = K;
            for(int j = i;j<A.length;j++){
                if(A[j] == 1){
                    temp++;
                    continue;
                }
                if(num !=0){
                    num--;
                    temp++;
                }else
                    break;
            }
            if(temp>max){
                max = temp;
            }
        }
        return max;
    }
}
