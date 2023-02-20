package com.integration.demo.cyh.xc;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author cyh
 * @date 2023.02.20
 * 线程系统管理接口获取
 */
public class OnlyMain {

    public static void main(String[] args) {
        //java 虚拟机线程系统的管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //仅仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //遍历线程信息，打印线程id和线程名称
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId()+":"+threadInfo.getThreadName());
        }
    }

    /**
     * 6:Monitor Ctrl-Break 监测Ctrl-Break信号中断
     * 5:Attach Listener
     * 4:Signal Dispatcher
     * 3:Finalizer  守护线程
     * 2:Reference Handler
     * 1:main   主线程
     */

}
