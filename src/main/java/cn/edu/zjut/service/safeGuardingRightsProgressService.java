package cn.edu.zjut.service;


import cn.edu.zjut.dao.SafeGuardingRightsProgressMapper;
import cn.edu.zjut.po.SafeGuardingRightsProgress;

import java.util.List;

public class safeGuardingRightsProgressService {
    private SafeGuardingRightsProgressMapper safeGuardingRightsProgressDao;

    public SafeGuardingRightsProgressMapper getSafeGuardingRightsProgressDao() {
        return safeGuardingRightsProgressDao;
    }

    public void setSafeGuardingRightsProgressDao(SafeGuardingRightsProgressMapper safeGuardingRightsProgressDao) {
        this.safeGuardingRightsProgressDao = safeGuardingRightsProgressDao;
    }

    public List<SafeGuardingRightsProgress> getSafeGuardingRightsProgressById(Integer safeGuardingRightsProgressId){
        return safeGuardingRightsProgressDao.getsafeGuardingRightsProgressById(safeGuardingRightsProgressId);
    }

    public void addsafeGuardingRightsProgress(SafeGuardingRightsProgress safeGuardingRightsProgress){
        safeGuardingRightsProgressDao.addsafeGuardingRightsProgress(safeGuardingRightsProgress);
    }
}
