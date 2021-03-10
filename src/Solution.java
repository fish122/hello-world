public class Solution {

    public static void main(String[] args) {
        int[][] a= {{1,0,0,1},
                    {0,1,1,0},
                    {0,1,1,1},
                    {1,0,1,1}};
        int[][] b= {{1,1,0},
                    {1,1,0},
                    {0,0,1}};


        System.out.println(findCircleNum(a));

    }

    public static int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    parent[find(parent,i)] = find(parent,j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public static int find(int[] parent,int index){
        if(parent[index]!=index){
            parent[index] = find(parent,parent[index]);
        }
        return parent[index];
    }



}
