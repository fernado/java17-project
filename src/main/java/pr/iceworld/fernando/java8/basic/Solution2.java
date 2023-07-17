package pr.iceworld.fernando.java8.basic;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution("dog"));
    }
    public int solution(String S) {
        // Implement your solution here
        if (S.indexOf("aaa") > -1) {
            return -1;
        }
        if (S.equals("aa")) {
            return 0;
        }


        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != 'a') {
                ll.add(i);
            }
        }

        if (ll.size() > 0) {
            if (ll.size() == S.length()) {
                return (S.length() + 1) * 2;
            }
            return (ll.size() * 2) - 1;
        }


        return 0;
    }
}
