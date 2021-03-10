public class Solution8 {

    public static void main(String[] args) {
    }
    /*
    * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
    * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
    * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
    * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0;i<A.length-1;i++){
            int left = 0;
            int right = A[i].length-1;
            while (left < right){
                if(A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if(left == right){
                A[i][left] ^= 1;
            }
        }
        return A;
    }
}
