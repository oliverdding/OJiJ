package ojij.common.id1115;

import java.util.concurrent.Semaphore;

/**
 * 需求：
 * 两个不同的线程将会共用一个 FooBar实例。其中一个线程将会调用foo()方法，另一个线程将会调用bar()方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * 设计：
 * 很显然，存在同步的问题。两个线程应该交替执行，且进程foo先执行。
 * 因此使用两个互斥信号量来控制。
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class FooBar {
    private final int n;
    private final Semaphore lock1 = new Semaphore(1);
    private final Semaphore lock2 = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            lock2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            lock1.release();
        }
    }
}
