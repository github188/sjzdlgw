package com.hbdl.common.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbdl.common.spring.utils.SpringContextHolder;
import com.hbdl.web.sys.mapper.MaxPrimaryKeyMapper;
import com.hbdl.web.sys.model.MaxPrimaryKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ServiceMybatis<T extends BaseEntity> implements BaseService<T> {

	@Autowired
	protected Mapper<T> mapper;

	@Autowired
	protected MaxPrimaryKeyMapper maxPrimaryKeyMapper;
	
	/**
	 * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
	 * @param record 实体类
	 */
	public List<T> select(T record) {
		return mapper.select(record);
	}
	
	/**
	 * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
	 * @param record 实体类
	 */
	public T selectOne(T record) {
		return mapper.selectOne(record);
	}
	
	public List<T> select(T record,String orderSqlStr){
		Example example = new Example(record.getClass(),false);
		Criteria criteria = example.createCriteria();
//		criteria.andEqualTo("delFlag", Constant.DEL_FLAG_NORMAL);
		for(Map.Entry<String, Object> entry : record.entrySet()){
			if("".equals(entry.getValue())) continue;
			criteria.andEqualTo(entry.getKey(), entry.getValue());
		}
		example.setOrderByClause(orderSqlStr);
		return mapper.selectByExample(example);
	}
	
	/**
	 * 根据实体类不为null的字段查询总数,条件全部使用=号and条件
	 * @param record 实体类
	 */
	public int selectCount(T record) {
		return mapper.selectCount(record);
	}
	
	/**
	 * 根据Example条件查询
	 * @param example
	 * @return
	 */
	public int selectCount(Example example) {
		return mapper.selectCountByExample(example);
	}

	/**
	 * 根据主键进行查询,必须保证结果唯一 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
	 * 
	 * @param key 主键
	 */
	public T selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	/**
	 * 插入一条数据 支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
	 * 优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
	 * 
	 * @param record 实体类
	 */
	public int insert(T record) {
		return mapper.insert(record);
	}

	/**
	 * 插入一条数据,只插入不为null的字段,不会影响有默认值的字段
	 * 支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
	 * 优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
	 * 
	 * @param record 实体类
	 */
	public int insertSelective(T record) {

		return mapper.insertSelective(record);
	}

	/**
	 * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
	 * 
	 * @param key 主键
	 */
	public int delete(T key) {
		return mapper.delete(key);
	}

	/**
	 * 通过主键进行删除,这里最多只会删除一条数据 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
	 * 
	 * @param key 主键
	 */
	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	/**
	 * 根据主键进行更新,这里最多只会更新一条数据 参数为实体类
	 * 
	 * @param record 实体类
	 */
	public int updateByPrimaryKey(T record) {
//		SysUser sysUser = SysUserUtils.getCacheLoginUser();
//		if(sysUser != null){
//			record.set("updateBy",sysUser.getId()+","+
//					SysUserUtils.getCacheLoginUser().getName());
//		}
//		record.set("updateDate", new Date());
		return mapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据主键进行更新 只会更新不是null的数据
	 * 
	 * @param record 实体类
	 */
	public int updateByPrimaryKeySelective(T record) {
//		record.set("updateBy",SysUserUtils.getCacheLoginUser().getId()+","+
//				SysUserUtils.getCacheLoginUser().getName());
//		record.set("updateDate", new Date());
		return mapper.updateByPrimaryKeySelective(record);
	}
	
	
	public int updateByExample(T record, Example example) {
		return mapper.updateByExample(record, example);
	}
	
	/**
	 * 根据自定义条件，更新record不为空的字段
	 * @param record
	 * @param example
	 * @return
	 */
	public int updateByExampleSelective(T record, Example example) {
		return mapper.updateByExampleSelective(record, example);
	}

	/**
	 * 保存
	 * 
	 * @param record
	 * @return 影响行数
	 */
	@Transactional
	public int save(T record) {
		return this.insertSelective(record);
	}

	/**
	 * 单表分页
	 * @param pageNum 页码
	 * @param pageSize 条数
	 * @param record 条件实体
	 * @return
	 */
	public PageInfo<T> selectPage(int pageNum, int pageSize, T record) {
//		record.set("delFlag", Constant.DEL_FLAG_NORMAL);
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<T>(mapper.select(record));
	}
	
	/**
	 * @Description:(单表分页可排序)  and  ke=1  or ( ke=2 and   )
	 * @param:@param pageNum
	 * @param:@param pageSize
	 * @param:@param record
	 * @param:@param orderSqlStr (如:id desc)
	 * @return:PageInfo<T>
	 */
	public PageInfo<T> selectPage(int pageNum, int pageSize, T record,String orderSqlStr) {
		Example example = new Example(record.getClass(),false);
		Criteria criteria = example.createCriteria();
//		criteria.andEqualTo("delFlag", Constant.DEL_FLAG_NORMAL);
		for(Map.Entry<String, Object> entry : record.entrySet()){
			if("".equals(entry.getValue())) continue;
			criteria.andEqualTo(entry.getKey(), entry.getValue());
		}
		if(orderSqlStr != null && orderSqlStr.length() > 0){
			example.setOrderByClause(orderSqlStr);
		}
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = mapper.selectByExample(example);
		return new PageInfo<T>(list);
	}
	
	/**
	 * 根据条件查询分页， 查询条件自定义
	 * @param pageNo
	 * @param pageSize
	 * @param example
	 * @return
	 */
	public PageInfo<T> selectPageByExample(Integer pageNo, Integer pageSize, Example example){
		
		pageNo = pageNo== null ? 1 : pageNo;
		pageSize = pageSize== null ? 20 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		
		List<T> list = mapper.selectByExample(example);
		return new PageInfo<T>(list);
	}

	/**
	 * 删除前验证是否有关联(仅限于单表)
	* @param bean 实体class
	* @param params 属性名+值
	* @return -1有关联
	 */
	public <M extends BaseEntity> int beforeDelete(Class<M> bean, Map<String, Object> params){
		String mapperName = StringUtils.uncapitalize(bean.getSimpleName())+"Mapper"; 
		Mapper<M> mapper = SpringContextHolder.getBean(mapperName);
		M m = null;
		try {
			m = bean.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		m.setAll(params);
		int count = mapper.selectCount(m);
		return count>0 ? -1:count;
	}

	/**
	 * Example查询
	 * @param example
	 * @return
	 */
	@Override
	public List<T> selectByExample(Example example) {
		return mapper.selectByExample(example);
	}

	/**
	 * 先生成Maxid在保存
	 * @param record
	 * @param TabName 表明
	 * @param idName  model中主键属性名称
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int saveBeforeSelectMaxIdVal(T record, String TabName,String idName){
		int count=-1;
		BigDecimal id=saveBeforeSelectMaxIdValToID(record,TabName,idName);
		if (id!=null && id.longValue()>0){
			count=1;
		}
		return count;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public BigDecimal saveBeforeSelectMaxIdValToID(T record, String TabName, String idName) {
         BigDecimal id=null;
		//先根据tabName查询MaxId
		if (StringUtils.isNotEmpty(TabName)){
			BigDecimal maxId=maxPrimaryKeyMapper.selectMaxIdVal(TabName);
			HashMap<String,String> hashMap=new HashMap<>();
			hashMap.put("Id",idName);
			hashMap.put("TabName",TabName);
			BigDecimal tabMaxId=maxPrimaryKeyMapper.selectMaxIdValForTableName(hashMap);
			if (tabMaxId != null && tabMaxId.compareTo(maxId)>0){
				maxId=tabMaxId;
			}
			maxId=maxId.add(new BigDecimal(1l));
			id=maxId;
			MaxPrimaryKey maxPrimaryKey=new MaxPrimaryKey();
			maxPrimaryKey.setTabName(TabName);
			maxPrimaryKey.setMaxVal(maxId);
			//保存
			record.set(idName,maxId);
			mapper.insertSelective(record);
			maxPrimaryKeyMapper.updateMaxIdval(maxPrimaryKey);
		}
		return id;
	}

	/**
	 * 增加指定表主键值
	 * @param TabName
	 * @param idName
	 * @return
	 */
	public BigDecimal updateTableId(String TabName, String idName){
		BigDecimal id=null;
		if (StringUtils.isNotEmpty(TabName)){
			BigDecimal maxId=maxPrimaryKeyMapper.selectMaxIdVal(TabName);
			HashMap<String,String> hashMap=new HashMap<>();
			hashMap.put("Id",idName);
			hashMap.put("TabName",TabName);
			BigDecimal tabMaxId=maxPrimaryKeyMapper.selectMaxIdValForTableName(hashMap);
			if (tabMaxId != null && tabMaxId.compareTo(maxId)>0){
				maxId=tabMaxId;
			}
			maxId=maxId.add(new BigDecimal(1l));
			id=maxId;
			MaxPrimaryKey maxPrimaryKey=new MaxPrimaryKey();
			maxPrimaryKey.setTabName(TabName);
			maxPrimaryKey.setMaxVal(maxId);
			maxPrimaryKeyMapper.updateMaxIdval(maxPrimaryKey);
		}
		return id;
	}
}
