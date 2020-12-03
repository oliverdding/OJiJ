package ojij.common.id406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 先排序，按身高从高到低(相同时按照before从小到大)
 * 然后使用list这个容器，利用插入新元素后下边会自动变化的特性(链表)来有效插入新元素
 *
 * <ul>
 * <li>间复杂度: o(n^2)</li>
 * <li>空间复杂度: o(log n)</li>
 * </ul>
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution2 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person); // 亮点在于对于list而言，每每插入新元素，后续元素的位置都会改动
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
