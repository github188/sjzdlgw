package com.hbdl.common.cache;

import java.io.Serializable;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.hbdl.web.sys.utils.SerializeUtils;

/**
 * 封装redis 缓存服务器服务接口
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Service("redisService")
public class RedisServiceImpl implements CacheService {

	@Autowired(required = false)
	protected RedisTemplate<Serializable, Serializable> redisTemplate;

	@Override
	public void set(final byte[] key, final byte[] value, final long liveTime) {
		redisTemplate.execute(new RedisCallback() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(key, value);
				if (liveTime > 0) {
					connection.expire(key, liveTime);
				}
				return 1L;
			}
		});

	}

	@Override
	public void set(String key, String value, long liveTime) {
//		this.set(key.getBytes(), value.getBytes(), liveTime);
		this.set(SerializeUtils.serialize(key), SerializeUtils.serialize(value), liveTime);
	}

	@Override
	public void set(String key, String value) {
//		this.set(key.getBytes(), value.getBytes(), 0L);
		this.set(SerializeUtils.serialize(key), SerializeUtils.serialize(value), 0L);

	}

	@Override
	public void set(byte[] key, byte[] value) {
		this.set(key, value, 0L);
	}

	@Override
	public <T> T get(final String key) {
		Boolean flag = exists(key);
		if (flag) {
			return (T) redisTemplate.execute(new RedisCallback() {
				public T doInRedis(RedisConnection connection) {
					try {
						byte[] bt = connection.get(SerializeUtils.serialize(key));
						return (T) SerializeUtils.unserialize(bt);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			});
		} else {
			return null;
		}
	}

	@Override
	public boolean exists(final String key) {
		return (Boolean) redisTemplate.execute(new RedisCallback() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.exists(SerializeUtils.serialize(key));
			}
		});
	}

	@Override
	public Set keys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	@Override
	public long del(final String... keys) {
		return (Long) redisTemplate.execute(new RedisCallback() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				long result = 0;
				for (int i = 0; i < keys.length; i++) {
					result = connection.del(SerializeUtils.serialize(keys[i]));
				}
				return result;
			}
		});
	}

	@Override
	public String flushDB() {
		return (String) redisTemplate.execute(new RedisCallback() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
	}

	@Override
	public long dbSize() {
		return (Long) redisTemplate.execute(new RedisCallback() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.dbSize();
			}
		});
	}

	@Override
	public String ping() {
		return (String) redisTemplate.execute(new RedisCallback() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.ping();
			}
		});
	}

}