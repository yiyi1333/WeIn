package cn.edu.zjut.service;


import cn.edu.zjut.dao.safeGuardingRightsProgressMapper;
import cn.edu.zjut.po.safeGuardingRightsProgress;

import java.util.List;

public class safeGuardingRightsProgressService {
    private safeGuardingRightsProgressMapper safeGuardingRightsProgressDao;

    public safeGuardingRightsProgressMapper getSafeGuardingRightsProgressDao() {
        return safeGuardingRightsProgressDao;
    }

    public void setSafeGuardingRightsProgressDao(safeGuardingRightsProgressMapper safeGuardingRightsProgressDao) {
        this.safeGuardingRightsProgressDao = safeGuardingRightsProgressDao;
    }

    public List<safeGuardingRightsProgress> getSafeGuardingRightsProgressById(Integer safeGuardingRightsProgressId){
        return safeGuardingRightsProgressDao.getsafeGuardingRightsProgressById(safeGuardingRightsProgressId);
    }

    public void addsafeGuardingRightsProgress(safeGuardingRightsProgress safeGuardingRightsProgress){
        safeGuardingRightsProgressDao.addsafeGuardingRightsProgress(safeGuardingRightsProgress);
    }
}
