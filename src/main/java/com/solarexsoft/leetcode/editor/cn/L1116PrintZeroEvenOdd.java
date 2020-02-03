//假设有这么一个类： 
//
// class ZeroEvenOdd {
//  public ZeroEvenOdd(int n) { ... }      // 构造函数
//  public void zero(printNumber) { ... }  // 仅打印出 0
//  public void even(printNumber) { ... }  // 仅打印出 偶数
//  public void odd(printNumber) { ... }   // 仅打印出 奇数
//}
// 
//
// 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程： 
//
// 
// 线程 A 将调用 zero()，它只输出 0 。 
// 线程 B 将调用 even()，它只输出偶数。 
// 线程 C 将调用 odd()，它只输出奇数。 
// 
//
// 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n
//。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出："0102"
//说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出："0102030405"
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
import java.util.function.IntConsumer;

public class L1116PrintZeroEvenOdd {
    public static void main(String[] args) {
         ZeroEvenOdd zeroEvenOdd = new L1116PrintZeroEvenOdd().new ZeroEvenOdd(1);
         Thread threadA = new Thread(new ThreadRunnable(zeroEvenOdd, 0), "A");
         Thread threadB = new Thread(new ThreadRunnable(zeroEvenOdd, 1), "B");
         Thread threadC = new Thread(new ThreadRunnable(zeroEvenOdd, 2), "C");
         threadA.start();
         threadB.start();
         threadC.start();
    }

    static class ThreadRunnable implements Runnable {
        private final ZeroEvenOdd zeroEvenOdd;
        private final int type;

        public ThreadRunnable(ZeroEvenOdd zeroEvenOdd, int type) {
            this.zeroEvenOdd = zeroEvenOdd;
            this.type = type;
        }

        @Override
        public void run() {
            switch (type) {
                case 0:
                    try {
                        zeroEvenOdd.zero(new IntConsumer() {
                            @Override
                            public void accept(int value) {
                                System.out.println(Thread.currentThread().getName() + "-> " + value);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        zeroEvenOdd.odd(new IntConsumer() {
                            @Override
                            public void accept(int value) {
                                System.out.println(Thread.currentThread().getName() + "-> " + value);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        zeroEvenOdd.even(new IntConsumer() {
                            @Override
                            public void accept(int value) {
                                System.out.println(Thread.currentThread().getName() + "-> " + value);
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
class ZeroEvenOdd {
    private volatile int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition odd = lock.newCondition();
    private Condition even = lock.newCondition();
    private volatile int count = 1;
    private volatile int who = 0;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (count <= n) {
                while (who != 0) {
                    zero.await();
                }
                printNumber.accept(0);
                if (count % 2 == 0) {
                    who = 2;
                    even.signalAll();
                } else {
                    who = 1;
                    odd.signalAll();
                }
                zero.await();
            }
            who=1;
            odd.signalAll();
            who=2;
            even.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (count <= n) {
                while (who != 2) {
                    even.await();
                }
                printNumber.accept(count++);
                who = 0;
                zero.signalAll();
                even.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (count <= n) {
                while (who != 1) {
                    odd.await();
                }
                printNumber.accept(count++);
                who = 0;
                zero.signalAll();
                odd.await();
            }
        } finally {
            lock.unlock();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}