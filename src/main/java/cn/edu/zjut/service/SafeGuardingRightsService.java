package cn.edu.zjut.service;

import cn.edu.zjut.dao.ConsumerMapper;
import cn.edu.zjut.dao.ElectronicContractsMapper;
import cn.edu.zjut.dao.SafeGuardingRightsMapper;
import cn.edu.zjut.po.EnterpriseConsumer;

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
    public boolean applyForRights(Integer goodsId, Integer goodsNum, String descript, String imagePath, Integer orderId, Integer customerId){
        boolean flag = false;
//        int consumerFlag = 0;
//        //查询该用户类型
//        EnterpriseConsumer enterpriseConsumer = consumerDao.searchEnterpriseConsumerById(customerId);
//        if(enterpriseConsumer.getEnterpriseDepartment().getEnterpriseDepartmentId() != 0){
//            //企业用户
//            consumerFlag = 1;
//        }
        int line = safeGuardingRightsDao.addSafeGuardingRightsRecord(goodsId, goodsNum, descript, imagePath, orderId, "退款",  "申请中");
        if(line != 0) {
            flag = true;
        }
        return flag;
    }
}
