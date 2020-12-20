package ojij.剑指Offer.id64;

public class Solution {
    public int sumNums(int n) {
        boolean flas = ((n == 0) || ((n += sumNums(n - 1)) == 0));
        return n;
    }
}
