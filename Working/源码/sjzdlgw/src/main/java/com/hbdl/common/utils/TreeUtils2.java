package com.hbdl.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hbdl.common.base.BaseEntity;

@SuppressWarnings({"unchecked", "rawtypes"})
public class TreeUtils2 {
	
	
	/**
	 * 转换成List形式树结构 (如果是缓存的list，请务必深度copy一个)
	* @param list
	* @return
	 */

	public static  List<Map> toTreeNodeList(List<Map> source){
		
		final Map<String, Map> nodes = new HashMap<String, Map>();
		
		//深度copy一个，防止源list内部结构改变
		List<Map> list = new ArrayList<Map>(source.size());
		for (Map o : source) {
			Map map = new HashMap();
			map.putAll(o);
			list.add(map);
		}
		
		//所有节点记录下来
		for(Map node : list){
			node.put("level", -1);
			node.put("hasChild", false);
			node.put("children", new ArrayList<Map>());
		    nodes.put((String) node.get("id"), node);
		}

		final BaseEntity root = new BaseEntity();
		root.put("level", 0);
		root.put("children", new ArrayList<Map>());
		root.put("hasChild", false);
		nodes.put("0", (Map) root);

		for(Map node : list){
		    final Map parent = nodes.get(node.get("parentId"));
			if(parent == null){
				((ArrayList<Map>)root.get("children")).add(node);
				continue;
				//throw new RuntimeException("子节点有父级id，却没有找到此父级的对象");
			}else{
				 //添加子节点
				((List<Map>)parent.get("children")).add(node);
			}
		}
		
		int max = 0;
		for(Map node : list){
			max = Math.max(resolveLevel(node, nodes), max);
		}

		return (List<Map>) root.get("children");
	}
	
	//递归找level
	private static  int resolveLevel(final Map node, final Map<String, Map> nodes){
//		System.out.println(node.getIntValue("level"));
		int level = 1;
		if(node != null){
		    level = (int) node.get("level");
		    if(level == -2){
		        throw new RuntimeException("Node循环了, id=" + node.get("id"));
		    }
		    if(level == -1){
		    	node.put("level", -2);
		        level = resolveLevel(nodes.get(node.get("parentId")),nodes) +1;
		        node.put("level", level);
		    }else{
		    	node.put("hasChild", true);
		    }
		}
	    return level;
	}
	
}
