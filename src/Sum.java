import java.util.ArrayList;

public class Sum {

    public static void main(String[] args) {

    }

    /**
     * 计算一组数字的和
     * @param numbers string字符串ArrayList 一组自然数
     * @return string字符串
     */
    public String sum (ArrayList<String> numbers) {
        if(numbers.size() == 1){
            return numbers.get(0);
        }
        String sum = numbers.get(0);
        for(int i = 1;i<numbers.size();i++){
            String number1 = sum;
            String number2 = numbers.get(i);
            int len = number1.length()>number2.length()?number1.length()+1:number2.length()+1;
            int[] result = new int[len];
            char[] chars1 = new StringBuffer(number1).reverse().toString().toCharArray();
            char[] chars2 = new StringBuffer(number2).reverse().toString().toCharArray();
            boolean longerIs1 = number1.length()>number2.length()? true : false;
            if (longerIs1) {
                for (int k = 0; k < number2.length(); k++){
                    result[k] = (chars1[k] - '0') + (chars2[k] - '0');
                }
                for (int j = number2.length(); j < number1.length();j++){
                    result[j] = (chars1[j] - '0');
                }
            } else {
                for (int k = 0; k < number1.length(); k++){
                    result[k] = (chars1[k] - '0') + (chars2[k] - '0');
                }
                for (int j = number1.length(); j < number2.length(); j++) {
                    result[j] = (chars2[j] - '0');
                }
            }
            // 处理进位
            for (int k = 0; k < len; k++){
                if (result[k] >= 10) {
                    result[k + 1] += result[k] / 10;
                    result[k] = result[k] % 10;
                }
            }
            StringBuffer resultStr = new StringBuffer();
            if (result[result.length - 1] != 0) {
                resultStr.append(result[result.length - 1]);
            }
            for (int k = result.length - 2; k >= 0; k--) {
                resultStr.append(result[k]);
            }
            sum = resultStr.toString();
        }
        return sum;
        // write code here
    }
}
