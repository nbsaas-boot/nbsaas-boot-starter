package com.nbsaas.boot.security.cache;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

public class ShiroCaffeineCacheManager extends AbstractCacheManager {

    @Override
    protected Cache createCache(String name) throws CacheException {
        return new ShiroCaffeineCache(100,5000);
    }
}
