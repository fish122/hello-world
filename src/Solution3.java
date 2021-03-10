import java.util.*;

public class Solution3 {
    public static void main(String[] args) {


        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        int[][] p = {{0,3},{1,2},{0,2}};
        for(int i=0;i<p.length;i++){
            List<Integer> pair = new ArrayList<>();
            for(int j = 0;j<p[i].length;j++){
                pair.add(p[i][j]);
            }
            pairs.add(pair);
        }
        Solution3 s3 = new Solution3();
        System.out.println(s3.smallestStringWithSwaps(s,pairs));
    }

    public  String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        char[] str = s.toCharArray();
        int len = str.length;
        int[] parent  = new int[str.length];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        for(List pair:pairs){
            parent[find(parent,(int)pair.get(0))] = find(parent,(int)pair.get(1));
        }
        for(int i = 0;i<parent.length;i++){
            find(parent,i);
        }
        /*Map<Integer,StringBuilder> map = new HashMap<>();
        for(int i = 0;i<parent.length;i++){
            if(map.containsKey(parent[i])){
                map.put(parent[i],map.get(parent[i]).append(str[i]));
            }else {
                map.put(parent[i],new StringBuilder().append(str[i]));
            }
        }
        for(Integer key:map.keySet()){
            char[] a =map.get(key).toString().toCharArray();
            Arrays.sort(a);
            for(int i = 0,j = 0;i<parent.length;i++){
                if(parent[i] == key){
                    str[i] = a[j];
                    j++;
                }
            }

        }*/
        char[] charArray = s.toCharArray();
        // key：连通分量的代表元，value：同一个连通分量的字符集合（保存在一个优先队列中）
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = parent[i];
            if (hashMap.containsKey(root)) {
                hashMap.get(root).offer(charArray[i]);
            } else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(charArray[i]);
                hashMap.put(root, minHeap);
            }
            // 上面六行代码等价于下面一行代码，JDK 1.8 以及以后支持下面的写法
            //hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
        }

        // 第 3 步：重组字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = parent[i];
            stringBuilder.append(hashMap.get(root).poll());
        }
        return stringBuilder.toString();
    }

    public  int find(int[] parent,int index){
        if(parent[index] != index){
            parent[index] = find(parent,parent[index]);
        }
        return parent[index];
    }
}
