package normal.question_0009.PalindromeNumber;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int temp=x;
        int length=0;
        while(temp!=0){
            temp/=10;
            length++;
        }
        int[] ary = new int[length];
        while (x!=0){
            ary[temp++] = x%10;
            x/=10;
        }
        boolean flag = true;
        temp = 0;
        int j = ary.length-1;
        while(temp<j){
            if (ary[temp++]!=ary[j--]){
                flag =false;
                break;
            }
        }
        return flag;
    }
}
