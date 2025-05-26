package org.DSA.concurrancy;

import java.util.concurrent.Semaphore;

public class ConcurrencyUtils {

    public static void main(String[] args) {
            int n = 5; // You can change this to any number

            FooBar fooBar = new FooBar(n);

            Runnable printFoo = () -> System.out.print("foo");
            Runnable printBar = () -> System.out.print("bar");

            Thread t1 = new Thread(() -> {
                try {
                    fooBar.foo(printFoo);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread t2 = new Thread(() -> {
                try {
                    fooBar.bar(printBar);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("\nDone.");
        }
    //https://leetcode.com/problems/print-foobar-alternately/?envType=problem-list-v2&envId=concurrency
    static class FooBar {
        private int n;
        private Semaphore fooSem=new Semaphore(1);
        private Semaphore barSem=new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooSem.acquire();

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                barSem.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSem.acquire();

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooSem.release();
            }
        }
    }
}
