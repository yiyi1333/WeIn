package cn.edu.zjut.action;

import cn.edu.zjut.service.SafeGuardingRightsService;

public class SafeGuardingRightsAction {
    private String goodsId;
    private String goodsNum;
    private String descript;
    private String imagePath;
    private String consumerId;
    private String orderId;
    private String statusMes;

    public String getStatusMes() {
        return statusMes;
    }

    public void setStatusMes(String statusMes) {
        this.statusMes = statusMes;
    }

    private SafeGuardingRightsService safeGuardingRightsService;

    public SafeGuardingRightsService getSafeGuardingRightsService() {
        return safeGuardingRightsService;
    }

    public void setSafeGuardingRightsService(SafeGuardingRightsService safeGuardingRightsService) {
        this.safeGuardingRightsService = safeGuardingRightsService;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String applyForRights(){
        System.out.println("goodsId: " + goodsId);
        System.out.println("goodsNum: " + goodsNum);
        System.out.println("descript: " + descript);
        System.out.println("imagePath: " + imagePath);
        System.out.println("consumerId: " + consumerId);
        System.out.println("orderId: " + orderId);
        if(safeGuardingRightsService.applyForRights(Integer.parseInt(goodsId), Integer.parseInt(goodsNum), descript, imagePath, Integer.parseInt(orderId), Integer.parseInt(consumerId))){
            statusMes = "申请成功";
        }
        else{
            statusMes = "申请提交失败";
        }
        return "success";
    }
}
