import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T997_E_Graph {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> trusting = new HashMap<>();
        Map<Integer, List<Integer>> trusted = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            if (trusting.containsKey(trust[i][0])){
                trusting.get(trust[i][0]).add(trust[i][1]);
            }else {
                List<Integer> iTrusting = new ArrayList<>();
                iTrusting.add(trust[i][1]);
                trusting.put(trust[i][0], iTrusting);
            }
        }
        return 0;
    }

    @Test
    public void Test() {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
        System.out.println(findJudge(3, new int[][]
                {
                        {1, 2},
                        {2, 3}
                }));
        System.out.println(findJudge(3, new int[][]
                {
                        {1, 3},
                        {2, 3},
                        {3, 1}
                }));
    }
}
