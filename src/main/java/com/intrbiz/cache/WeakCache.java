package com.intrbiz.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated()
public class WeakCache<K, V> implements IBCache<K, V>
{
    private final Lock queueLock = new ReentrantLock();

    private final ReferenceQueue<V> queue = new ReferenceQueue<V>();

    private final Map<K, CacheEntry> cache = new ConcurrentHashMap<K, CacheEntry>();

    public WeakCache()
    {
        super();
    }

    @SuppressWarnings("unchecked")
    protected void processQueue()
    {
        if (this.queueLock.tryLock())
        {
            try
            {
                CacheEntry e;
                while ((e = (CacheEntry) this.queue.poll()) != null)
                {
                    this.cache.remove(e.getKey());
                }
            }
            finally
            {
                this.queueLock.unlock();
            }
        }
    }

    protected class CacheEntry extends WeakReference<V>
    {
        private final K key;

        public CacheEntry(K key, V value)
        {
            super(value, queue);
            this.key = key;
        }

        public K getKey()
        {
            return key;
        }
    }

    @Override
    public void cache(K key, V value)
    {
        this.cachePrivate(key, value);
    }

    @Override
    public void cachePrivate(K key, V value)
    {
        this.processQueue();
        this.cache.put(key, new CacheEntry(key, value));
    }

    @Override
    public V get(K key)
    {
        this.processQueue();
        CacheEntry ce = this.cache.get(key);
        if (ce == null) return null;
        return ce.get();
    }

    @Override
    public void clear()
    {
        this.processQueue();
        this.cache.clear();
    }

    @Override
    public void invalidate(K key)
    {
        this.processQueue();
        this.cache.remove(key);
    }

    @Override
    public void setParent(IBCache<K, V> cache)
    {
    }
}
