package cn.edu.zjut.service;

import cn.edu.zjut.annotation.MyLog;
import cn.edu.zjut.dao.CollectionMapper;
import cn.edu.zjut.dao.ConsumerMapper;
import cn.edu.zjut.dao.ElectronicContractsMapper;
import cn.edu.zjut.dao.GoodsMapper;
import cn.edu.zjut.po.Collection;
import cn.edu.zjut.po.ElectronicContracts;
import cn.edu.zjut.po.EnterpriseConsumer;
import cn.edu.zjut.po.Goods;

import java.util.Date;
import java.util.List;

public class GoodsService {
    private ConsumerMapper consumerDao;
    private GoodsMapper goodsDao;
    private ElectronicContractsMapper electronicContractsDao;
    private CollectionMapper collectionDao;
    public ElectronicContractsMapper getElectronicContractsDao() {
        return electronicContractsDao;
    }

    public CollectionMapper getCollectionDao() {
        return collectionDao;
    }

    public void setCollectionDao(CollectionMapper collectionDao) {
        this.collectionDao = collectionDao;
    }

    public void setElectronicContractsDao(ElectronicContractsMapper electronicContractsDao) {
        this.electronicContractsDao = electronicContractsDao;
    }

    public ConsumerMapper getConsumerDao() {
        return consumerDao;
    }

    public void setConsumerDao(ConsumerMapper consumerDao) {
        this.consumerDao = consumerDao;
    }

    public GoodsMapper getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsMapper goodsDao) {
        this.goodsDao = goodsDao;
    }


    public List<Goods> searchGoodsByTagsAndName(String keyword) {
        List<Goods> goodlist = goodsDao.searchGoodsByKeyWord(keyword);
        return goodlist;
    }

    public List<Goods> getAllGoods() {
        System.out.println("execute --getAllGoods()-- method.");
        return goodsDao.getAllGoods();
    }

    public Goods getGoodById(Integer goodid, String customerId) {
        //查询企业员工权限
        EnterpriseConsumer enterpriseConsumer = consumerDao.searchEnterpriseConsumerById(Integer.parseInt(customerId));
        Goods goods = goodsDao.getGoodById(goodid);
        //查询是否收藏
        Collection collection = collectionDao.selectBycustomerIdAndgoodsId(Integer.parseInt(customerId), goodid);
        if(collection != null){
            goods.setCollected(1);
        }
        if (enterpriseConsumer.getEnterpriseDepartment().getEnterpriseDepartmentId() != 0) {
            //查询该商品id的departmentId的记录
            Date date = new Date();
            ElectronicContracts electronicContracts = electronicContractsDao.queryElectronicContractsByGoodsIdAndDepartmentId(goodid, enterpriseConsumer.getEnterpriseDepartment().getEnterpriseDepartmentId(), date);
            System.out.println(electronicContracts);
            if (electronicContracts != null) {
                //有折扣
                double realPrice = goods.getGoodsPrice() * electronicContracts.getDiscount();
                realPrice = (double) Math.round(realPrice * 100) / 100;
                goods.setGoodsRealPrice(realPrice);
            }
        }
        return goods;
    }

    @MyLog
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    public Goods getGoodsById(int goodsId) {
        List<Goods> goodsList = goodsDao.getAllGoods();
        for (Goods goods : goodsList) {
            if (goods.getGoodsId() == goodsId) {
                return goods;
            }
        }
        return null;
    }

    @MyLog
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    public List<Goods> selectGoods(Goods goods) {
        return goodsDao.selectGoods(goods);
    }

    @MyLog
    public void deleteGoods(Integer goodid) {
        goodsDao.deleteGoods(goodid);
    }

    public List<Goods> selectGoodsByWarehouseId(Integer warehouseId) {
        return goodsDao.selectGoodsByWarehouseId(warehouseId);
    }
}
