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
    //??????????????????
    public String applyForRights(Integer goodsId, Integer goodsNum, String descript, String imagePath, Integer orderId, Integer customerId, String type){
        //??????????????????????????????????????????
        SafeGuardingRights temp = safeGuardingRightsDao.selectSafeGuardingRightsByGoodIdAndOrderId(goodsId, orderId);
        Date date = new Date(System.currentTimeMillis());
        Time time = new Time(date.getTime());
        if(temp != null){
            //???????????????????????????
            return "??????????????????";
        }
        int line = safeGuardingRightsDao.addSafeGuardingRightsRecord(goodsId, goodsNum, descript, imagePath, orderId, type,  "?????????");
        if(line != 0) {
            //????????????????????????????????????????????????
            SafeGuardingRights safe = safeGuardingRightsDao.selectSafeGuardingRightsByGoodIdAndOrderId(goodsId, orderId);
            safeGuardingRightsProgressDao.addSafeGuardingRightsProgress("?????????", time, date, safe.getSafeGuardingRightsId());
            return "????????????";
        }
        return "????????????";
    }


    //?????????????????????????????????
    public List<ShowSafeGuardingRights> selectAllRightsInfo(Integer consumerId){
        return safeGuardingRightsDao.selsectAllRightsInfo(consumerId);
    }

    //???????????????????????????
    public String acceptResult(Integer rightsId){
        if(safeGuardingRightsDao.modfiySafeGuardingRightsById(rightsId, "?????????") != 0){
            Date date = new java.sql.Date(System.currentTimeMillis());
            Time time = new Time(date.getTime());
            safeGuardingRightsProgressDao.addSafeGuardingRightsProgress("?????????",time, date, rightsId);
            return "?????????";
        }
        else{
            return "????????????";
        }
    }

    //???????????????????????????
    public String refuseResult(Integer rightsId){
        if(safeGuardingRightsDao.modfiySafeGuardingRightsById(rightsId, "???????????????") != 0){
            Date date = new java.sql.Date(System.currentTimeMillis());
            Time time = new Time(date.getTime());
            safeGuardingRightsProgressDao.addSafeGuardingRightsProgress("???????????????",time, date, rightsId);
            return "?????????";
        }
        else{
            return "????????????";
        }
    }
}
