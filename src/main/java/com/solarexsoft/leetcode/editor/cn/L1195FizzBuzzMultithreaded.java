//编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是： 
//
// 
// 如果这个数字可以被 3 整除，输出 "fizz"。 
// 如果这个数字可以被 5 整除，输出 "buzz"。 
// 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。 
// 
//
// 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14
//, fizzbuzz。 
//
// 假设有这么一个类： 
//
// class FizzBuzz {
//  public FizzBuzz(int n) { ... }               // constructor
//  public void fizz(printFizz) { ... }          // only output "fizz"
//  public void buzz(printBuzz) { ... }          // only output "buzz"
//  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
//  public void number(printNumber) { ... }      // only output the numbers
//} 
//
// 请你实现一个有四个线程的多线程版 FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用： 
//
// 
// 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。 
// 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。 
// 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。 
// 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。 
// 
//

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class L1195FizzBuzzMultithreaded {
    public static void main(String[] args) {
         FizzBuzz fizzBuzz = new L1195FizzBuzzMultithreaded().new FizzBuzz(20);
         Thread threadA = new Thread(new FizzBuzzRunnable(fizzBuzz, 0), "A");
         Thread threadB = new Thread(new FizzBuzzRunnable(fizzBuzz, 1), "B");
         Thread threadC = new Thread(new FizzBuzzRunnable(fizzBuzz, 2), "C");
         Thread threadD = new Thread(new FizzBuzzRunnable(fizzBuzz, 3), "D");
         threadA.start();
         threadB.start();
         threadC.start();
         threadD.start();

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
        System.out.println(threadInfos);
    }
    
    static class FizzBuzzRunnable implements Runnable {
        private final FizzBuzz fizzBuzz;
        private final int type;

        public FizzBuzzRunnable(FizzBuzz fizzBuzz, int type) {
            this.fizzBuzz = fizzBuzz;
            this.type = type;
        }

        @Override
        public void run() {
            switch (type) {
                case 0:
                    try {
                        fizzBuzz.fizz(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("fizz");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    try {
                        fizzBuzz.buzz(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("buzz");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        fizzBuzz.fizzbuzz(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("fizzbuzz");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        fizzBuzz.number(new IntConsumer() {
                            @Override
                            public void accept(int value) {
                                System.out.println(value);
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
class FizzBuzz {
    private int n;
    
    private volatile int who = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition threeCon = lock.newCondition(); // await when who != 3
    Condition fiveCon = lock.newCondition();  // await when who != 5
    Condition fifteenCon = lock.newCondition(); // await when who != 15
    Condition numberCon = lock.newCondition(); // await when who != 0

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i++) {
                while (who != 3) {
                    threeCon.await();
                }
                if (i % 3 == 0 && i % 5 != 0) {
                    System.out.println(i + " --> fizz");
                    who = 0;
                    numberCon.signalAll();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i++) {
                while (who != 5) {
                    fiveCon.await();
                }
                if (i % 5 == 0 && i % 3 != 0) {
                    System.out.println(i + " --> buzz");
                    who = 0;
                    numberCon.signalAll();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i++) {
                while (who != 15) {
                    fifteenCon.await();
                }
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println(i + " --> fizzbuzz");
                    who = 0;
                    numberCon.signalAll();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i++) {
                while (who != 0) {
                    numberCon.await();
                }
                if (i % 15 == 0) {
                    who = 15;
                    fifteenCon.signalAll();
                    numberCon.await();
                } else if (i % 5 == 0) {
                    who = 5;
                    fiveCon.signalAll();
                    numberCon.await();
                } else if (i % 3 == 0) {
                    who = 3;
                    threeCon.signalAll();
                    numberCon.await();
                } else {
                    printNumber.accept(i);
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}