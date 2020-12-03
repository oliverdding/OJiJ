package ojij.common.id1117;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 需求：
 * <ul>
 * <li>如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。</li>
 * <li>如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。</li>
 * </ul>
 * 分析：
 * 首先想到的是自动机。使用一个状态标志指示系统当前的状态：
 * 1. 全缺
 * 2. 缺一个H
 * 3. 缺一个O
 * 4. 缺两个H
 * 5. 缺一个O一个H
 * 但是状态机比较适合单线程情况下的转移，多线程时状态的转移就不一定了。
 * <p>
 * 然后考虑到资源信号量。设置两个信号量并初始化为：
 * 1. hSema = 2
 * 2. oSema = 1
 * 那么问题的重点就是如何让线程得知自己生产的是最后一个元素以刷新信号量
 * 这里我决定设置一个原子变量
 */
public class H2O {

    private final Semaphore hSema = new Semaphore(2);
    private final Semaphore oSema = new Semaphore(1);
    private final AtomicInteger num = new AtomicInteger(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSema.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if (num.incrementAndGet() == 3) {
            num.set(0);
            hSema.release(2);
            oSema.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSema.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        if (num.incrementAndGet() == 3) {
            num.set(0);
            oSema.release();
            hSema.release(2);
        }
    }
}
