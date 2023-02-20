package com.integration.demo.cyh.demo.xc;

/**
 * @author cyh
 * @date 2023.02.20
 * 线程的停止
 */
public class EndThread {

    /**
     * 总结 jdk总线程是协作式的，不是抢占式的
     * stop()方法：可以用来停止线程，但是属于强制停止，会导致资源无法完全释放
     * 使用interrupt()方法，设置线程的标识，虽然线程不一定停止，但可以根据isInterrupted()方法，判断线程标识位的状态来显示是否线程停止
     */

    /**
     * 创建一个线程类
     */
    private static class UserThread extends Thread {
        /**
         * 创建构造方法，并调用父类构造方法
         */
        public UserThread(String name) {
            super(name);
        }

        //重写父类run方法
        @Override
        public void run() {
            //获取当前线程名称
            String name = Thread.currentThread().getName();
            //获取当前线程循环之前的标识状态
            // isInterrupted() 线程的标识状态是true或false
            System.out.println("当前线程名称:" + name + ",循环前的标识状态：" + isInterrupted());
            //实例1 虽然已经调用了interrupt()方法来设置标识，但while为true，所以线程不会停止
//            while (true) {
//                System.out.println("线程名称:"+name);
//                System.out.println("循环时线程的标识状态"+interrupted());
//            }
            //实例2 interrupted()是静态方法，底层调用的是当前线程的isInterrupted(),所以会重置当前线程的中断状态
//            while (!Thread.interrupted()) {
//                System.out.println("线程名称:" + name);
//                System.out.println("循环时线程的标识状态" + isInterrupted());
//            }
//            //循环结束时interrupted()为true，interrupted()重置当前线程的中断状态为false
//            System.out.println("线程" + name + "循环后线程的标识状态" + interrupted());
            //实例3 isInterrupted()是实例方法，是调用该方法的对象所标识的那个线程的isInterrupted(),不会重置当前线程的中断状态
            while (!isInterrupted()) {
                System.out.println("线程名称:" + name);
                System.out.println("循环时线程的标识状态" + isInterrupted());
            }
            //循环结束时isInterrupted()为true，isInterrupted()不重置当前线程的中断状态，所以循环结束后的标识与结束时的标识一致
            System.out.println("线程" + name + "循环后线程的标识状态" + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        UserThread userThread = new UserThread("程亚辉");
        //启动线程
        userThread.start();
        Thread.sleep(2000);
        //告诉线程，停止线程，但实际作用是通知，线程不一定停止
        userThread.interrupt();
    }
}
