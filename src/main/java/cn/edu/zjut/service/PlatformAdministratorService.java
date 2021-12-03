package cn.edu.zjut.service;

import cn.edu.zjut.dao.PlatformAdministratorImpl;
import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.PlatformAdministrator;

import java.util.List;

public class PlatformAdministratorService {
    private PlatformAdministratorImpl platformAdministratorImpl;

    public PlatformAdministratorImpl getPlatformAdministratorImpl() {
        return platformAdministratorImpl;
    }

    public void setPlatformAdministratorImpl(PlatformAdministratorImpl platformAdministratorImpl) {
        this.platformAdministratorImpl = platformAdministratorImpl;
    }

    public PlatformAdministrator login(PlatformAdministrator platformAdministrator) {
        System.out.println("execute --login()-- method.");

        List<PlatformAdministrator> administratorList = platformAdministratorImpl.getAllPlatformAdministrator();
        for (PlatformAdministrator administrator : administratorList) {
            if (administrator.getAdminAccount().equals(platformAdministrator.getAdminAccount()) && administrator.getAdminPassword().equals(platformAdministrator.getAdminPassword())) {
                return administrator;
            }
        }
        return null;
    }
}
