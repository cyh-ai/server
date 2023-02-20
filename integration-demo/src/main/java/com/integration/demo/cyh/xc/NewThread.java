package com.integration.demo.cyh.xc;

/**
 * @author cyh
 * @date 2023.02.20
 * 新启线程的方法
 */
public class NewThread {

    /**
     * 1.继承Thread类
     */
    private static class UserThread extends Thread{
        //重写父类run方法
        @Override
        public void run() {
            super.run();
            System.out.println("我继承了Thread类");
        }
    }

    /**
     * 2.实现Runnable接口
     */
    private static class UserRunanble implements Runnable{

        @Override
        public void run() {
            System.out.println("我实现了Runnable接口");
        }
    }

    public static void main(String[] args) {
        //两种线程创建与调用
        //继承Thread类
        UserThread userThread = new UserThread();
        userThread.start();
        //实现Runnable接口
        UserRunanble userRunanble = new UserRunanble();
        new Thread(userRunanble).start();
    }

    /**
     * 两者区别：
     * Thread是Java对线程的抽象
     * Runnable是对业务逻辑的抽象
     */

}
