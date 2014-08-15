package com.intrbiz.cache;

@Deprecated()
public interface IBCache<K,V>
{
    void setParent(IBCache<K,V> cache);

    void cache(K key, V value);

    void cachePrivate(K key, V value);

    void invalidate(K key);

    V get(K key);

    void clear();
}
