package cn.edu.zjut.service;

import cn.edu.zjut.dao.GoodsMapper;
import cn.edu.zjut.dao.OrderGoodMapper;
import cn.edu.zjut.dao.OrdersMapper;
import cn.edu.zjut.dao.safeGuardingRightsMapper;
import cn.edu.zjut.po.OrderGood;
import cn.edu.zjut.po.safeGuardingRights;

import java.util.ArrayList;
import java.util.List;

public class safeGuardingRightsService {
    private safeGuardingRightsMapper safeGuardingRightsDao;
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

    public safeGuardingRightsMapper getSafeGuardingRightsDao() {
        return safeGuardingRightsDao;
    }

    public void setSafeGuardingRightsDao(safeGuardingRightsMapper safeGuardingRightsDao) {
        this.safeGuardingRightsDao = safeGuardingRightsDao;
    }

    public List<safeGuardingRights> getAllsafeGuardingRights(){
        List<safeGuardingRights> safeGuardingRightslist = safeGuardingRightsDao.getAllsafeGuardingRights();
        List<safeGuardingRights> safeGuardingRightslist1 = new ArrayList<safeGuardingRights>();
        for(safeGuardingRights safeGuardingRights : safeGuardingRightslist){
            safeGuardingRights.setSafeGuardingRightsProgresslist(safeGuardingRightsDao.getsafeGuardingRightsProgressById(safeGuardingRights.getSafeGuardingRightsId()));
            safeGuardingRightslist1.add(safeGuardingRights);
        }
        return safeGuardingRightslist1;
    }

    public safeGuardingRights selectsafeGuardingRightsById(Integer safeGuardingRightsId) {
        safeGuardingRights safeGuardingRights = safeGuardingRightsDao.selectsafeGuardingRightsById(safeGuardingRightsId);
        safeGuardingRights.setSafeGuardingRightsProgresslist(safeGuardingRightsDao.getsafeGuardingRightsProgressById(safeGuardingRights.getSafeGuardingRightsId()));
        return safeGuardingRights;
    }

    public List<safeGuardingRights> selectsafeGuardingRights(safeGuardingRights safeGuardingRights1) {
        List<safeGuardingRights> safeGuardingRightslist = safeGuardingRightsDao.selectsafeGuardingRights(safeGuardingRights1);
        List<safeGuardingRights> safeGuardingRightslist1 = new ArrayList<safeGuardingRights>();
        for(safeGuardingRights safeGuardingRights : safeGuardingRightslist){
            safeGuardingRights.setSafeGuardingRightsProgresslist(safeGuardingRightsDao.getsafeGuardingRightsProgressById(safeGuardingRights.getSafeGuardingRightsId()));
            safeGuardingRightslist1.add(safeGuardingRights);
        }
        return safeGuardingRightslist1;
    }

    public List<safeGuardingRights> selectsafeGuardingRightsByZyx(safeGuardingRights safeGuardingRights1) {
        List<safeGuardingRights> safeGuardingRightslist = safeGuardingRightsDao.selectsafeGuardingRights(safeGuardingRights1);
        List<safeGuardingRights> safeGuardingRightslist1 = new ArrayList<safeGuardingRights>();
        for(safeGuardingRights safeGuardingRights : safeGuardingRightslist){
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

    public void updatesafeGuardingRights(safeGuardingRights safeGuardingRights) {
        safeGuardingRightsDao.updatesafeGuardingRights(safeGuardingRights);
    }
    //提交维权申请
    public String applyForRights(Integer goodsId, Integer goodsNum, String descript, String imagePath, Integer orderId, Integer customerId, String type){
//        int consumerFlag = 0;
//        //查询该用户类型
//        EnterpriseConsumer enterpriseConsumer = consumerDao.searchEnterpriseConsumerById(customerId);
//        if(enterpriseConsumer.getEnterpriseDepartment().getEnterpriseDepartmentId() != 0){
//            //企业用户
//            consumerFlag = 1;
//        }
        //查询该商品是否正处于维权状态
        List list = safeGuardingRightsDao.selectSafeGuardingRightsByGoodId(goodsId);
        if(list.size() > 0){
            //商品已经在维权处理
            return "申请在处理中";
        }
        int line = safeGuardingRightsDao.addSafeGuardingRightsRecord(goodsId, goodsNum, descript, imagePath, orderId, type,  "申请中");
        if(line != 0) {
            return "申请成功";
        }
        return "申请失败";
    }
}
