package ojij.common.id204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用线性晒法
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] decMap = new boolean[n];
        Arrays.fill(decMap, true);
        for (int i = 2; i < n; ++i) {
            if (decMap[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                decMap[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) { // 重点：当可以被整除，表示后续的点不必标记，会被后续的数标记
                    break;
                }
            }
        }
        return primes.size();
    }
}
