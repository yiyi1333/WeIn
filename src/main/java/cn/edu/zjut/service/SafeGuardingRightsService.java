package cn.edu.zjut.service;

import cn.edu.zjut.dao.SafeGuardingRightsMapper;
import cn.edu.zjut.dao.SafeGuardingRightsProgressMapper;
import cn.edu.zjut.po.*;
import cn.edu.zjut.dao.GoodsMapper;
import cn.edu.zjut.dao.OrderGoodMapper;
import cn.edu.zjut.dao.OrdersMapper;
import cn.edu.zjut.dao.SafeGuardingRightsMapper;
import cn.edu.zjut.po.SafeGuardingRights;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class SafeGuardingRightsService {
    private SafeGuardingRightsMapper safeGuardingRightsDao;
    private SafeGuardingRightsProgressMapper safeGuardingRightsProgressDao;
    private OrderGoodMapper orderGoodMapper;
    private OrdersMapper ordersMapper;
    private GoodsMapper goodsMapper;

    public GoodsMapper getGoodsMapper() {
        return goodsMapper;
    }

    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    public void setOrderGoodMapper(OrderGoodMapper orderGoodMapper) {
        this.orderGoodMapper = orderGoodMapper;
    }

    public void setOrdersMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    public OrderGoodMapper getOrderGoodMapper() {
        return orderGoodMapper;
    }

    public OrdersMapper getOrdersMapper() {
        return ordersMapper;
    }

    public SafeGuardingRightsProgressMapper getSafeGuardingRightsProgressDao() {
        return safeGuardingRightsProgressDao;
    }

    public void setSafeGuardingRightsProgressDao(SafeGuardingRightsProgressMapper safeGuardingRightsProgressDao) {
        this.safeGuardingRightsProgressDao = safeGuardingRightsProgressDao;
    }

    public SafeGuardingRightsMapper getSafeGuardingRightsDao() {
        return safeGuardingRightsDao;
    }

    public void setSafeGuardingRightsDao(SafeGuardingRightsMapper safeGuardingRightsDao) {
        this.safeGuardingRightsDao = safeGuardingRightsDao;
    }

    public List<SafeGuardingRights> getAllsafeGuardingRights(){
        List<SafeGuardingRights> safeGuardingRightslist = safeGuardingRightsDao.getAllsafeGuardingRights();
        List<SafeGuardingRights> safeGuardingRightslist1 = new ArrayList<SafeGuardingRights>();
        for(SafeGuardingRights safeGuardingRights : safeGuardingRightslist){
            safeGuardingRights.setSafeGuardingRightsProgresslist(safeGuardingRightsDao.getsafeGuardingRightsProgressById(safeGuardingRights.getSafeGuardingRightsId()));
            safeGuardingRightslist1.add(safeGuardingRights);
        }
        return safeGuardingRightslist1;
    }

    public SafeGuardingRights selectsafeGuardingRightsById(Integer safeGuardingRightsId) {
        SafeGuardingRights safeGuardingRights = safeGuardingRightsDao.selectsafeGuardingRightsById(safeGuardingRightsId);
        safeGuardingRights.setSafeGuardingRightsProgresslist(safeGuardingRightsDao.getsafeGuardingRightsProgressById(safeGuardingRights.getSafeGuardingRightsId()));
        return safeGuardingRights;
    }

    public List<SafeGuardingRights> selectsafeGuardingRights(SafeGuardingRights safeGuardingRights1) {
        List<SafeGuardingRights> safeGuardingRightslist = safeGuardingRightsDao.selectsafeGuardingRights(safeGuardingRights1);
        List<SafeGuardingRights> safeGuardingRightslist1 = new ArrayList<SafeGuardingRights>();
        for(SafeGuardingRights safeGuardingRights : safeGuardingRightslist){
            safeGuardingRights.setSafeGuardingRightsProgresslist(safeGuardingRightsDao.getsafeGuardingRightsProgressById(safeGuardingRights.getSafeGuardingRightsId()));
            safeGuardingRightslist1.add(safeGuardingRights);
        }
        return safeGuardingRightslist1;
    }

    public List<SafeGuardingRights> selectsafeGuardingRightsByZyx(SafeGuardingRights safeGuardingRights1) {
        List<SafeGuardingRights> safeGuardingRightslist = safeGuardingRightsDao.selectsafeGuardingRights(safeGuardingRights1);
        List<SafeGuardingRights> safeGuardingRightslist1 = new ArrayList<SafeGuardingRights>();
        for(SafeGuardingRights safeGuardingRights : safeGuardingRightslist){
            safeGuardingRights.setSafeGuardingRightsProgresslist(safeGuardingRightsDao.getsafeGuardingRightsProgressById(safeGuardingRights.getSafeGuardingRightsId()));
            safeGuardingRights.setOrders(ordersMapper.selectOrdersById(safeGuardingRights.getOrderId()));
            safeGuardingRights.setGoods(goodsMapper.getGoodById(safeGuardingRights.getGoodId()));
            OrderGood orderGood = new OrderGood();
            orderGood.setGoodId(safeGuardingRights.getGoodId());
            orderGood.setOrderId(safeGuardingRights.getOrderId());
            safeGuardingRights.setOrderGood(orderGoodMapper.selectOrderGood(orderGood));
            safeGuardingRightslist1.add(safeGuardingRights);
        }
        return safeGuardingRightslist1;
    }

    public void updatesafeGuardingRights(SafeGuardingRights safeGuardingRights) {
        safeGuardingRightsDao.updatesafeGuardingRights(safeGuardingRights);
    }
    //提交维权申请
    public String applyForRights(Integer goodsId, Integer goodsNum, String descript, String imagePath, Integer orderId, Integer customerId, String type){
        //查询该商品是否正处于维权状态
        SafeGuardingRights temp = safeGuardingRightsDao.selectSafeGuardingRightsByGoodIdAndOrderId(goodsId, orderId);
        Date date = new Date(System.currentTimeMillis());
        Time time = new Time(date.getTime());
        if(temp != null){
            //商品已经在维权处理
            return "申请在处理中";
        }
        int line = safeGuardingRightsDao.addSafeGuardingRightsRecord(goodsId, goodsNum, descript, imagePath, orderId, type,  "申请中");
        if(line != 0) {
            //查询生成的编号，添加维权历史记录
            SafeGuardingRights safe = safeGuardingRightsDao.selectSafeGuardingRightsByGoodIdAndOrderId(goodsId, orderId);
            safeGuardingRightsProgressDao.addSafeGuardingRightsProgress("申请中", time, date, safe.getSafeGuardingRightsId());
            return "申请成功";
        }
        return "申请失败";
    }


    //获取所以维权状态的订单
    public List<ShowSafeGuardingRights> selectAllRightsInfo(Integer consumerId){
        return safeGuardingRightsDao.selsectAllRightsInfo(consumerId);
    }

    //接受商家的处理结果
    public String acceptResult(Integer rightsId){
        if(safeGuardingRightsDao.modfiySafeGuardingRightsById(rightsId, "已完成") != 0){
            Date date = new java.sql.Date(System.currentTimeMillis());
            Time time = new Time(date.getTime());
            safeGuardingRightsProgressDao.addSafeGuardingRightsProgress("已完成",time, date, rightsId);
            return "已接受";
        }
        else{
            return "接受失败";
        }
    }

    //拒绝商家的处理结果
    public String refuseResult(Integer rightsId){
        if(safeGuardingRightsDao.modfiySafeGuardingRightsById(rightsId, "平台处理中") != 0){
            Date date = new java.sql.Date(System.currentTimeMillis());
            Time time = new Time(date.getTime());
            safeGuardingRightsProgressDao.addSafeGuardingRightsProgress("平台处理中",time, date, rightsId);
            return "已拒绝";
        }
        else{
            return "拒绝失败";
        }
    }
}
