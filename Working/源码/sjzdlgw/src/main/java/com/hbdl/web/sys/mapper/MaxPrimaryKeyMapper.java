package com.hbdl.web.sys.mapper;

import com.hbdl.web.sys.model.MaxPrimaryKey;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.HashMap;

public interface MaxPrimaryKeyMapper extends Mapper<MaxPrimaryKey> {

    /**
     * 查询最大当前表最大ID，并锁定此列
     * @param TabName
     * @return
     */
    BigDecimal selectMaxIdVal(String TabName);
    BigDecimal selectMaxIdValForTableName(HashMap hashMap);
    BigDecimal selectMaxIdValWithoutLock(String TabName);

    /**
     * 根据tabName更新maxval值
     * @param maxPrimaryKey
     * @return
     */
    int updateMaxIdval(MaxPrimaryKey maxPrimaryKey);
}