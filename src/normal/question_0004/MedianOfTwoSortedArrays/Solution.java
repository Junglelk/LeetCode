package normal.question_0004.MedianOfTwoSortedArrays;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length+nums2.length];
            int p1 = 0;
            int p2 = 0;
            int i = 0;
            while(p1<nums1.length&&p2<nums2.length){
                if(nums1[p1]>nums2[p2])
                    num[i++]=nums2[p2++];
                else
                    num[i++]=nums1[p1++];
            }
            while(p1<nums1.length)
                num[i++]=nums1[p1++];

            while(p2<nums2.length)
                num[i++]=nums2[p2++];
        return singleMedianArray(num);
    }
    public double singleMedianArray(int[] num){
        double result = 0;
        int length = num.length;
        if (length%2==0){
            result = ((double)num[length/2]+(double)num[(length/2)-1])/2;
        }else {
            result = num[length/2];
        }
        return  result;
    }
}
/**class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int p1=0; int p2=0; int k=0;
        int[] temp=new int[nums1.length+nums2.length];
        while(p1<nums1.length&&p2<nums2.length){//合并两数组，一旦有一个越界即停止
            if(nums1[p1]>nums2[p2])
                temp[k++]=nums2[p2++];
            else
                temp[k++]=nums1[p1++];
        }
        //两个while语句只会执行一个，执行那个不会使上面那个while语句停止的语句
        while(p1<nums1.length)
            temp[k++]=nums1[p1++];

        while(p2<nums2.length)
            temp[k++]=nums2[p2++];

        if(temp.length==1)
            return temp[0];
        if(temp.length%2==1)
            return temp[temp.length/2];
        else
            return (double)(temp[temp.length/2]+temp[(temp.length/2)-1])/2;

    }
}
*/