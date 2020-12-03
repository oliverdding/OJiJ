package ojij.common.id1116;

@FunctionalInterface
interface IntConsumer {
    void accept(int x);
}

/**
 * 需求：
 * 请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * 分析：
 * 非常简单的同步问题。首先zero函数要首先执行，之后以zeor-even-zero-odd...的顺序交替执行，又是信号量。
 * 但是有一点要考虑到。even和odd之间若是使用共享变量，这里就有好几个思路，要么使用原子变量，要么把变量的访问上锁，或者使用java提供的最简单的同步策略volatile，只要保证仅仅一条线程对其有修改，就能保证线程安全性且内存一致性。
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class ZeroEvenOdd {

    private final int n;
    private volatile int status = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (status != 0) { // 自旋锁于0
                Thread.yield();
            }
            printNumber.accept(0);
            if ((i & 1) == 1) {  // 注意一种情况，最后一定要保证另外两个线程可以退出，不然就会超时
                status = 1;
            } else {
                status = 2;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (status != 1) { // 自旋锁于1
                Thread.yield();
            }
            printNumber.accept(i);
            status = 0;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (status != 2) { // 自旋锁于2
                Thread.yield();
            }
            printNumber.accept(i);
            status = 0;
        }
    }
}
