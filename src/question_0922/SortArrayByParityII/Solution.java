package question_0922.SortArrayByParityII;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] A = {7,6,8,5,4,9};
        System.out.println(Arrays.toString(sortArrayByParityII(A)));
    }

    public static int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int n = A.length;
        int temp = 0;
        int[] A1 = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i]%2==0) {
                A1[even] = A[i];
                even+=2;
            }
            if (A[i]%2==1){
                A1[odd]=A[i];
                odd+=2;
            }
        }
        return A1;
    }
}
/**

 */