package ojij.common.id6;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法二：
 * 建立一个桶，先把每一行内容确定，再一行一行合并
 * 首先确定有多少个非空行
 *
 * @author RikkiYang
 * @version 1.0.0
 */

public class Solution2 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> lists = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++)
            lists.add(new StringBuilder());
        boolean goDown = false;
        int curRow = 0;
        for (int j = 0; j < s.length(); j++) {
            lists.get(curRow).append(s.charAt(j));
            if (curRow == 0 || curRow == numRows - 1)
                goDown = !goDown;
            curRow += goDown ? 1 : -1;
        }
        StringBuilder str = new StringBuilder();
        for (StringBuilder list : lists)
            str.append(list);
        return str.toString();
    }
}
