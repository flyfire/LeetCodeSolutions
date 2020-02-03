//我们提供一个类： 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 1
//输出: "foobar"
//解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2: 
//
// 
//输入: n = 2
//输出: "foobarfoobar"
//解释: "foobar" 将被输出两次。
// 
//

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class L1115PrintFoobarAlternately {
    public static void main(String[] args) {
         FooBar fooBar = new L1115PrintFoobarAlternately().new FooBar(1);
         Thread threadA = new Thread(new ThreadRunnable(0, fooBar), "A");
         Thread threadB = new Thread(new ThreadRunnable(1, fooBar), "B");
         threadA.start();
         threadB.start();
    }

    static class ThreadRunnable implements Runnable {
        private final int type;
        private final FooBar fooBar;

        public ThreadRunnable(int type, FooBar fooBar) {
            this.type = type;
            this.fooBar = fooBar;
        }


        @Override
        public void run() {
            switch (type) {
                case 0:
                    try {
                        fooBar.foo(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("foo");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        fooBar.bar(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("bar");
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
class FooBar {
    private int n;
    ReentrantLock lock = new ReentrantLock();
    Condition foo = lock.newCondition();
    Condition bar = lock.newCondition();

    private volatile int who = 0;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (who != 0) {
                    foo.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                who = 1;
                bar.signalAll();
                foo.await();
            }
            who = 1;
            bar.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (who != 1) {
                    bar.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                who = 0;
                foo.signalAll();
                bar.await();
            }
            who = 0;
            foo.signalAll();
        } finally {
            lock.unlock();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}