package com.hbdl.web.sys.model;

import com.hbdl.common.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name ="PathArchivesFileType")
public class PathArchivesFileType extends BaseEntity implements Serializable {
    /**
     * 文件类型ID
     */
    @Id
    @Column(name ="ArchivesFileTypeID")
    private BigDecimal archivesFileTypeID;

    /**
     * 文件类型名称
     */
    @Column(name ="ArchivesFileTypeName")
    private String archivesFileTypeName;

    private static final long serialVersionUID = 1L;

    public void setArchivesFileTypeID(BigDecimal archivesFileTypeID) {
        this.set("archivesFileTypeID",archivesFileTypeID);
    }

    public BigDecimal getArchivesFileTypeID() {
        return this.getBigDecimal("archivesFileTypeID");
    }

    public void setArchivesFileTypeName(String archivesFileTypeName) {
        this.set("archivesFileTypeName",archivesFileTypeName);
    }

    public String getArchivesFileTypeName() {
        return this.getString("archivesFileTypeName");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(", archivesFileTypeID=").append(this.getArchivesFileTypeID());
        sb.append(", archivesFileTypeName=").append(this.getArchivesFileTypeName());
        sb.append("]");
        return sb.toString();
    }
}