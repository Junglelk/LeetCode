import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {

    @Test
    public void test() {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }


    public boolean areNumbersAscending(String s) {
        List<Integer> list = new ArrayList<>();
        String[] ret = s.split(" ");
        for (String s1 : ret) {
            if (Character.isDigit(s1.charAt(0))) {
                list.add(Integer.parseInt(s1));
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
