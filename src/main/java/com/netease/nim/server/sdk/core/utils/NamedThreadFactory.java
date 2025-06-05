package com.netease.nim.server.sdk.core.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;
    private final boolean daemon;

    public NamedThreadFactory(Class<?> clazz, boolean daemon) {
        SecurityManager s = System.getSecurityManager();
        this.group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        this.namePrefix = clazz.getSimpleName() + "-pool-" +
                poolNumber.getAndIncrement() + "-thread-";
        this.daemon = daemon;
    }

    public NamedThreadFactory(Class<?> clazz) {
        this(clazz, false);
    }

    public NamedThreadFactory(String name) {
        this(name, false);
    }

    public NamedThreadFactory(String name, boolean daemon) {
        SecurityManager s = System.getSecurityManager();
        this.group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        this.namePrefix = name + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        this.daemon = daemon;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        if (daemon) {
            if (!t.isDaemon()) {
                t.setDaemon(true);
            }
        } else {
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
