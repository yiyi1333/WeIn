package cn.edu.zjut.action;

import cn.edu.zjut.service.HistoryService;

public class HistoryAction {
    private String customerId;//用户Id
    private String goodsId;//商品Id
    private HistoryService historyService;//历史记录服务类
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HistoryService getHistoryService() {
        return historyService;
    }

    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
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

    public String addBrowsingHistory(){
        if(historyService.addHistory(Integer.parseInt(customerId), Integer.parseInt(goodsId))){
            status = "浏览记录记录成功";
        }
        else{
            status = "浏览记录插入失败";
        }
        return "success";
    }
}
