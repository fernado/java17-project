package pr.iceworld.fernando.java8.basic;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public static void main(String[] args) {
        //int[] AA = new int[] {1, 3, 6, 4, 1, 2};
        int[] AA = new int[] {-1, -3};
        //int[] AA = new int[] {1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.solution(AA));
    }
    public int solution(int[] A) {
        // Implement your solution here
        Set<Integer> sets = new TreeSet();
        int v = 0;
        for (int i = 0; i < A.length; i++) {
            sets.add(A[i]);
        }
        List<Integer> list = new ArrayList(sets);
        if (list.size() == 1) {
            return list.get(0) + 1;
        } else if (list.size() == 2) {            
            if (list.get(1) + 1 < 0) {
                return 1;
            }
            return list.get(1) + 1 ;
        } else {
            int i = 0;
            int j = 0;
            int k = 0;
            for (i = 0, j = i + 1, k = j + 1; k < list.size(); i++, j++, k++) {
                if (list.get(j) - list.get(i) > 1) {
                    if (list.get(i) + 1 < 0) {
                        return 1;
                    }
                    return list.get(i) + 1;
                }
                if (list.get(k) - list.get(j) > 1) {
                    if (list.get(j) + 1 < 0) {
                        return 1;
                    }
                    return list.get(j) + 1;
                }
            }
            return list.get(k - 1) + 1;
        }
    }
}
