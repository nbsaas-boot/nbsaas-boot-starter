package com.nbsaas.boot.security.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.Set;

public class ShiroCaffeineCache<K, V> implements Cache<K, V> {

    LoadingCache<K, V> cache;
    public ShiroCaffeineCache(int init,int max) {
        cache= Caffeine.newBuilder()
                .initialCapacity(init)
                .maximumSize(max)
                .build(key -> null);
    }

    @Override
    public V get(K key) throws CacheException {
        return cache.getIfPresent(key);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        cache.put(key, value);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        V value = cache.getIfPresent(key);
        cache.invalidate(key);
        return value;
    }

    @Override
    public void clear() throws CacheException {
        cache.invalidateAll();
    }

    @Override
    public int size() {
        return (int) cache.estimatedSize();
    }

    @Override
    public Set<K> keys() {
        return cache.asMap().keySet();
    }

    @Override
    public Collection<V> values() {
        return cache.asMap().values();
    }


}
