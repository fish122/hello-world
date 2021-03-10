import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,9,8,4,5};
        sort(a);

    }


    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int i = 0;
        double[] jieguo = new double[queries.size()];
        HashMap<String,List<String>> map = new HashMap<>();
        for(List<String> equation:equations){
            if(!map.containsKey(equation.get(0))){
                List<String> nums = new  ArrayList<>();
                nums.add(equation.get(1));
                nums.add(values[i]+"");
                map.put(equation.get(0),nums);
            }
            if(!map.containsKey(equation.get(1))){
                List<String> nums = new  ArrayList<>();
                nums.add(equation.get(0));
                nums.add(1.0/values[i]+"");
                map.put(equation.get(1),nums);
            }
            i++;
        }
        int j = 0;
        for(List<String> querie:queries){
            if(map.containsKey(querie.get(0))&&map.containsKey(querie.get(1))){
                String x = querie.get(0);
                String y = querie.get(1);
                double num = 1;
                if(x.equals(y)){
                    jieguo[j] = 1.0;
                }else{
                    while (true) {
                        List<String> nums1 = map.get(x);
                        num = Double.parseDouble(nums1.get(1))*num;
                        x = nums1.get(0);
                        if(x.equals(y)){
                            jieguo[j] = num;
                            break;
                        }
                        List<String> nums2 = map.get(y);
                        num = num/Double.parseDouble(nums2.get(1));
                        y = nums2.get(0);
                        if(y.equals(x)){
                            jieguo[j] = num;
                            break;
                        }
                    }
                }
            }else {
                jieguo[j] = -1.0;
            }
            j++;
        }
        return jieguo;
    }


    public static void  sort(int[] a){
        boolean y;
        for(int i = 0;i<a.length;i++){
            y = true;
            for(int j = 1;j<a.length-i;j++){
                if(a[j-1]>a[j]){
                    y = false;
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
            if(y){
                break;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
