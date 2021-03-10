import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        int n = 8;
        int m = 2;
        List<List<Integer>> beforeItems = new ArrayList<>();
        int[][] b = {{},{6},{5},{6},{3},{},{4},{}};
        int[] group = {-1,-1,1,0,0,1,0,-1};
        for(int i=0;i<b.length;i++){
            List<Integer> pair = new ArrayList<>();
            for(int j = 0;j<b[i].length;j++){
                pair.add(b[i][j]);
            }
            beforeItems.add(pair);
        }
        sortItems(n,m,group,beforeItems);

    }
    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[][] project = new int[m][n];
        for(int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if(i == group[j]){
                    project[i][j] = 1;
                }else {
                    project[i][j] = 0;
                }
            }
        }
        for(int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                System.out.print(project[i][j]+" ");
            }
            System.out.println();
        }




        return group;
    }
}
