package ojij.common.id6;


/**
 * Z字形变换：
 * 方法一：
 * 找到不同行的规律；给定一个字符串s以及行数numRows
 * 第0行的字符下标为 k*2*(numRows-1)
 * 第numRows-1行的字符下标为 k*2*(numRows-1)+(numRows-1)
 * 第i行的字符下标为 k*2*(numRows-1)+i或者k*2*(numRows-1)-i
 *
 * @author RikkiYang
 * @version 1.0.0
 */

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder ns = new StringBuilder();
        int addLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < s.length(); j += addLen) {
                ns.append(s.charAt(i + j));
                if (i != 0 && i != (numRows - 1) && (j + addLen - i) < s.length())
                    ns.append(s.charAt(j + addLen - i));
            }
        }
        return ns.toString();
    }
}
