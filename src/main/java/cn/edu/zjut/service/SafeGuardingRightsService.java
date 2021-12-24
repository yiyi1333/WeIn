package cn.edu.zjut.service;

import cn.edu.zjut.dao.ConsumerMapper;
import cn.edu.zjut.dao.ElectronicContractsMapper;
import cn.edu.zjut.dao.SafeGuardingRightsMapper;
import cn.edu.zjut.po.EnterpriseConsumer;

import java.util.List;

public class SafeGuardingRightsService {
    private SafeGuardingRightsMapper safeGuardingRightsDao;
    private ConsumerMapper consumerDao;

    public ConsumerMapper getConsumerDao() {
        return consumerDao;
    }

    public void setConsumerDao(ConsumerMapper consumerDao) {
        this.consumerDao = consumerDao;
    }

    public SafeGuardingRightsMapper getSafeGuardingRightsDao() {
        return safeGuardingRightsDao;
    }

    public void setSafeGuardingRightsDao(SafeGuardingRightsMapper safeGuardingRightsDao) {
        this.safeGuardingRightsDao = safeGuardingRightsDao;
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
