package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="AssetBorderType")
public class AssetBorderType extends BaseEntity implements Serializable {
    /**
     * 资产边界类型ID
     */
    @Id
    @Column(name ="AssetBorderTypeID")
    private BigDecimal assetBorderTypeID;

    /**
     * 资产边界名称
     */
    @Column(name ="AssetBorderTypeName")
    private String assetBorderTypeName;

    private static final long serialVersionUID = 1L;

    public void setAssetBorderTypeID(BigDecimal assetBorderTypeID) {
        this.set("assetBorderTypeID",assetBorderTypeID);
    }

    public BigDecimal getAssetBorderTypeID() {
        return this.getBigDecimal("assetBorderTypeID");
    }

    public void setAssetBorderTypeName(String assetBorderTypeName) {
        this.set("assetBorderTypeName",assetBorderTypeName);
    }

    public String getAssetBorderTypeName() {
        return this.getString("assetBorderTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", assetBorderTypeID=").append(this.getAssetBorderTypeID());
        sb.append(", assetBorderTypeName=").append(this.getAssetBorderTypeName());
        sb.append("]");
        return sb.toString();
    }
}