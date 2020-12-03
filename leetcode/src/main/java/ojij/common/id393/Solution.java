package ojij.common.id393;

/**
 * 自然，考虑有限状态机来解决。
 * 问题重点在状态转移上。
 *
 * @author OliverDD
 * @version 1.0.1
 */
public class Solution {

    private boolean is0x(int num) {
        return (num >> 7) == 0;
    }

    private boolean is10x(int num) {
        return (num >> 6) == 2;
    }

    private int wantX(int num) {
        if ((num >> 5) == 6)
            return 1;
        else if ((num >> 4) == 14)
            return 2;
        else if ((num >> 3) == 30)
            return 3;
        return -1;
    }

    /**
     * STATUS:
     * 1. START - waiting for 0x or headx
     * 2. WANT_10x - waiting for one 10x
     * 3. WANT_10x_10x - waiting for two 10x
     * 4. WANT_10x_10x_10x - waiting for three 10x
     *
     * @param data data to judge
     * @return <tt>true</tt> if is utf8, <tt>false</tt> in the other side.
     */
    public boolean validUtf8(int[] data) {
        int status;
        for (int i = 0; i < data.length; ++i) {
            if (is0x(data[i])) {
                continue;
            } else if ((status = wantX(data[i])) > 0) {
                switch (status) {
                    case 1:
                        if (i + 1 < data.length)
                            if (is10x(data[++i]))
                                continue;
                        return false;
                    case 2:
                        if (i + 2 < data.length)
                            if (is10x(data[++i]))
                                if (is10x(data[++i]))
                                    continue;
                        return false;
                    case 3:
                        if (i + 3 < data.length)
                            if (is10x(data[++i]))
                                if (is10x(data[++i]))
                                    if (is10x(data[++i]))
                                        continue;
                        return false;
                }
            }
            return false;
        }
        return true;
    }
}