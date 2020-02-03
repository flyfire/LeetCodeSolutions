//我们提供了一个类： 
//
// 
//public class Foo {
//  public void one() { print("one"); }
//  public void two() { print("two"); }
//  public void three() { print("three"); }
//}
// 
//
// 三个不同的线程将会共用一个 Foo 实例。 
//
// 
// 线程 A 将会调用 one() 方法 
// 线程 B 将会调用 two() 方法 
// 线程 C 将会调用 three() 方法 
// 
//
// 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: "onetwothree"
//解释: 
//有三个线程会被异步启动。
//输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
//正确的输出是 "onetwothree"。
// 
//
// 示例 2: 
//
// 
//输入: [1,3,2]
//输出: "onetwothree"
//解释: 
//输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
//正确的输出是 "onetwothree"。 
//
// 
//
// 注意: 
//
// 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。 
//
// 你看到的输入格式主要是为了确保测试的全面性。 
//

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class L1114PrintInOrder {
    public static void main(String[] args) {
         Foo foo = new L1114PrintInOrder().new Foo();
         Thread threadA = new Thread(new ThreadRunnable(foo, 0), "A");
         Thread threadB = new Thread(new ThreadRunnable(foo, 1), "B");
         Thread threadC = new Thread(new ThreadRunnable(foo, 2), "C");
         threadC.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }

    static class ThreadRunnable implements Runnable {
        private final Foo foo;
        private final int type;

        public ThreadRunnable(Foo foo, int type) {
            this.foo = foo;
            this.type = type;
        }

        @Override
        public void run() {
            switch (type) {
                case 0:
                    try {
                        foo.first(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("one");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        foo.second(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("two");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        foo.third(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("three");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Foo {
    private volatile int who = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition two = lock.newCondition();
    Condition three = lock.newCondition();

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            who = 1;
            two.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (who != 1) {
                two.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            who = 2;
            three.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (who != 2) {
                three.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}