package com.hbdl.web.sys.api.retMapperClass;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by long on 2016/12/8.
 */
public class PathSectionLayRet {
    /**
     * currentPageNum : 1
     * totalPageNum : 5
     * numPerPage : 10
     * CablePath : [{"pathSectionNum":1234,"pathSectionCode":"20160736-1","pathSectionName":"线路段","placeInfo":"起点","placeInfo2":"止点","beginAssetNum":1234,"beginAssetName":"xxx","endAssetNum":1234,"endAssetName":"xxx","loopCount":1,"lineCount":3,"loopLenght":10.1}]
     */

    private Integer currentPageNum;
    private Long totalPageNum;
    private Integer numPerPage;
    private List<CablePathBean> CablePath;

    public Integer getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(Integer currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public Long getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(Long totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public Integer getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(Integer numPerPage) {
        this.numPerPage = numPerPage;
    }

    public List<CablePathBean> getCablePath() {
        return CablePath;
    }

    public void setCablePath(List<CablePathBean> CablePath) {
        this.CablePath = CablePath;
    }

    public static class CablePathBean {
        /**
         * pathSectionNum : 1234
         * pathSectionCode : 20160736-1
         * pathSectionName : 线路段
         * placeInfo : 起点
         * placeInfo2 : 止点
         * beginAssetNum : 1234
         * beginAssetName : xxx
         * endAssetNum : 1234
         * endAssetName : xxx
         * loopCount : 1
         * lineCount : 3
         * loopLenght : 10.1
         */

        private BigDecimal pathSectionNum;
        private String pathSectionCode;
        private String pathSectionName;
        private String placeInfo;
        private String placeInfo2;
        private BigDecimal beginAssetNum;
        private String beginAssetName;
        private BigDecimal endAssetNum;
        private String endAssetName;
        private BigDecimal loopCount;
        private BigDecimal lineCount;
        private double loopLenght;

        public BigDecimal getPathSectionNum() {
            return pathSectionNum;
        }

        public void setPathSectionNum(BigDecimal pathSectionNum) {
            this.pathSectionNum = pathSectionNum;
        }

        public String getPathSectionCode() {
            return pathSectionCode;
        }

        public void setPathSectionCode(String pathSectionCode) {
            this.pathSectionCode = pathSectionCode;
        }

        public String getPathSectionName() {
            return pathSectionName;
        }

        public void setPathSectionName(String pathSectionName) {
            this.pathSectionName = pathSectionName;
        }

        public String getPlaceInfo() {
            return placeInfo;
        }

        public void setPlaceInfo(String placeInfo) {
            this.placeInfo = placeInfo;
        }

        public String getPlaceInfo2() {
            return placeInfo2;
        }

        public void setPlaceInfo2(String placeInfo2) {
            this.placeInfo2 = placeInfo2;
        }

        public BigDecimal getBeginAssetNum() {
            return beginAssetNum;
        }

        public void setBeginAssetNum(BigDecimal beginAssetNum) {
            this.beginAssetNum = beginAssetNum;
        }

        public String getBeginAssetName() {
            return beginAssetName;
        }

        public void setBeginAssetName(String beginAssetName) {
            this.beginAssetName = beginAssetName;
        }

        public BigDecimal getEndAssetNum() {
            return endAssetNum;
        }

        public void setEndAssetNum(BigDecimal endAssetNum) {
            this.endAssetNum = endAssetNum;
        }

        public String getEndAssetName() {
            return endAssetName;
        }

        public void setEndAssetName(String endAssetName) {
            this.endAssetName = endAssetName;
        }

        public BigDecimal getLoopCount() {
            return loopCount;
        }

        public void setLoopCount(BigDecimal loopCount) {
            this.loopCount = loopCount;
        }

        public BigDecimal getLineCount() {
            return lineCount;
        }

        public void setLineCount(BigDecimal lineCount) {
            this.lineCount = lineCount;
        }

        public double getLoopLenght() {
            return loopLenght;
        }

        public void setLoopLenght(double loopLenght) {
            this.loopLenght = loopLenght;
        }
    }
}
