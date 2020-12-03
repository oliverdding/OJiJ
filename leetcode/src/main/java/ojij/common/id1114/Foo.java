package ojij.common.id1114;

import java.util.concurrent.Semaphore;

/**
 * 需求：请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * 考虑：多线程同步。无共享变量，也就没有内存一致性、竞态条件的问题，只是简单使用内部锁实现PV操作。
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Foo {

    private final Semaphore lock1 = new Semaphore(0);
    private final Semaphore lock2 = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lock1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lock2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
