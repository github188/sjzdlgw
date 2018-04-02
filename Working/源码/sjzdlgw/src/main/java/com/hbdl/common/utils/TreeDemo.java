package com.hbdl.common.utils;

import java.io.Serializable;

import com.hbdl.common.base.BaseEntity;

public class TreeDemo extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String parentId;

	public void setId(String id) {
		this.set("id", id);
	}

	public String getId() {
		return this.getString("id");
	}

	public void setName(String name) {
		this.set("name", name);
	}

	public String getName() {
		return this.getString("name");
	}

	public void setParentId(String parentId) {
		this.set("parentId", parentId);
	}

	public String getParentId() {
		return this.getString("parentId");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(this.getId());
		sb.append(", parentId=").append(this.getParentId());
		sb.append(", name=").append(this.getName());
		sb.append("]");
		return sb.toString();
	}

}
