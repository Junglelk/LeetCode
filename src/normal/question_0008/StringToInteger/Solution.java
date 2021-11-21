package normal.question_0008.StringToInteger;



import static java.lang.Character.isDigit;


public class Solution {
    public int myAtoi(String str){
        /**
         * 1. 切除两边的空格
         * 2. 识别第一个字符
         *      若为正负号，返回这之后连续的最大长度的整数
         *      若为数字，返回连续长度的整数
         * 3. 第一个不为数字也不为正负号，则不转换
         * 4. 转换数字的大小有限制
         */
        String nums = str.trim();
        if (!nums.equals("")) {
            StringBuffer sb = new StringBuffer();
            String rt = null;
            if (nums.charAt(0) == '+' || nums.charAt(0) == '-') {
                //如果首个为正负号
                sb.append(nums.charAt(0));
                int i = 1;
                while ((i < nums.length()) && isDigit(nums.charAt(i))) {
                    sb.append(nums.charAt(i++));
                }
                rt = sb.toString();
            } else if (isDigit(nums.charAt(0))) {
                sb.append(nums.charAt(0));
                int i = 1;
                while ((i < nums.length()) && isDigit(nums.charAt(i))) {
                    sb.append(nums.charAt(i++));
                }
                rt = sb.toString();
            } else {
                return 0;
            }
            int result = 0;
            try {
                result = Integer.parseInt(rt);
            } catch (Exception e) {
                if (rt.charAt(0) == '+') {
                    if (rt.length()==1){
                        result = 0;
                    }else{
                        result = Integer.MAX_VALUE;
                    }
                }else if (isDigit(rt.charAt(0))){
                    result = Integer.MAX_VALUE;
                }else if (rt.charAt(0)=='-'){
                    if (rt.length()==1){
                        result = 0;
                    }else{
                        result = Integer.MIN_VALUE;
                    }
                }
            }
            return result;
        }
        return 0;
    }
}