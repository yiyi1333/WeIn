package cn.edu.zjut.action;

import cn.edu.zjut.service.CollectionService;

public class CollectionAction {
    private CollectionService collectionService;
    private String customerId;//用户Id
    private String goodsId;//商品Id
    private String status;//状态

    public CollectionService getCollectionService() {
        return collectionService;
    }

    public void setCollectionService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String addCollection(){
        if(collectionService.addCollection(Integer.parseInt(customerId), Integer.parseInt(goodsId))){
            status = "加入收藏夹成功";
        }
        else{
            status = "加入收藏夹失败";
        }
        return "success";
    }
}
