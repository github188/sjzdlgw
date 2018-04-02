package com.hbdl.common.cache;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.ehcache.CacheManager;

import org.springframework.stereotype.Service;

import com.hbdl.common.utils.CacheUtils;

/**
 * 封装redis 缓存服务器服务接口
 */
@SuppressWarnings({"unchecked", "rawtypes"})
@Service("echCacheService")
public class EchCacheServiceImpl implements CacheService {

	@Resource
	private CacheManager ehcacheManager;
	private static String cacheName = "system_cache";	// 系统缓存名字
	
	@Override
	public long del(String... keys) {
		long lon = 0;
		for (int i = 0; i < keys.length; i++) {
			CacheUtils.evict(cacheName, keys[i]);
			lon ++;
		}
		return lon;
	}
	

	@Override
	public void set(byte[] key, byte[] value, long liveTime) {
		
		CacheUtils.put(cacheName, key.toString(), value, (int)liveTime);
	}

	@Override
	public void set(String key, String value, long liveTime) {
		CacheUtils.put(cacheName, key, value, (int)liveTime);
	}

	@Override
	public void set(String key, String value) {
		CacheUtils.put(cacheName, key, value);
		
	}

	@Override
	public void set(byte[] key, byte[] value) {
		CacheUtils.put(cacheName, key.toString(), value);
		
	}

	
	@Override
	public Set keys(String pattern) {
		List<Object> nonExpiryKeys = ehcacheManager.getCache(cacheName).getKeys();
		Set set = new HashSet(nonExpiryKeys);
		return set;
	}

	@Override
	public boolean exists(String key) {
		return CacheUtils.isCacheByKey(cacheName, key);
	}

	@Override
	public String flushDB() {
		try {
			CacheUtils.clear(cacheName);
		} catch (Exception e) {
			e.printStackTrace();
			return "ok";
		}
		return "error";
	}

	@Override
	public <T> T get(String key) {
		
		return (T)CacheUtils.get(cacheName, key);
	}

	@Override
	public long dbSize() {
		List<Object> nonExpiryKeys = ehcacheManager.getCache(cacheName).getKeys();
//		List<Object> showKeys = Lists.newArrayList();
		return nonExpiryKeys.size();
	}

	@Override
	public String ping() {
		System.out.println("未实现");
		return null;
	}


	

}