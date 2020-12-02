package ojij.common.id3;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历每个元素，有:
 * 1. 若无重复，当前长度+1，将当前元素添加到map。
 * 2. 若有重复，将起始点lptr到重复点map[i]的所有元素pop出map，并记录当前长度。
 * 3. 若到字符尾，再执行一次2。
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> includedMap = new HashMap<>();
        int maxSize = 0; // 最大长度
        int lptr = 0; // 当前计算起始点
        for (int i = 0; i < s.length(); i++) {
            if (includedMap.containsKey(s.charAt(i))) { // 有重复
                int position = includedMap.get(s.charAt(i)); // 当前计算移除终点(不包含)
                if (maxSize < i - lptr) { // 更新长度
                    maxSize = i - lptr;
                }
                for (int j = lptr; j < position; j++) { // 移除[lptr, position)
                    includedMap.remove(s.charAt(j));
                }
                lptr = position + 1; // 更新lptr
                includedMap.replace(s.charAt(i), i); // 更新value值
            } else {// 无重复
                includedMap.put(s.charAt(i), i);
                if (i == s.length() - 1) { // 最后无重复
                    if (maxSize < s.length() - lptr) { // 更新长度
                        maxSize = s.length() - lptr;
                    }
                }
            }
        }
        return maxSize;
    }
}
