package com.hbdl.common.cache;

import java.util.Set;

public interface CacheService {

	/**
	 * 通过key删除
	 * @param key
	 */
	public abstract long del(String... keys);

	/**
	 * 添加key value 并且设置存活时间(byte)
	 * @param key
	 * @param value
	 * @param liveTime
	 */
	public abstract void set(byte[] key, byte[] value, long liveTime);

	/**
	 * 添加key value 并且设置存活时间
	 * @param key
	 * @param value
	 * @param liveTime
	 *            单位秒
	 */
	public abstract void set(String key, String value, long liveTime);

	/**
	 * 添加key value
	 * 
	 * @param key
	 * @param value
	 */
	public abstract void set(String key, String value);

	/**
	 * 添加key value (字节)(序列化)
	 * @param key
	 * @param value
	 */
	public abstract void set(byte[] key, byte[] value);

	/**
	 * 通过正则匹配keys
	 * 
	 * @param pattern
	 * @return
	 */
	public abstract Set keys(String pattern);

	/**
	 * 检查key是否已经存在
	 * @param key
	 * @return
	 */
	public abstract boolean exists(String key);

	/**
	 * 清空缓存所有数据
	 * @return
	 */
	public abstract String flushDB();

	public abstract <T> T get(String key);
	
	/**
	 * 查看缓存里有多少数据
	 */
	public abstract long dbSize();

	/**
	 * 检查是否连接成功
	 * @return
	 */
	public abstract String ping();

}