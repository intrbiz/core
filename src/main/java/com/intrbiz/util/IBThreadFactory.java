package com.intrbiz.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class IBThreadFactory implements ThreadFactory
{
    private ThreadGroup group;

    private String baseName;

    private final AtomicLong sequence = new AtomicLong();

    private boolean daemon;

    public IBThreadFactory(String baseName, boolean daemon, ThreadGroup group)
    {
        this.baseName = baseName;
        this.daemon = daemon;
        this.group = group;
    }
    
    public IBThreadFactory(String baseName, boolean daemon)
    {
        this(baseName, daemon, new ThreadGroup(baseName));
    }

    public Thread newThread(Runnable r)
    {
        Thread t = new Thread(this.group, r, this.baseName + "-" + this.sequence.incrementAndGet());
        t.setDaemon(this.daemon);
        return t;
    }

}
