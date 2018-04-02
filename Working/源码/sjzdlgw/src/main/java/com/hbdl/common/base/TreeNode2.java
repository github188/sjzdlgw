package com.hbdl.common.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode2 {

	private String id;
	private String parentId; //父级id
	private String name; //名称
	private String url; //链接
	private String icon; //图标
	private int order; //排序
	private int level=-1; //深度
	private boolean open = false; //是否打开
	private boolean hasChild = false; //有子节点吗
	private List<TreeNode2> items; //子节点集合
	
	
	public TreeNode2(){}
	public TreeNode2(String id, String parentId, String name, String url, String icon) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.url = url;
		this.icon = icon;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
	public boolean getHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	public List<TreeNode2> getItems() {
		return items;
	}
	
	//添加子节点
	private void addChild(final TreeNode2 node){
		if(items == null){
			items = new ArrayList<TreeNode2>();
		}
	    items.add(node);
	}
	
	//递归找level
	private static int resolveLevel(final TreeNode2 node, final Map<String, TreeNode2> nodes){
	    int level = node.level;
	    if(level == -2){
	        throw new RuntimeException("Node循环了, id=" + node.id);
	    }
	    if(level == -1){
	        node.level  = -2;
	        level = node.level = resolveLevel(nodes.get(node.getParentId()),nodes) +1;
	    }else{
	    	node.hasChild = true;
	    }
	    return level;
	}

	/**
	 * 构造无限级树结构
	* @param list 初始的list
	* @return
	* @throws Exception parentNode is null
	 */
	public static List<TreeNode2> baseTreeNode(List<TreeNode2> list){
		final Map<String, TreeNode2> nodes = new HashMap<String, TreeNode2>();

		//所有节点记录下来
		for(TreeNode2 node : list){
		    nodes.put(node.getId(), node);
		}

		final TreeNode2 root = new TreeNode2();
		root.level = 0;
		nodes.put("0", root);

		for(TreeNode2 node : list){
		    final TreeNode2 parent = nodes.get(node.parentId);
			if(parent == null){
				throw new RuntimeException("子节点有父级id，却没有找到此父级的对象");
			}
		    //添加子节点
		    parent.addChild(node);
		}
		
		int max = 0;
		for(TreeNode2 node : list){
			max = Math.max(resolveLevel(node, nodes), max);
		}

		return root.items;
	}
	

}
