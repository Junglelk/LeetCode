package normal.medium.question_0388.LongestAbsoluteFilePath;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Jungle
 * @since 2022/4/20 23:03
 */
public class Solution {
    @Test
    public void test() {
        final String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        final String[] split = s.split("\n");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replace('\t', '\\');
        }
        System.out.println(Arrays.toString(split));
        System.out.println(s);
        System.out.println(lengthLongestPath(s));
    }

    public int lengthLongestPath(String input) {
        if (!input.contains(".")) {
            return 0;
        }
        Deque<String> stack = new ArrayDeque<>();
        int max = 0;
        int length = 0;
        final String[] split = input.split("\n");
        for (int i = 0; i < split.length; i++) {
            String path = split[i];
            if (i == 0) {
                stack.push(path);
            } else {
                if (path.contains(".")) {
                    length += path.replaceAll("\t", "").length() + 1;
                    max = Math.max(length, max);
                } else {
                    String peek = stack.peek();
                    int num1 = hasT(peek);
                    int num2 = hasT(path);
                    while (num1 >= num2) {
                        if (stack.size() > 1) {
                            num1 = hasT(stack.pop());
                        } else break;
                    }
                    stack.push(path);
                }

            }

        }

        return max;
    }

    int hasT(String s) {
        if (s == null) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\\') {
                num++;
            } else {
                break;
            }
        }
        return num;
    }
}
