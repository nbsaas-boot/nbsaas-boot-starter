package com.nbsaas.boot.security.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.Set;

public class ShiroJCache<K, V> implements Cache<K, V> {

     javax.cache.Cache<K, V> cache;
    public ShiroJCache( javax.cache.Cache<K, V> cache) {
        this.cache= cache;
    }

    @Override
    public V get(K key) throws CacheException {
        return cache.get(key);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        cache.put(key, value);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        V value = cache.get(key);
        cache.remove(key);
        return value;
    }

    @Override
    public void clear() throws CacheException {
        cache.clear();
    }

    @Override
    public int size() {
        return getCacheSize(cache);
    }
    public int getCacheSize(javax.cache.Cache<K, V> cache) {
        int size = 0;
        for (javax.cache.Cache.Entry<K, V> ignored : cache) {
            size++;
        }
        return size;
    }
    @Override
    public Set<K> keys() {
        return cache.unwrap(java.util.Map.class).keySet();
    }

    @Override
    public Collection<V> values() {
        return cache.unwrap(java.util.Map.class).values();
    }


}
