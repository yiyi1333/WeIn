package cn.edu.zjut.service;

import cn.edu.zjut.dao.safeGuardingRightsMapper;
import cn.edu.zjut.po.safeGuardingRights;
import cn.edu.zjut.po.safeGuardingRightsProgress;

import java.util.ArrayList;
import java.util.List;

public class safeGuardingRightsService {
    private safeGuardingRightsMapper safeGuardingRightsDao;

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

    public void updatesafeGuardingRights(safeGuardingRights safeGuardingRights) {
        safeGuardingRightsDao.updatesafeGuardingRights(safeGuardingRights);
    }
}
