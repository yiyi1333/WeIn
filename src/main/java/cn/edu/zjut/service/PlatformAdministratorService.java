package cn.edu.zjut.service;

import cn.edu.zjut.annotation.MyLog;
import cn.edu.zjut.dao.PlatformAdministratorImpl;
import cn.edu.zjut.po.PlatformAdministrator;

import java.util.Objects;

public class PlatformAdministratorService {
    private PlatformAdministratorImpl platformAdministratorImpl;

    public PlatformAdministratorImpl getPlatformAdministratorImpl() {
        return platformAdministratorImpl;
    }

    public void setPlatformAdministratorImpl(PlatformAdministratorImpl platformAdministratorImpl) {
        this.platformAdministratorImpl = platformAdministratorImpl;
    }

    @MyLog
    public PlatformAdministrator login(PlatformAdministrator platformAdministrator) {
        System.out.println("execute --login()-- method.");

        PlatformAdministrator administratorList = platformAdministratorImpl.getPlatformAdministratorByAccount(platformAdministrator.getAdminAccount());
        if (Objects.equals(platformAdministrator.getAdminPassword(), administratorList.getAdminPassword())) {
            return administratorList;
        }
        return null;
    }
}
