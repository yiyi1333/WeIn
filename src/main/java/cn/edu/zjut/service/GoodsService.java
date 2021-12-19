package cn.edu.zjut.service;

import cn.edu.zjut.dao.ConsumerMapper;
import cn.edu.zjut.dao.ElectronicContractsMapper;
import cn.edu.zjut.dao.GoodsMapper;
import cn.edu.zjut.dao.GoodsImpl;
import cn.edu.zjut.po.ElectronicContracts;
import cn.edu.zjut.po.EnterpriseConsumer;
import cn.edu.zjut.po.Goods;

import java.util.List;

public class GoodsService {
    private ConsumerMapper consumerDao;
    private GoodsMapper goodsDao;
    private ElectronicContractsMapper electronicContractsDao;

    public ElectronicContractsMapper getElectronicContractsDao() {
        return electronicContractsDao;
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
    public Goods getGoodById(Integer goodid, String customerId){
        //查询企业员工权限
        EnterpriseConsumer enterpriseConsumer = consumerDao.searchEnterpriseConsumerById(Integer.parseInt(customerId));
        Goods goods = goodsDao.getGoodById(goodid);
        if(enterpriseConsumer.getEnterpriseDepartment().getEnterpriseDepartmentId() != 0){
            //查询该商品id的departmentId的记录
            ElectronicContracts electronicContracts = electronicContractsDao.queryElectronicContractsByGoodsIdAndDepartmentId
                    (goodid, enterpriseConsumer.getEnterpriseDepartment().getEnterpriseDepartmentId());
            if(electronicContracts != null){
                //有折扣
                goods.setGoodsRealPrice(goods.getGoodsPrice() * electronicContracts.getDiscount());
            }
        }
        return goods;
    }

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

    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    public List<Goods> selectGoods(Goods goods){
        return goodsDao.selectGoods(goods);
    }

    public void deleteGoods(Integer goodid){
        goodsDao.deleteGoods(goodid);
    }

    public List<Goods> selectGoodsByWarehouseId(Integer warehouseId){
        return goodsDao.selectGoodsByWarehouseId(warehouseId);
    }
}
