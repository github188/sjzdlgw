package com.hbdl.common.base;

import com.alibaba.fastjson.JSONObject;

import javax.persistence.Entity;
import java.util.Map;

@SuppressWarnings({ "unused" })
@Entity
public class BaseEntity extends JSONObject {
	private static final long serialVersionUID = 1L;

	public BaseEntity() {
		super();
	}


	public BaseEntity(Map<String, Object> map) {
		super(map);
	}

	public BaseEntity getEntity(String key) {
		Object value = this.get(key);
		if (value instanceof BaseEntity) {
			return (BaseEntity) value;
		}

		JSONObject jobj = null;

		if (value instanceof JSONObject) {
			jobj = (JSONObject) value;
		} else {
			jobj = (JSONObject) toJSON(value);
		}

		return jobj == null ? null : new BaseEntity(jobj);
	}

	public BaseEntity set(String key, Object value, boolean force) {
		if (force || value != null) {
			super.put(key, value);
		}
		return this;
	}

	public BaseEntity set(String key, Object value) {
		return this.set(key, value, true);
	}

	public BaseEntity setAll(Map<? extends String, ? extends Object> m) {
		super.putAll(m);
		return this;
	}

}
