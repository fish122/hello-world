public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.stairs(2));
    }

    public int stairs (int n) {
        // write code here
        return sl(n,0,0);
    }

    public int sl(int n,int num,int count){
        if(num < n){
            count = sl(n,num+1,count);
            count = sl(n,num+2,count);
        }
        if(num == n){
            count++;
            return count;
        }
        return count;
    }
}
