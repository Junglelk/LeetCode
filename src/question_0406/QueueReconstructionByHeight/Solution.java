package question_0406.QueueReconstructionByHeight;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        //4,4 5,0 5,2 6,1 7,0 7,1
        //2,0 5,0 7,0 8,0 9,0 5,4 2,7 1,8, 4,5
        people = reconstructQueue(people);

    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if (a[0]!=b[0]){
                return a[0]-b[0];
            } else{
                return b[1]-a[1];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] p:people) {
            int num = p[1]+1;
            for (int i = 0; i < people.length; i++) {
                if (ans[i]==null){
                    if ((--num)==0){
                        ans[i]=p;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
