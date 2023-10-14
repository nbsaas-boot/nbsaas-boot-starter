package com.nbsaas.boot.security.cache;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import javax.cache.CacheManager;

public class ShiroJCacheManager extends AbstractCacheManager {

    private CacheManager cacheManager;

    public ShiroJCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    protected Cache createCache(String name) throws CacheException {

        return new ShiroJCache(cacheManager.getCache(name));
    }
}
