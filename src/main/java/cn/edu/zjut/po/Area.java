package cn.edu.zjut.po;

public class Area {
    private int areaId;//地区Id
    private String areaCode;//地区编码
    private String areaName;//地区名
    private int level;//地区级别（1:省份province,2:市city,3:区县district,4:街道street）
    private String cityCode;//城市编码
    private String center;//城市中心点（即：经纬度坐标）
    private int parentId ;//地区父节点

    public Area(){

    }
    public Area(int areaId,String areaCode,String areaName,int level,String cityCode,String center,int parentId)
    {
        this.areaId=areaId;
        this.areaCode=areaCode;
        this.areaName=areaName;
        this.level=level;
        this.cityCode=cityCode;
        this.center=center;
        this.parentId=parentId;
    }

    public int getAreaId() {
        return areaId;
    }

    public int getLevel() {
        return level;
    }

    public int getParentId() {
        return parentId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getCenter() {
        return center;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
