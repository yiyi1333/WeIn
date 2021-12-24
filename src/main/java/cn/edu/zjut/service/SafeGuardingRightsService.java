package cn.edu.zjut.service;

import cn.edu.zjut.dao.SafeGuardingRightsMapper;
import cn.edu.zjut.dao.SafeGuardingRightsProgressMapper;
import cn.edu.zjut.po.SafeGuardingRights;
import cn.edu.zjut.po.SafeGuardingRightsProgress;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class safeGuardingRightsService {
    private SafeGuardingRightsMapper safeGuardingRightsDao;
    private SafeGuardingRightsProgressMapper safeGuardingRightsProgressDao;

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
            SafeGuardingRightsProgress safeProgress = new SafeGuardingRightsProgress();
            safeProgress.setSafeGuardingRightsId(safe.getSafeGuardingRightsId());
            safeProgress.setSafeGuardingRightsProgressDate(date);
            safeProgress.setSafeGuardingRightsProgressTime(time);
            safeProgress.setSafeGuardingRightsProgressStatus("申请中");
            return "申请成功";
        }
        return "申请失败";
    }
}
